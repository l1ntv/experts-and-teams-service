package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
