package ru.rsreu.lint.expertsandteams.Command.Commands.User;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Common.MainLogic;
import ru.rsreu.lint.expertsandteams.Logic.User.CreateTeamLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CreateTeamCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            int userId = (int) session.getAttribute("userId");
            boolean isJoinedFlag;
            if (MainLogic.isJoinedInTeamByUserId(userId)) {
                isJoinedFlag = true;
            } else {
                isJoinedFlag = false;
            }
            request.setAttribute("isJoinedFlag", isJoinedFlag);
            return new Page(ConfigurationManager.getProperty("USER.CREATE-TEAM.PAGE"), ConfigurationManager.getProperty("USER.CREATE-TEAM.URL"), DirectTypesEnum.FORWARD, CommandEnum.CREATE_USER);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.LOGIN);
    }
}
