package ru.rsreu.lint.expertsandteams.Oracledb.Expert;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert.AcceptTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleAcceptTeamDataDAO implements AcceptTeamDataDAO {
    private Connection connection;

    public OracleAcceptTeamDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void deleteRequestFromTableByExpertAndTeamId(int expertId, int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AcceptTeamDataDAO.DELETE_REQUEST_BY_EXPERT_AND_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), expertId);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void createConsultationInTableByExpertIdAndTeamId(int expertId, int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AcceptTeamDataDAO.CREATE_CONSULTATION_BY_EXPERT_AND_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), expertId);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void increaseCountTeamsForExpertByExpertId(int expertId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AcceptTeamDataDAO.INCREASE_COUNT_TEAMS_BY_EXPERT_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), expertId);
        preparedStatement.execute();
        preparedStatement.close();
    }
}