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
        if (session != null && session.getAttribute("userId") != null) {
            String login = request.getParameter(ConfigurationManager.getProperty("LOGIN.PROPERTY.CONST"));
            AccountsTypesEnum role = AccountsTypesEnum.valueOf(request.getParameter("role").toUpperCase());
            int roleId = role.getAccountTypeId();
            ValidationData validationData = DataValidator.validateCreationUserData(login);
            if (validationData.getIsCorrectData()) {
                if (!CreateUserLogic.isUserExistsByLogin(login)) {
                    CreateUserLogic.createUserByLogin(login, roleId);
                    if (roleId == 1) {
                        CreateUserLogic.createExpertByLogin(login);
                    }
                    request.setAttribute("isCreated", true);
                    return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.FORWARD, CommandEnum.MAIN);
                }
                request.setAttribute("isExists", Boolean.TRUE);
                return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.FORWARD, CommandEnum.MAIN);
            }
            request.setAttribute("errorMessage", validationData.getErrorMessage());
            return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.FORWARD, CommandEnum.MAIN);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.REDIRECT_TO_LOGIN);
    }
}
