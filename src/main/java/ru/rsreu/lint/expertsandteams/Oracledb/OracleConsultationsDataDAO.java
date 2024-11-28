package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.ConsultationsDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.ExpertsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleConsultationsDataDAO implements ConsultationsDataDAO {
    private Connection connection;

    public OracleConsultationsDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean isUserJoinedInTeamByUserId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("ConsultationsDataDAO.IS_USER_JOINED_IN_TEAM_BY_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        preparedStatement.close();
        resultSet.close();
        return false;
    }

    @Override
    public int findTeamIdByUserId(int userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("ConsultationsDataDAO.FIND_TEAM_ID_BY_USER_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt("TEAM_ID");
        }
        return -1;
    }

    @Override
    public boolean isUserCaptainByUserId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("ConsultationsDataDAO.IS_USER_CAPTAIN_BY_USER_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        preparedStatement.close();
        resultSet.close();
        return false;
    }

    @Override
    public boolean isTeamHasExpertByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("ConsultationsDataDAO.IS_TEAM_HAS_EXPERT_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        preparedStatement.close();
        resultSet.close();
        return false;
    }

    @Override
    public ExpertsStatisticsDTO findTeamExpertByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("ConsultationsDataDAO.FIND_TEAM_EXPERT_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        ExpertsStatisticsDTO expertsStatisticsDTO = new ExpertsStatisticsDTO();
        while (resultSet.next()) {
            expertsStatisticsDTO.setLogin(resultSet.getString("login"));
            expertsStatisticsDTO.setTeamCount(resultSet.getInt("COUNT_TEAMS"));
            expertsStatisticsDTO.setMaxTeamCount(resultSet.getInt("MAX_COUNT_TEAMS"));
        }
        return expertsStatisticsDTO;
    }

    @Override
    public List<ExpertsStatisticsDTO> findListAvailableExperts() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueryManager.getProperty("ConsultationsDataDAO.FIND_LIST_AVAILABLE_EXPERTS.SQL.QUERY"));
        List<ExpertsStatisticsDTO> list = new ArrayList<>();
        while (resultSet.next()) {
            ExpertsStatisticsDTO expertsStatisticsDTO = new ExpertsStatisticsDTO();
            expertsStatisticsDTO.setLogin(resultSet.getString("login"));
            expertsStatisticsDTO.setTeamCount(resultSet.getInt("COUNT_TEAMS"));
            expertsStatisticsDTO.setMaxTeamCount(resultSet.getInt("MAX_COUNT_TEAMS"));
            list.add(expertsStatisticsDTO);
        }
        return list;
    }
}
