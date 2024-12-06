package ru.rsreu.lint.expertsandteams.Oracledb.Common;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common.SessionFilterDataDAO;
import ru.rsreu.lint.expertsandteams.Enums.AccountsStatusesEnum;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleSessionFilterDataDAO implements SessionFilterDataDAO {
    private Connection connection;

    public OracleSessionFilterDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean isBanned(int userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("SessionFilterDataDAO.IS_USER_BANNED_BY_USER_ID.SQL.QUERY"));
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
}
