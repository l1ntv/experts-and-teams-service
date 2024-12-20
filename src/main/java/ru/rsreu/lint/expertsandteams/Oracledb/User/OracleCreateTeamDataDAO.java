package ru.rsreu.lint.expertsandteams.Oracledb.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.User.CreateTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Enums.TeamRoleEnum;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleCreateTeamDataDAO implements CreateTeamDataDAO {
    private Connection connection;
    private static final int NEW_TEAM_COUNT_MEMBERS = 1;
    private static final int NEW_TEAM_MAX_COUNT_MEMBERS = 4;

    public OracleCreateTeamDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createTeamInTeamsTableByCaptainIdAndTeamName(int captainId, String teamName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("CreateTeamDataDAO.CREATE_TEAM_IN_TEAMS_TABLE_BY_USER_ID_AND_TEAM_NAME.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamName);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), captainId);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.THIRD_COLUMN_INDEX.SQL.CONST")), OracleCreateTeamDataDAO.NEW_TEAM_COUNT_MEMBERS);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FOURTH_COLUMN_INDEX.SQL.CONST")), OracleCreateTeamDataDAO.NEW_TEAM_MAX_COUNT_MEMBERS);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void createTeamInTeamMembersTableByCaptainIdAndTeamId(int captainId, int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("CreateTeamDataDAO.CREATE_TEAM_IN_TEAM_MEMBERS_TABLE_BY_USER_ID_AND_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), captainId);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.THIRD_COLUMN_INDEX.SQL.CONST")), TeamRoleEnum.CAPTAIN.getTeamRoleId());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public int findTeamIdByTeamName(String teamName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("CreateTeamDataDAO.FIND_TEAM_ID_BY_TEAM_NAME.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamName);
        ResultSet resultSet = preparedStatement.executeQuery();
        int teamId = -1;
        while (resultSet.next()) {
            teamId = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.TEAM_ID.SQL.CONST"));
        }
        resultSet.close();
        preparedStatement.close();
        return teamId;
    }

    @Override
    public boolean isTeamExistsByName(String teamName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("CreateTeamDataDAO.IS_TEAM_EXISTS_BY_NAME.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamName);
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
    public void updateTeamIdFromUserDataTableByUserIdAndTeamId(int teamId, int userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("CreateTeamDataDAO.UPDATE_TEAM_ID_FROM_USER_DATA.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), userId);
        preparedStatement.execute();
        preparedStatement.close();
    }
}