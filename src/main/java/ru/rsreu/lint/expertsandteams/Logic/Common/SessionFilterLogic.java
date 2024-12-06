package ru.rsreu.lint.expertsandteams.Logic.Common;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common.SessionFilterDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;

import java.sql.SQLException;

public class SessionFilterLogic {
    public static boolean isUserBannedByUserId(int userId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        SessionFilterDataDAO sessionFilterDataDAO = factory.getSessionFilterDataDAO();
        return sessionFilterDataDAO.isBanned(userId);
    }
}
