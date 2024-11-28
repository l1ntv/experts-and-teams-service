package ru.rsreu.lint.expertsandteams.Logic.Administrator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.ExpertsStatisticsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpertsStatisticsLogic {
    public static List<ExpertsStatisticsDTO> getExpertsStatisticsList() throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        ResultSet resultSet = administratorDataDAO.getExpertsStatisticsList();
        List<ExpertsStatisticsDTO> list = new ArrayList<>();
        list = ExpertsStatisticsLogic.convertResultSetToExpertsStatisticsDTOList(resultSet, list);
        return list;
    }

    private static List<ExpertsStatisticsDTO> convertResultSetToExpertsStatisticsDTOList(ResultSet resultSet, List<ExpertsStatisticsDTO> list) throws SQLException {
        while (resultSet.next()) {
            ExpertsStatisticsDTO expertsStatisticsDTO = new ExpertsStatisticsDTO();
            expertsStatisticsDTO.setLogin(resultSet.getString("LOGIN"));
            expertsStatisticsDTO.setTeamCount(resultSet.getInt("COUNT_TEAMS"));
            expertsStatisticsDTO.setMaxTeamCount(resultSet.getInt("MAX_COUNT_TEAMS"));
            list.add(expertsStatisticsDTO);
        }
        return list;
    }
}
