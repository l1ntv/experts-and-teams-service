package ru.rsreu.lint.expertsandteams.Logic.Common;

import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common.LogoutDataDAO;

import java.sql.SQLException;

public class LogoutLogic {
    public static void setOfflineStatusByUserId(int userId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        LogoutDataDAO logoutDataDAO = factory.getLogoutDataDAO();
        logoutDataDAO.setOfflineStatusByUserId(userId);
    }
}