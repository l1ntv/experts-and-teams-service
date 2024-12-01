package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import java.sql.SQLException;

public interface UnbanUserDataDAO {
    void unbanUserByLogin(String login) throws SQLException;
}
