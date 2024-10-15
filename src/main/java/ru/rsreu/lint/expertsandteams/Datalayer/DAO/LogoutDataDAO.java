package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import java.sql.SQLException;

public interface LogoutDataDAO {
    void setOfflineStatusByUserId(int userId) throws SQLException;
}
