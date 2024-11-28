package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.JoinTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleJoinTeamDataDAO implements JoinTeamDataDAO {
    private Connection connection;

    public OracleJoinTeamDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int findTeamIdByTeamName(String teamName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("JoinTeamDataDAO.FIND_TEAM_ID_BY_TEAM_NAME.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt("TEAM_ID");
        }
        return -1;
    }

    @Override
    public boolean isUserJoinedInTeamByUserId(int userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("JoinTeamDataDAO.IS_USER_JOINED_IN_TEAM_BY_USER_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        return false;
    }

    @Override
    public void changeTeamIdInUserDataTableByUserId(int teamId, int userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("JoinTeamDataDAO.CHANGE_TEAM_ID_IN_USER_DATA_TABLE_TEAM_BY_USER_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), userId);
        preparedStatement.execute();
    }

    @Override
    public void addNewMemberInTeamMembersTable(int userId, int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("JoinTeamDataDAO.ADD_NEW_MEMBER_IN_TEAM_MEMBERS_TABLE.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), userId);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.THIRD_COLUMN_INDEX.SQL.CONST")), 0);
        preparedStatement.execute();
    }

    @Override
    public void updateCountMembersInTeamsTableByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("JoinTeamDataDAO.UPDATE_COUNT_MEMBERS_IN_TEAMS_TABLE_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.execute();
    }
}
