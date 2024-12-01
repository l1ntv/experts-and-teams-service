package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.BanUserDataDAO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleBanUserDataDAO implements BanUserDataDAO {
    private Connection connection;

    public OracleBanUserDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void banUserByLogin(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("BanUserDataDAO.BAN_USER_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        preparedStatement.execute();
        preparedStatement.close();
    }
}
