package ru.rsreu.lint.expertsandteams.Command.Commands.Administrator;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Administrator.DeleteUserLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;
import ru.rsreu.lint.expertsandteams.Validation.DataValidator;
import ru.rsreu.lint.expertsandteams.Validation.ValidationData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class DeleteUserCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            String login = request.getParameter(ConfigurationManager.getProperty("LOGIN.PROPERTY.CONST"));
            String adminLogin = (String) session.getAttribute("userLogin");
            ValidationData validationData = DataValidator.validateCreationUserData(login);
            if (validationData.getIsCorrectData()) {
                if (DeleteUserLogic.isUserExistsByLogin(login) && !adminLogin.equals(login)) {
                    AccountsTypesEnum accountsTypesEnum = DeleteUserLogic.searchDeletedUserRoleByLogin(login);
                    switch (accountsTypesEnum) {
                        case USER:
                            if (DeleteUserLogic.isUserJoinedInTeamByLogin(login)) {
                                if (DeleteUserLogic.isUserCaptainInTeamByLogin(login)) {
                                    DeleteUserLogic.decreaseTeamCountsForExpert(login);
                                    DeleteUserLogic.deleteTeamForOtherMembers(login);
                                    DeleteUserLogic.deleteCaptainDataByLogin(login);
                                    DeleteUserLogic.deleteUserFromTeamMembersByLogin(login);
                                    DeleteUserLogic.deleteUserFromUserDataByLogin(login);
                                    // ДОБАВИТЬ ЛОГИКУ УДАЛЕНИЯ ИЗ TEAM_MEMBERS других участников

                                } else {
                                    DeleteUserLogic.deleteUserFromTeamMembersByLogin(login);
                                    DeleteUserLogic.deleteUserFromUserDataByLogin(login);
                                }

                            } else {
                                DeleteUserLogic.deleteUserFromUserDataByLogin(login);
                            }
                            break;
                        case EXPERT:
                            DeleteUserLogic.deleteExpertDataByLogin(login);
                            DeleteUserLogic.deleteUserFromUserDataByLogin(login);
                            break;
                        case MODERATOR:
                            DeleteUserLogic.deleteUserFromUserDataByLogin(login);
                            break;
                        case ADMINISTRATOR:
                            DeleteUserLogic.deleteUserFromUserDataByLogin(login);
                            break;
                    }
                }
                request.setAttribute("isExists", Boolean.FALSE);
                return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.FORWARD, CommandEnum.MAIN);
            }
            request.setAttribute("errorMessage", validationData.getErrorMessage());
            return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.FORWARD, CommandEnum.MAIN);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.REDIRECT_TO_LOGIN);
    }
}
