package ru.rsreu.lint.expertsandteams.Command.Commands.Administrator;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.AuthUserDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Administrator.AuthUsersLogic;
import ru.rsreu.lint.expertsandteams.Logic.Administrator.CreateUserLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;
import ru.rsreu.lint.expertsandteams.Validation.DataValidator;
import ru.rsreu.lint.expertsandteams.Validation.ValidationData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CreateUserCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            String login = request.getParameter(ConfigurationManager.getProperty("LOGIN.PROPERTY.CONST"));
            if (DataValidator.validateUserLogin(login)) {
                if (!CreateUserLogic.isUserExistsByLogin(login)) {
                    if (CreateUserLogic.createUserByLogin(login)) {
                        return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.AUTH.USERS.PAGE"), ConfigurationManager.getProperty("ADMINISTRATOR.AUTH.USERS.URL"), DirectTypesEnum.FORWARD, CommandEnum.AUTH_USERS);
                    }
                    return null; // TO DO: create DB-error jsp view
                }
                return null; // TO DO: create error exists-data jsp view
            }
            return null; // TO DO: create error validation-data jsp view
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.LOGIN);
    }
}
