package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common;

import java.sql.SQLException;

public interface LogoutDataDAO {
    void setOfflineStatusByUserId(int userId) throws SQLException;
}
