package ru.rsreu.lint.expertsandteams.Command.Commands.User;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.User.JoinTeamLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class JoinTeamCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST"));
        boolean isUserInTeam = false;
        if (JoinTeamLogic.isUserJoinedInTeamByUserId(userId)) {
            isUserInTeam = true;
        } else {
            String teamName = (String) request.getParameter(ConfigurationManager.getProperty("TEAM_NAME.CONST"));
            int teamId = JoinTeamLogic.findTeamIdByTeamName(teamName);
            JoinTeamLogic.changeTeamIdInUserDataTableByUserId(teamId, userId);
            JoinTeamLogic.addNewMemberInTeamMembersTable(userId, teamId);
            JoinTeamLogic.increaseCountMembersInTeamTableByTeamId(teamId);
        }
        session.setAttribute(ConfigurationManager.getProperty("IS_USER_IN_TEAM_FLAG.CONST"), isUserInTeam);
        return new Page(ConfigurationManager.getProperty("USER.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.REDIRECT, CommandEnum.MAIN);
    }
}