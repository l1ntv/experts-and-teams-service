package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.UserDataDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AuthenticationDataDAO;
import ru.rsreu.lint.expertsandteams.Enums.AccountsStatusesEnum;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OracleAuthenticationDataDAO implements AuthenticationDataDAO {
	private Connection connection;
	
	public OracleAuthenticationDataDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean isCorrectUserDataByLoginAndPassword(UserDataDTO authenticationData) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AuthenticationDataDAO.EXISTS_BY_LOGIN_AND_PASSWORD.SQL.QUERY"));
		preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), authenticationData.getLogin());
		preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), authenticationData.getPassword());
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
		}
		return false;
	}

	@Override
	public void setOnlineStatusByUserId(int userId) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AuthenticationDataDAO.SET_ONLINE_STATUS_BY_USER_ID.SQL.QUERY"));
		preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), AccountsStatusesEnum.ONLINE.getAccountStatusId());
		preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), userId);
		preparedStatement.execute();
	}

	@Override
	public int getUserIdByLogin(String login) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AuthenticationDataDAO.FIND_USER_ID_BY_LOGIN.SQL.QUERY"));
		preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")));
		}
		return Integer.parseInt(SQLQueryManager.getProperty("AuthenticationDataDAO.NOT_FOUND_USER_ID.SQL.CONST"));
	}

	@Override
	public int getUserGroupTypeIdByUserId(int userId) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AuthenticationDataDAO.FIND_USER_TYPE_GROUP_ID_BY_USER_ID.SQL.QUERY"));
		preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), userId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")));
		}
		return Integer.parseInt(SQLQueryManager.getProperty("AuthenticationDataDAO.NOT_FOUND_USER_ID.SQL.CONST"));
	}

	@Override
	public boolean isUserCaptainByUserId(int userId) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AuthenticationDataDAO.IS_USER_CAPTAIN_BY_USER_ID.SQL.QUERY"));
		preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), userId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
		}
		return false;
	}
}