package ru.rsreu.lint.expertsandteams.Command.Commands;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Logic.RegistrationLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;
import ru.rsreu.lint.expertsandteams.Validation.LoginAndPasswordValidator;
import ru.rsreu.lint.expertsandteams.Validation.ValidationData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class RegistrationCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        String login = request.getParameter(ConfigurationManager.getProperty("LOGIN.PROPERTY.CONST"));
        String password = request.getParameter(ConfigurationManager.getProperty("PASSWORD.PROPERTY.CONST"));
        LoginAndPasswordValidator validator = new LoginAndPasswordValidator();
        ValidationData validationData = validator.validateAuthenticationData(login, password);
        if (validationData.getIsCorrectData()) {
            if (!RegistrationLogic.isExistsUserData(login, password)) {
                RegistrationLogic.createUser(login, password);
                int userId = RegistrationLogic.getUserIdByLogin(login);
                int groupTypeId = 0;
                boolean isCaptain = false;
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(600);
                session.setAttribute("userId", userId);
                session.setAttribute("groupTypeId", groupTypeId);
                session.setAttribute("isCaptain", isCaptain);
                session.setAttribute("command", CommandEnum.MAIN);
                return new Page(ConfigurationManager.getProperty("USER.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.FORWARD, CommandEnum.MAIN);
            }
            return new Page(ConfigurationManager.getProperty("REGISTRATION.ERROR.USER.PAGE"), ConfigurationManager.getProperty("REGISTRATION.URL"), DirectTypesEnum.FORWARD, CommandEnum.REGISTRATION);
        }
        request.setAttribute("errorMessage", validationData.getErrorMessage());
        return new Page(ConfigurationManager.getProperty("REGISTRATION.ERROR.VALIDATION"), ConfigurationManager.getProperty("REGISTRATION.URL"), DirectTypesEnum.FORWARD, CommandEnum.REGISTRATION);
     }
}
