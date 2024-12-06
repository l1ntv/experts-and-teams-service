package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator;

import java.sql.SQLException;

/**
 * The UnbanUserDataDAO interface provides a method for unbanning users in the system.
 */
public interface UnbanUserDataDAO {

    /**
     * Unbans a user by their login.
     *
     * @param login The login of the user to be unbanned.
     * @throws SQLException If a database access error occurs while trying to unban the user.
     */
    void unbanUserByLogin(String login) throws SQLException;
}