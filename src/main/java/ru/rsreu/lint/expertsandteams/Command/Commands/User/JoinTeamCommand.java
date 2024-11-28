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
        if (session != null && session.getAttribute("userId") != null) {
            int userId = (int) session.getAttribute("userId");
            boolean isUserInTeam = false;
            if (JoinTeamLogic.isUserJoinedInTeamByUserId(userId)) {
                isUserInTeam = true;
            } else {
                String teamName = (String) request.getParameter("teamName");
                int teamId = JoinTeamLogic.findTeamIdByTeamName(teamName);
                JoinTeamLogic.changeTeamIdInUserDataTableByUserId(teamId, userId);
                JoinTeamLogic.addNewMemberInTeamMembersTable(userId, teamId);
                JoinTeamLogic.increaseCountMembersInTeamTableByTeamId(teamId);
            }
            session.setAttribute("isUserInTeam", isUserInTeam);
            return new Page(ConfigurationManager.getProperty("USER.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.REDIRECT, CommandEnum.MAIN);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.LOGIN);
    }
}
