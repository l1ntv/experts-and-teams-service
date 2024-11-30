package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.CancelConsultationDataDAO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleCancelConsultationDataDAO implements CancelConsultationDataDAO {
    private Connection connection;

    public OracleCancelConsultationDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int findConsultationIdByExpertAndTeamId(int expertId, int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("CancelConsultationDataDAO.FIND_CONSULTATION_ID_BY_EXPERT_AND_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), expertId);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int result = -1;
        while (resultSet.next()) {
            result = resultSet.getInt("CONSULTATION_ID");
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public void deleteRecordFromQuestionAnswersTableByConsultationId(int consultationId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("CancelConsultationDataDAO.DELETE_ANSWER_QUESTION_BY_CONSULTATION_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), consultationId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void deleteConsultationByExpertAndTeamId(int expertId, int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("CancelConsultationDataDAO.DELETE_CONSULTATION_BY_EXPERT_AND_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), expertId);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void decreaseCountTeamsByExpertId(int expertId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("CancelConsultationDataDAO.DECREASE_COUNT_TEAMS_BY_EXPERT_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), expertId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public int findTeamIdByCaptainId(int captainId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("CancelConsultationDataDAO.FIND_TEAM_ID_BY_CAPTAIN_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), captainId);
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
    public int findExpertIdByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("CancelConsultationDataDAO.FIND_EXPERT_ID_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int result = -1;
        while (resultSet.next()) {
            result = resultSet.getInt("EXPERT_ID");
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }
}
