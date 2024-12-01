package ru.rsreu.lint.expertsandteams.Command.Commands.Moderator;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.UserDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Moderator.BannedUsersLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class BannedUsersCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        List<UserDTO> list = BannedUsersLogic.getBannedUsersList();
        request.setAttribute(ConfigurationManager.getProperty("BANNED_USERS.CONST"), list);
        return new Page(ConfigurationManager.getProperty("MODERATOR.BANNED.USERS.PAGE"), ConfigurationManager.getProperty("MODERATOR.BANNED.USERS.URL"), DirectTypesEnum.FORWARD, CommandEnum.BANNED_USERS);
    }
}