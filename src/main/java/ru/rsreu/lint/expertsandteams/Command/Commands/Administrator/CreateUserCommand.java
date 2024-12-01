package ru.rsreu.lint.expertsandteams.Command.Commands.Administrator;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Administrator.CreateUserLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;
import ru.rsreu.lint.expertsandteams.Validation.DataValidator;
import ru.rsreu.lint.expertsandteams.Validation.ValidationData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;


public class CreateUserCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        String login = request.getParameter(ConfigurationManager.getProperty("LOGIN.PROPERTY.CONST"));
        AccountsTypesEnum role = AccountsTypesEnum.valueOf(request.getParameter(ConfigurationManager.getProperty("ROLE.CONST")).toUpperCase());
        int roleId = role.getAccountTypeId();
        ValidationData validationData = DataValidator.validateCreationUserData(login);
        if (validationData.getIsCorrectData()) {
            if (!CreateUserLogic.isUserExistsByLogin(login)) {
                CreateUserLogic.createUserByLogin(login, roleId);
                if (roleId == AccountsTypesEnum.EXPERT.getAccountTypeId()) {
                    CreateUserLogic.createExpertByLogin(login);
                }
                request.setAttribute(ConfigurationManager.getProperty("IS_CREATED_FLAG.CONST"), true);
                return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.FORWARD, CommandEnum.MAIN);
            }
            request.setAttribute(ConfigurationManager.getProperty("IS_EXISTS_FLAG.CONST"), true);
            return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.FORWARD, CommandEnum.MAIN);
        }
        request.setAttribute(ConfigurationManager.getProperty("ERROR_MESSAGE.CONST"), validationData.getErrorMessage());
        return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.FORWARD, CommandEnum.MAIN);
    }
}
