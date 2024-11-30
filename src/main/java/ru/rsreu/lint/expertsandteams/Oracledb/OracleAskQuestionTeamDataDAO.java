package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AskQuestionTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleAskQuestionTeamDataDAO implements AskQuestionTeamDataDAO {
    private Connection connection;

    public OracleAskQuestionTeamDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int findConsultationIdByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AskQuestionTeamDataDAO.FIND_CONSULTATION_ID_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
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
    public void createQuestionByConsultationId(int consultationId, String question) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AskQuestionTeamDataDAO.CREATE_QUESTION_BY_CONSULTATION_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), consultationId);
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), question);
        preparedStatement.execute();
        preparedStatement.close();
    }
}
