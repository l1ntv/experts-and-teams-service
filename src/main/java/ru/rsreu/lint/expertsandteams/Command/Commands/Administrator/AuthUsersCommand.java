package ru.rsreu.lint.expertsandteams.Command.Commands.Administrator;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.UserDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Administrator.AuthUsersLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class AuthUsersCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        List<UserDTO> list = AuthUsersLogic.getAuthUsersList();
        request.setAttribute(ConfigurationManager.getProperty("AUTH.USERS.CONST"), list);
        return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.AUTH.USERS.PAGE"), ConfigurationManager.getProperty("ADMINISTRATOR.AUTH.USERS.URL"), DirectTypesEnum.FORWARD, CommandEnum.AUTH_USERS);
    }
}
