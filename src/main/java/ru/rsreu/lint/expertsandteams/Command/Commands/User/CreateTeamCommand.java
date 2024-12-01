package ru.rsreu.lint.expertsandteams.Command.Commands.User;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Common.MainLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CreateTeamCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST"));
        boolean isJoinedFlag;
        if (MainLogic.isJoinedInTeamByUserId(userId)) {
            isJoinedFlag = true;
        } else {
            isJoinedFlag = false;
        }
        request.setAttribute(ConfigurationManager.getProperty("IS_JOINED_FLAG.CONST"), isJoinedFlag);
        return new Page(ConfigurationManager.getProperty("USER.CREATE-TEAM.PAGE"), ConfigurationManager.getProperty("USER.CREATE-TEAM.URL"), DirectTypesEnum.FORWARD, CommandEnum.CREATE_USER);
    }
}