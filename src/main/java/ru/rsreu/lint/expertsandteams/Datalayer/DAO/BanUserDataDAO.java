package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import java.sql.SQLException;

public interface BanUserDataDAO {
    void banUserByLogin(String login) throws SQLException;
}
