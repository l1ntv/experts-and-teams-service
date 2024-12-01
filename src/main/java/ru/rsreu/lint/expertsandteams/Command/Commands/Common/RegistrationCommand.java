package ru.rsreu.lint.expertsandteams.Command.Commands.Common;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Logic.Common.RegistrationLogic;
import ru.rsreu.lint.expertsandteams.Logic.Common.ViewContentDefiner;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;
import ru.rsreu.lint.expertsandteams.Validation.DataValidator;
import ru.rsreu.lint.expertsandteams.Validation.ValidationData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class RegistrationCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        String login = request.getParameter(ConfigurationManager.getProperty("LOGIN.PROPERTY.CONST"));
        String password = request.getParameter(ConfigurationManager.getProperty("PASSWORD.PROPERTY.CONST"));
        ValidationData validationData = DataValidator.validateAuthenticationData(login, password);
        if (validationData.getIsCorrectData()) {
            if (!RegistrationLogic.isExistsUserData(login, password)) {
                RegistrationLogic.createUser(login, password);
                int userId = RegistrationLogic.getUserIdByLogin(login);
                int groupTypeId = AccountsTypesEnum.USER.getAccountTypeId();
                boolean isCaptain = false;
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(600);
                session.setAttribute(ConfigurationManager.getProperty("USER_ID.CONST"), userId);
                session.setAttribute(ConfigurationManager.getProperty("USER_LOGIN.CONST"), login);
                session.setAttribute(ConfigurationManager.getProperty("GROUP_TYPE_ID.CONST"), groupTypeId);
                session.setAttribute(ConfigurationManager.getProperty("IS_CAPTAIN_FLAG.CONST"), isCaptain);
                String jsp = ViewContentDefiner.defineCorrectJspPageByGroupTypeId(groupTypeId);
                return new Page(jsp, ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.REDIRECT, CommandEnum.MAIN);
            }
            return new Page(ConfigurationManager.getProperty("REGISTRATION.ERROR.USER.PAGE"), ConfigurationManager.getProperty("REGISTRATION.URL"), DirectTypesEnum.FORWARD, CommandEnum.REGISTRATION);
        }
        request.setAttribute(ConfigurationManager.getProperty("ERROR_MESSAGE.CONST"), validationData.getErrorMessage());
        return new Page(ConfigurationManager.getProperty("REGISTRATION.ERROR.VALIDATION"), ConfigurationManager.getProperty("REGISTRATION.URL"), DirectTypesEnum.FORWARD, CommandEnum.REGISTRATION);
    }
}
