package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.*;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AuthenticationDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.LogoutDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.RegistrationDataDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class OracleDBDAOFactory extends DAOFactory {
    private static volatile OracleDBDAOFactory instance;
    private Connection connection;

    private OracleDBDAOFactory() {
    }

    public static OracleDBDAOFactory getInstance() throws ClassNotFoundException, SQLException {
        OracleDBDAOFactory factory = instance;
        if (instance == null) {
            synchronized (OracleDBDAOFactory.class) {
                instance = factory = new OracleDBDAOFactory();
                factory.connected();
            }
        }
        return factory;
    }

    private void connected() throws ClassNotFoundException, SQLException {
        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
        String username = "lint";
        String password = "123";
        connection = DriverManager.getConnection(url, username, password);
    }

    @Override
    public AuthenticationDataDAO getAuthenticationDataDAO() {
        return new OracleAuthenticationDataDAO(connection);
    }

    @Override
    public LogoutDataDAO getLogoutDataDAO() {
        return new OracleLogoutDataDAO(connection);
    }

    @Override
    public RegistrationDataDAO getRegistrationDataDAO() {
        return new OracleRegistrationDataDAO(connection);
    }
}
