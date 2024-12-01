package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator;

import java.sql.SQLException;

public interface UnbanUserDataDAO {
    void unbanUserByLogin(String login) throws SQLException;
}
