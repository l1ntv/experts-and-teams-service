package ru.rsreu.lint.expertsandteams.Command.Commands;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.TeamDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Logic.MainLogic;
import ru.rsreu.lint.expertsandteams.Logic.ViewContentDefiner;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            int groupTypeId = (int) session.getAttribute("groupTypeId");
            String jsp = ViewContentDefiner.defineCorrectJspPageByGroupTypeId(groupTypeId);
            switch (groupTypeId) {
                case 0:
                    List<TeamDTO> list = MainLogic.getListTeams();
                    request.setAttribute("teams", list);
                    break;
            }
            return new Page(jsp, ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.FORWARD, CommandEnum.MAIN);
        }
        else
            return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.REDIRECT_TO_LOGIN);
    }
}
