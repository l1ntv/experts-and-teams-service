package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.ConsultingTeamDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamDataDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * The MainDataDAO interface provides methods for accessing and managing team and user data
 * in the database. It includes functionalities for retrieving team information, user roles,
 * and consulting teams associated with experts.
 */
public interface MainDataDAO {

    /**
     * Retrieves a list of all teams from the database.
     *
     * @return A list of TeamDataDTO objects representing the teams.
     * @throws SQLException If a database access error occurs while retrieving the list of teams.
     */
    List<TeamDataDTO> getListTeams() throws SQLException;

    /**
     * Gets the login of the captain based on their captain ID.
     *
     * @param captainId The ID of the captain whose login is to be retrieved.
     * @return The login of the captain as a String.
     * @throws SQLException If a database access error occurs while retrieving the captain's login.
     */
    String getCaptainLoginByCaptainId(int captainId) throws SQLException;

    /**
     * Gets the login of an expert associated with a specific team ID.
     *
     * @param teamId The ID of the team whose expert's login is to be retrieved.
     * @return The login of the expert as a String.
     * @throws SQLException If a database access error occurs while retrieving the expert's login.
     */
    String getExpertLoginByTeamId(int teamId) throws SQLException;

    /**
     * Checks if a user is a member of a team based on their user ID.
     *
     * @param id The ID of the user to check for team membership.
     * @return true if the user is joined in a team; false otherwise.
     * @throws SQLException If a database access error occurs while checking the user's membership status.
     */
    boolean isUserJoinedInTeamByUserId(int id) throws SQLException;

    /**
     * Finds the team ID associated with a specific user ID.
     *
     * @param id The ID of the user for whom to find the associated team ID.
     * @return The ID of the team associated with the specified user.
     * @throws SQLException If a database access error occurs while retrieving the team ID.
     */
    int findTeamIdByUserId(int id) throws SQLException;

    /**
     * Finds the name of a team based on its team ID.
     *
     * @param id The ID of the team whose name is to be retrieved.
     * @return The name of the team as a String.
     * @throws SQLException If a database access error occurs while retrieving the team's name.
     */
    String findTeamNameByTeamId(int id) throws SQLException;

    /**
     * Finds a list of consulting teams DTOs associated with a specific expert ID.
     *
     * @param expertId The ID of the expert for whom to find consulting teams.
     * @return A list of ConsultingTeamDTO objects representing the consulting teams associated with the expert.
     * @throws SQLException If a database access error occurs while retrieving the list of consulting teams.
     */
    List<ConsultingTeamDTO> findListConsultingTeamsDTOByExpertId(int expertId) throws SQLException;
}