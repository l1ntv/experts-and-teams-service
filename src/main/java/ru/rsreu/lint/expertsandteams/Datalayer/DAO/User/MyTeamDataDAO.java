package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.User.TeamMemberDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * The MyTeamDataDAO interface provides methods for accessing and managing team member data
 * in the database. It includes functionalities for counting team members and retrieving
 * detailed information about team members associated with a specific team.
 */
public interface MyTeamDataDAO {

    /**
     * Finds the count of members in a team based on the provided team ID.
     *
     * @param teamId The ID of the team for which to count the members.
     * @return The count of members in the specified team.
     * @throws SQLException If a database access error occurs while retrieving the count of members.
     */
    int findCountMembersByTeamId(int teamId) throws SQLException;

    /**
     * Finds the maximum allowed count of members for a team based on the provided team ID.
     *
     * @param teamId The ID of the team for which to find the maximum member count.
     * @return The maximum count of members allowed in the specified team.
     * @throws SQLException If a database access error occurs while retrieving the maximum member count.
     */
    int findMaxCountMembersByTeamId(int teamId) throws SQLException;

    /**
     * Retrieves a list of TeamMemberDTO objects representing the members of a team
     * based on the provided team ID.
     *
     * @param teamId The ID of the team for which to retrieve the members.
     * @return A list of TeamMemberDTO objects representing the members of the specified team.
     * @throws SQLException If a database access error occurs while retrieving the list of team members.
     */
    List<TeamMemberDTO> findTeamMemberDTOListByTeamId(int teamId) throws SQLException;
}