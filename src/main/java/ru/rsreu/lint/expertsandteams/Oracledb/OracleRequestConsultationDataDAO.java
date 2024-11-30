package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.RequestConsultationDataDAO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleRequestConsultationDataDAO implements RequestConsultationDataDAO {
    private Connection connection;

    public OracleRequestConsultationDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int findExpertIdByLogin(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("RequestConsultationDataDAO.FIND_EXPERT_ID_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        ResultSet resultSet = preparedStatement.executeQuery();
        int result = -1;
        while (resultSet.next()) {
            result = resultSet.getInt("USER_ID");
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public int findTeamIdByUserId(int userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("RequestConsultationDataDAO.FIND_TEAM_ID_BY_USER_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int result = -1;
        while (resultSet.next()) {
            result = resultSet.getInt("TEAM_ID");
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public boolean isTeamSentRequestToExpertByTeamIdAndExpertId(int teamId, int expertId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("RequestConsultationDataDAO.IS_TEAM_SENT_REQUEST_TO_EXPERT_BY_TEAM_ID_AND_EXPERT_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), expertId);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean result = false;
        while (resultSet.next()) {
            result = resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public void createNewRequestConsultation(int teamId, int expertId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("RequestConsultationDataDAO.CREATE_NEW_REQUEST_CONSULTATION.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), expertId);
        preparedStatement.execute();
        preparedStatement.close();
    }
}
