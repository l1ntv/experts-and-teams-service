package ru.rsreu.lint.expertsandteams.Command.Commands.User;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.User.MyTeamDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Common.MainLogic;
import ru.rsreu.lint.expertsandteams.Logic.User.MyTeamLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class MyTeamCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            int userId = (int) session.getAttribute("userId");
            if (MainLogic.isJoinedInTeamByUserId(userId)) {
                int teamId = MainLogic.findTeamIdByUserId(userId);
                MyTeamDTO myTeamDTO = MyTeamLogic.createMyTeamDTOByTeamId(teamId);
                request.setAttribute("myTeam", myTeamDTO);
            } else {
                request.setAttribute("myTeam", null);
            }
            return new Page(ConfigurationManager.getProperty("USER.MY-TEAM.PAGE"), ConfigurationManager.getProperty("USER.MY-TEAM.URL"), DirectTypesEnum.FORWARD, CommandEnum.MY_TEAM);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.LOGIN);
    }
}
