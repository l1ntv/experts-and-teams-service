package ru.rsreu.lint.expertsandteams.Command.Commands.Administrator;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.ExpertsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.TeamsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Administrator.ExpertsStatisticsLogic;
import ru.rsreu.lint.expertsandteams.Logic.Administrator.TeamsStatisticsLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class ExpertsStatisticsCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            List<ExpertsStatisticsDTO> list = ExpertsStatisticsLogic.getExpertsStatisticsList();
            request.setAttribute("expertsStatistics", list);
            return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.EXPERTS.STATISTICS.PAGE"), ConfigurationManager.getProperty("ADMINISTRATOR.EXPERTS.STATISTICS.URL"), DirectTypesEnum.FORWARD, CommandEnum.EXPERTS_STATISTICS);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.REDIRECT_TO_LOGIN);
    }
}
