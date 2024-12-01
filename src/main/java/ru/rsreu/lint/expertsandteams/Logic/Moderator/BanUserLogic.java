package ru.rsreu.lint.expertsandteams.Logic.Moderator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.BanUserDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;

import java.sql.SQLException;

public class BanUserLogic {
    public static void banUserByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        BanUserDataDAO banUserDataDAO = factory.getBanUserDataDAO();
        banUserDataDAO.banUserByLogin(login);
    }
}
