package ru.rsreu.lint.expertsandteams.Oracledb.Moderator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator.UnbanUserDataDAO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleUnbanUserDataDAO implements UnbanUserDataDAO {
    private Connection connection;

    public OracleUnbanUserDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void unbanUserByLogin(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("BanUserDataDAO.UNBAN_USER_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        preparedStatement.execute();
        preparedStatement.close();
    }
}