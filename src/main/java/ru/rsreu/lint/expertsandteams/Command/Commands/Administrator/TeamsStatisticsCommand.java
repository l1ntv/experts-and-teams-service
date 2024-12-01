package ru.rsreu.lint.expertsandteams.Command.Commands.Administrator;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.TeamsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Administrator.TeamsStatisticsLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class TeamsStatisticsCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        List<TeamsStatisticsDTO> list = TeamsStatisticsLogic.getTeamsStatisticList();
        request.setAttribute(ConfigurationManager.getProperty("TEAM_STATISTICS.CONST"), list);
        return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.TEAMS.STATISTICS.PAGE"), ConfigurationManager.getProperty("ADMINISTRATOR.TEAMS.STATISTICS.URL"), DirectTypesEnum.FORWARD, CommandEnum.TEAMS_STATISTICS);
    }
}