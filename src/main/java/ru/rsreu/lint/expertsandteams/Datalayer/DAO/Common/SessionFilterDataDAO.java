package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common;

import java.sql.SQLException;

public interface SessionFilterDataDAO {
    boolean isBanned(int userId) throws SQLException;
}
