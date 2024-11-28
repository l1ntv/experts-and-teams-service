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

public class CreateNewTeamCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            int captainId = (int) session.getAttribute("userId");
            String teamName = (String) request.getParameter("name");
            if (!CreateTeamLogic.isTeamExistsByName(teamName)) {
                CreateTeamLogic.createTeamInTeamsTable(captainId, teamName);
                int teamId = CreateTeamLogic.findTeamIdByTeamName(teamName);
                CreateTeamLogic.createTeamInTeamMembersTable(captainId, teamId);
                CreateTeamLogic.updateTeamIdFromUserDataTableByUserId(teamId, captainId);
                return new Page(ConfigurationManager.getProperty("USER.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.REDIRECT, CommandEnum.MAIN);
            } else {
                request.setAttribute("flagExists", true);
                request.setAttribute("isJoinedFlag", false);
                return new Page(ConfigurationManager.getProperty("USER.CREATE-TEAM.PAGE"), ConfigurationManager.getProperty("USER.CREATE-TEAM.URL"), DirectTypesEnum.FORWARD, CommandEnum.CREATE_USER);
            }
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.LOGIN);
    }
}
