package ru.rsreu.lint.expertsandteams.Command.Commands.Administrator;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.ExpertsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Administrator.ExpertsStatisticsLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class ExpertsStatisticsCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        List<ExpertsStatisticsDTO> list = ExpertsStatisticsLogic.getExpertsStatisticsList();
        request.setAttribute(ConfigurationManager.getProperty("EXPERTS_STATISTICS.CONST"), list);
        return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.EXPERTS.STATISTICS.PAGE"), ConfigurationManager.getProperty("ADMINISTRATOR.EXPERTS.STATISTICS.URL"), DirectTypesEnum.FORWARD, CommandEnum.EXPERTS_STATISTICS);
    }
}
