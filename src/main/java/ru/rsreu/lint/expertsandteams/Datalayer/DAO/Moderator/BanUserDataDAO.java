package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator;

import java.sql.SQLException;

public interface BanUserDataDAO {
    void banUserByLogin(String login) throws SQLException;
}
