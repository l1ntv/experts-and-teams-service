package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common;

import java.sql.SQLException;

/**
 * The LogoutDataDAO interface defines methods for data access operations
 * related to user logout actions, specifically setting a user's offline status.
 */
public interface LogoutDataDAO {

    /**
     * Sets the offline status of a user based on their user ID.
     *
     * @param userId The ID of the user whose offline status is to be set.
     * @throws SQLException If a database access error occurs while updating the user's status.
     */
    void setOfflineStatusByUserId(int userId) throws SQLException;
}