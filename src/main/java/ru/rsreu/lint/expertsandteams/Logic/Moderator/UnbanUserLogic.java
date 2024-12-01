package ru.rsreu.lint.expertsandteams.Logic.Moderator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.UnbanUserDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;

import java.sql.SQLException;

public class UnbanUserLogic {
    public static void unbanUserByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        UnbanUserDataDAO unbanUserDataDAO = factory.getUnbanUserDataDAO();
        unbanUserDataDAO.unbanUserByLogin(login);
    }
}
