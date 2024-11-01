package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Enums.AccountsStatusesEnum;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import javax.swing.plaf.nimbus.State;
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
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), SQLQueryManager.getProperty("AdministratorDataDAO.ORIGINAL_PASSWORD.SQL.CONST"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.THIRD_COLUMN_INDEX.SQL.CONST")), Integer.parseInt(SQLQueryManager.getProperty("AdministratorDataDAO.EMPTY_TEAM_ID.SQL.CONST")));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FOURTH_COLUMN_INDEX.SQL.CONST")), AccountsStatusesEnum.OFFLINE.getAccountStatusId());
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIFTH_COLUMN_INDEX.SQL.CONST")), AccountsTypesEnum.USER.getAccountTypeId());
        return preparedStatement.execute();
    }
}
