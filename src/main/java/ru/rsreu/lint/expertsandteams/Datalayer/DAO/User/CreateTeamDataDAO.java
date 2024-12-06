package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import java.sql.SQLException;

/**
 * The CreateTeamDataDAO interface provides methods for creating and managing team data
 * in the database, including team creation, membership management, and team existence checks.
 */
public interface CreateTeamDataDAO {

    /**
     * Creates a new team in the teams table with the specified captain ID and team name.
     *
     * @param captainId The ID of the captain who will lead the team.
     * @param teamName  The name of the team to be created.
     * @throws SQLException If a database access error occurs while creating the team.
     */
    void createTeamInTeamsTableByCaptainIdAndTeamName(int captainId, String teamName) throws SQLException;

    /**
     * Adds the captain as a member of the newly created team in the team members table.
     *
     * @param captainId The ID of the captain to be added to the team members table.
     * @param teamId    The ID of the team to which the captain will be added.
     * @throws SQLException If a database access error occurs while adding the captain to the team members table.
     */
    void createTeamInTeamMembersTableByCaptainIdAndTeamId(int captainId, int teamId) throws SQLException;

    /**
     * Finds the ID of a team based on its name.
     *
     * @param teamName The name of the team for which to find the ID.
     * @return The ID of the team associated with the specified name.
     * @throws SQLException If a database access error occurs while retrieving the team ID.
     */
    int findTeamIdByTeamName(String teamName) throws SQLException;

    /**
     * Checks if a team exists in the database by its name.
     *
     * @param teamName The name of the team to check for existence.
     * @return true if the team exists; false otherwise.
     * @throws SQLException If a database access error occurs while checking for the team's existence.
     */
    boolean isTeamExistsByName(String teamName) throws SQLException;

    /**
     * Updates the team ID associated with a user in the user data table.
     *
     * @param teamId The ID of the team to be associated with the user.
     * @param userId The ID of the user whose team association will be updated.
     * @throws SQLException If a database access error occurs while updating the user data table.
     */
    void updateTeamIdFromUserDataTableByUserIdAndTeamId(int teamId, int userId) throws SQLException;
}