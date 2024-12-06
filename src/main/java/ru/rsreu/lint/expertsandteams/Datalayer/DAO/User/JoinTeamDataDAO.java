package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import java.sql.SQLException;

/**
 * The JoinTeamDataDAO interface provides methods for managing team membership data
 * in the database, including finding team IDs, checking user membership, and updating team information.
 */
public interface JoinTeamDataDAO {

    /**
     * Finds the ID of a team based on its name.
     *
     * @param teamName The name of the team for which to find the ID.
     * @return The ID of the team associated with the specified name.
     * @throws SQLException If a database access error occurs while retrieving the team ID.
     */
    int findTeamIdByTeamName(String teamName) throws SQLException;

    /**
     * Checks if a user is a member of any team based on their user ID.
     *
     * @param userId The ID of the user to check for team membership.
     * @return true if the user is a member of a team; false otherwise.
     * @throws SQLException If a database access error occurs while checking the user's membership status.
     */
    boolean isUserJoinedInTeamByUserId(int userId) throws SQLException;

    /**
     * Changes the team ID associated with a user in the user data table.
     *
     * @param teamId The new team ID to be associated with the user.
     * @param userId The ID of the user whose team association will be updated.
     * @throws SQLException If a database access error occurs while updating the user data table.
     */
    void changeTeamIdInUserDataTableByUserId(int teamId, int userId) throws SQLException;

    /**
     * Adds a new member to the team members table.
     *
     * @param userId The ID of the user to be added as a member.
     * @param teamId The ID of the team to which the user will be added.
     * @throws SQLException If a database access error occurs while adding the member to the team members table.
     */
    void addNewMemberInTeamMembersTable(int userId, int teamId) throws SQLException;

    /**
     * Updates the count of members in the teams table based on the specified team ID.
     *
     * @param teamId The ID of the team whose member count will be updated.
     * @throws SQLException If a database access error occurs while updating the member count in the teams table.
     */
    void updateCountMembersInTeamsTableByTeamId(int teamId) throws SQLException;
}