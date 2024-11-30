package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.LogoutDataDAO;
import ru.rsreu.lint.expertsandteams.Enums.AccountsStatusesEnum;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleLogoutDataDAO implements LogoutDataDAO {
    private Connection connection;

    public OracleLogoutDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void setOfflineStatusByUserId(int userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("LogoutDataDAO.SET_OFFLINE_STATUS_BY_USER_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), AccountsStatusesEnum.OFFLINE.getAccountStatusId());
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), userId);
        preparedStatement.execute();
        preparedStatement.close();
    }
}
