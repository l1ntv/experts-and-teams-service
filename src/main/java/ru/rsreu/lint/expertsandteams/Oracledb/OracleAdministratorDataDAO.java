package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Enums.AccountsStatusesEnum;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;
import ru.rsreu.lint.expertsandteams.Mapper.PasswordMapper;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.*;

public class OracleAdministratorDataDAO implements AdministratorDataDAO {
    private Connection connection;

    public OracleAdministratorDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ResultSet getAuthUsersList() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueryManager.getProperty("AdministratorDataDAO.GET_AUTH_USERS_LIST"));
        return resultSet;
    }

    @Override
    public ResultSet getTeamsStatisticsList() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueryManager.getProperty("AdministratorDataDAO.GET_TEAMS_STATISTICS_LIST"));
        return resultSet;
    }

    @Override
    public ResultSet getExpertsStatisticsList() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueryManager.getProperty("AdministratorDataDAO.GET_EXPERTS_STATISTICS_LIST"));
        return resultSet;
    }

    @Override
    public boolean isUserExistsByLogin(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.IS_USER_EXISTS_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        return false;
    }

    @Override
    public boolean createUserByLogin(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.CREATE_USER_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), PasswordMapper.mapPassword(SQLQueryManager.getProperty("AdministratorDataDAO.ORIGINAL_PASSWORD.SQL.CONST")));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.THIRD_COLUMN_INDEX.SQL.CONST")), Integer.parseInt(SQLQueryManager.getProperty("AdministratorDataDAO.EMPTY_TEAM_ID.SQL.CONST")));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FOURTH_COLUMN_INDEX.SQL.CONST")), AccountsStatusesEnum.OFFLINE.getAccountStatusId());
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIFTH_COLUMN_INDEX.SQL.CONST")), AccountsTypesEnum.USER.getAccountTypeId());
        return preparedStatement.execute();
    }

    @Override
    public ResultSet searchUserRoleByLogin(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.SEARCH_USER_ROLE_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public boolean isUserJoinedInTeamByUserId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.IS_USER_JOINED_IN_TEAM_BY_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        return false;
    }

    public int findUserIdByLogin(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.FIND_USER_ID_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.getInt("USER_ID");
    }

    @Override
    public void deleteAdministratorUserByLogin(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_USER_FROM_USER_DATA_TABLE_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        preparedStatement.execute();
    }

    @Override
    public void deleteExpertUserFromExpertsTableById(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_EXPERT_FROM_EXPERTS_TABLE_BY_EXPERT_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        preparedStatement.execute();
    }

    @Override
    public void deleteExpertUserFromConsultationsTableById(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_EXPERT_FROM_CONSULTATIONS_TABLE_BY_EXPERT_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        preparedStatement.execute();
    }

    @Override
    public void deleteUserFromTeamMembersTableById(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_USER_FROM_TEAM_MEMBERS_TABLE_BY_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        preparedStatement.execute();
    }

    @Override
    public boolean isUserCaptainInTeamByUserId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.IS_USER_CAPTAIN_IN_TEAM_BY_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        return false;
    }
}
