package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.UserDataDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.RegistrationDataDAO;
import ru.rsreu.lint.expertsandteams.Enums.AccountsStatusesEnum;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleRegistrationDataDAO implements RegistrationDataDAO {

    private Connection connection;

    public OracleRegistrationDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean exists(UserDataDTO userDataDTO) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("RegistrationDataDAO.EXISTS_BY_LOGIN_AND_PASSWORD.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), userDataDTO.getLogin());
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), userDataDTO.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        return false;
    }

    @Override
    public void createUser(UserDataDTO userDataDTO) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("RegistrationDataDAO.CREATE_USER_BY_LOGIN_AND_PASSWORD.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), userDataDTO.getLogin());
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), userDataDTO.getPassword());
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.THIRD_COLUMN_INDEX.SQL.CONST")), Integer.parseInt(SQLQueryManager.getProperty("RegistrationDataDAO.EMPTY_TEAM_ID.SQL.CONST")));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FOURTH_COLUMN_INDEX.SQL.CONST")), AccountsStatusesEnum.ONLINE.getAccountStatusId());
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIFTH_COLUMN_INDEX.SQL.CONST")), AccountsTypesEnum.EXPERT.getAccountTypeId());
        preparedStatement.execute();
    }

    @Override
    public int getUserIdByLogin(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("RegistrationDataDAO.FIND_USER_ID_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")));
        }
        return Integer.parseInt(SQLQueryManager.getProperty("RegistrationDataDAO.NOT_FOUND_USER_ID.SQL.CONST"));
    }
}
