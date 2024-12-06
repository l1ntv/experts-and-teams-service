package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import java.sql.SQLException;

/**
 * The LeaveTeamDataDAO interface provides methods for managing user team departure data
 * in the database, including checking user roles, deleting users from teams, and updating team information.
 */
public interface LeaveTeamDataDAO {

    /**
     * Checks if a user is the captain of a team based on their user ID.
     *
     * @param userId The ID of the user to check.
     * @return true if the user is a captain; false otherwise.
     * @throws SQLException If a database access error occurs while checking the user's role.
     */
    boolean isUserCaptainByUserId(int userId) throws SQLException;

    /**
     * Deletes a user from the team members table based on their user ID.
     *
     * @param userId The ID of the user to be deleted from the team members table.
     * @throws SQLException If a database access error occurs while deleting the user from the table.
     */
    void deleteUserFromTeamMembersTableByUserId(int userId) throws SQLException;

    /**
     * Finds the team ID associated with a user based on their user ID.
     *
     * @param userId The ID of the user for whom to find the team ID.
     * @return The ID of the team associated with the specified user.
     * @throws SQLException If a database access error occurs while retrieving the team ID.
     */
    int findTeamIdByUserId(int userId) throws SQLException;

    /**
     * Decreases the count of members in the teams table based on the specified team ID.
     *
     * @param teamId The ID of the team whose member count will be decreased.
     * @throws SQLException If a database access error occurs while updating the member count in the teams table.
     */
    void decreaseCountMembersFromTeamsTableByTeamId(int teamId) throws SQLException;

    /**
     * Updates the team ID associated with a user in the user data table based on their user ID.
     *
     * @param userId The ID of the user whose team association will be updated.
     * @throws SQLException If a database access error occurs while updating the user data table.
     */
    void updateTeamIdFromUserDataTableByUserId(int userId) throws SQLException;
}