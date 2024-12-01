package ru.rsreu.lint.expertsandteams.Oracledb.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.User.LeaveTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleLeaveTeamDataDAO implements LeaveTeamDataDAO {

    private Connection connection;

    public OracleLeaveTeamDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean isUserCaptainByUserId(int userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("LeaveTeamDataDAO.IS_USER_CAPTAIN_BY_USER_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean result = false;
        if (resultSet.next()) {
            result = resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public void deleteUserFromTeamMembersTableByUserId(int userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("LeaveTeamDataDAO.DELETE_USER_FROM_TEAM_MEMBERS_TABLE_BY_USER_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), userId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public int findTeamIdByUserId(int userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("LeaveTeamDataDAO.FIND_TEAM_ID_BY_USER_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int result = -1;
        while (resultSet.next()) {
            result = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.TEAM_ID.SQL.CONST"));
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public void decreaseCountMembersFromTeamsTableByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("LeaveTeamDataDAO.DECREASE_COUNT_MEMBERS_FROM_TEAMS_TABLE_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void updateTeamIdFromUserDataTableByUserId(int userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("LeaveTeamDataDAO.UPDATE_TEAM_ID_FROM_USER_DATA_TABLE_BY_USER_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), userId);
        preparedStatement.execute();
        preparedStatement.close();
    }
}