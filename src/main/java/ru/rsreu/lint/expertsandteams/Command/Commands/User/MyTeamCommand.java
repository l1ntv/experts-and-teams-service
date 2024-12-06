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
        int userId = (int) session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST"));
        if (MainLogic.isJoinedInTeamByUserId(userId)) {
            int teamId = MainLogic.findTeamIdByUserId(userId);
            MyTeamDTO myTeamDTO = MyTeamLogic.createMyTeamDTOByTeamId(teamId);
            request.setAttribute(ConfigurationManager.getProperty("MY_TEAM.CONST"), myTeamDTO);
        } else {
            request.setAttribute(ConfigurationManager.getProperty("MY_TEAM.CONST"), null);
        }
        request.setAttribute(ConfigurationManager.getProperty("USER_ID.CONST"), session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")));
        return new Page(ConfigurationManager.getProperty("USER.MY-TEAM.PAGE"), ConfigurationManager.getProperty("USER.MY-TEAM.URL"), DirectTypesEnum.FORWARD, CommandEnum.MY_TEAM);
    }
}