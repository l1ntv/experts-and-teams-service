package ru.rsreu.lint.expertsandteams.Logic.Administrator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.TeamsStatisticsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamsStatisticsLogic {
    public static List<TeamsStatisticsDTO> getTeamsStatisticList() throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        ResultSet resultSet = administratorDataDAO.getTeamsStatisticsList();
        List<TeamsStatisticsDTO> list = new ArrayList<>();
        list = TeamsStatisticsLogic.convertResultSetToTeamsStatisticsDTOList(resultSet, list);
        return list;
    }

    private static List<TeamsStatisticsDTO> convertResultSetToTeamsStatisticsDTOList(ResultSet resultSet, List<TeamsStatisticsDTO> list) throws SQLException {
        while (resultSet.next()) {
            TeamsStatisticsDTO teamStatisticsDTO = new TeamsStatisticsDTO();
            teamStatisticsDTO.setName(resultSet.getString("NAME"));
            teamStatisticsDTO.setCaptainLogin(resultSet.getString("LOGIN"));
            teamStatisticsDTO.setMemberCount(resultSet.getInt("COUNT_MEMBERS"));
            teamStatisticsDTO.setMaxMemberCount(resultSet.getInt("MAX_COUNT_MEMBERS"));
            list.add(teamStatisticsDTO);
        }
        return list;
    }
}
