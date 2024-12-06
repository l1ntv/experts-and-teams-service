package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator;

import java.sql.SQLException;

/**
 * The BanUserDataDAO interface defines methods for data access operations
 * related to banning users in the system.
 */
public interface BanUserDataDAO {

    /**
     * Bans a user from the system based on their login.
     *
     * @param login The login of the user to be banned.
     * @throws SQLException If a database access error occurs while trying to ban the user.
     */
    void banUserByLogin(String login) throws SQLException;
}