package ru.rsreu.lint.expertsandteams.Command.Commands.User;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.User.CreateTeamLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CreateNewTeamCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        int captainId = (int) session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST"));
        String teamName = (String) request.getParameter(ConfigurationManager.getProperty("NAME.CONST"));
        if (!CreateTeamLogic.isTeamExistsByName(teamName)) {
            CreateTeamLogic.createTeamInTeamsTable(captainId, teamName);
            int teamId = CreateTeamLogic.findTeamIdByTeamName(teamName);
            CreateTeamLogic.createTeamInTeamMembersTable(captainId, teamId);
            CreateTeamLogic.updateTeamIdFromUserDataTableByUserId(teamId, captainId);
            return new Page(ConfigurationManager.getProperty("USER.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.REDIRECT, CommandEnum.MAIN);
        } else {
            request.setAttribute(ConfigurationManager.getProperty("FLAG_EXISTS.CONST"), true);
            request.setAttribute(ConfigurationManager.getProperty("IS_JOINED_FLAG.CONST"), false);
            return new Page(ConfigurationManager.getProperty("USER.CREATE-TEAM.PAGE"), ConfigurationManager.getProperty("USER.CREATE-TEAM.URL"), DirectTypesEnum.FORWARD, CommandEnum.CREATE_USER);
        }
    }
}