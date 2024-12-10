package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Administrator;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.UserDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.TeamsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.ExpertsStatisticsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * The AdministratorDataDAO interface defines methods for data access operations
 * related to administrators, users, teams, and consultations.
 */
public interface AdministratorDataDAO {

    /**
     * Finds the consultation ID associated with a given expert ID.
     *
     * @param expertId The ID of the expert.
     * @return The consultation ID associated with the expert.
     * @throws SQLException If a database access error occurs.
     */
    int findConsultationIdByExpertId(int expertId) throws SQLException;

    void deleteConsultationByTeamId(int teamId) throws SQLException;

    /**
     * Retrieves a list of authenticated users.
     *
     * @return A list of UserDTO representing authenticated users.
     * @throws SQLException If a database access error occurs.
     */
    List<UserDTO> getAuthUsersList() throws SQLException;

    /**
     * Retrieves statistics for all teams.
     *
     * @return A list of TeamsStatisticsDTO representing team statistics.
     * @throws SQLException If a database access error occurs.
     */
    List<TeamsStatisticsDTO> getTeamsStatisticsList() throws SQLException;

    /**
     * Retrieves statistics for all experts.
     *
     * @return A list of ExpertsStatisticsDTO representing expert statistics.
     * @throws SQLException If a database access error occurs.
     */
    List<ExpertsStatisticsDTO> getExpertsStatisticsList() throws SQLException;

    /**
     * Checks if a user exists by their login.
     *
     * @param login The login of the user to check.
     * @return True if the user exists, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    boolean isUserExistsByLogin(String login) throws SQLException;

    /**
     * Creates a user with the specified login and role ID.
     *
     * @param login  The login of the user to create.
     * @param roleId The role ID of the user to create.
     * @return True if the user was created successfully, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    boolean createUserByLogin(String login, int roleId) throws SQLException;

    /**
     * Creates an expert entry by their ID.
     *
     * @param id The ID of the expert to create.
     * @throws SQLException If a database access error occurs.
     */
    void createExpertById(int id) throws SQLException;

    void decreaseCountMembers(int teamId) throws SQLException;

    /**
     * Searches for the role of a user by their login.
     *
     * @param login The login of the user to search for.
     * @return A ResultSet containing the user's role information.
     * @throws SQLException If a database access error occurs.
     */
    ResultSet searchUserRoleByLogin(String login) throws SQLException;

    /**
     * Checks if a user is part of a team by their user ID.
     *
     * @param id The user ID to check.
     * @return True if the user is part of a team, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    boolean isUserJoinedInTeamByUserId(int id) throws SQLException;

    /**
     * Finds the user ID associated with a given login.
     *
     * @param login The login of the user to find.
     * @return The user ID associated with the login.
     * @throws SQLException If a database access error occurs.
     */
    int findUserIdByLogin(String login) throws SQLException;

    /**
     * Deletes an administrator user by their login.
     *
     * @param login The login of the administrator user to delete.
     * @throws SQLException If a database access error occurs.
     */
    void deleteAdministratorUserByLogin(String login) throws SQLException;

    /**
     * Deletes an expert user from the experts table by their ID.
     *
     * @param id The ID of the expert user to delete.
     * @throws SQLException If a database access error occurs.
     */
    void deleteExpertUserFromExpertsTableById(int id) throws SQLException;

    /**
     * Deletes an expert user from the consultations table by their ID.
     *
     * @param id The ID of the expert user to delete from consultations.
     * @throws SQLException If a database access error occurs.
     */
    void deleteExpertUserFromConsultationsTableById(int id) throws SQLException;

    /**
     * Deletes an expert user from the consultations table by their team ID.
     *
     * @param teamId The team ID associated with the expert user to delete from consultations.
     * @throws SQLException If a database access error occurs.
     */
    void deleteExpertUserFromConsultationsTableByTeamId(int teamId) throws SQLException;

    /**
     * Deletes a user from the team members table by their ID.
     *
     * @param id The ID of the user to delete from team members.
     * @throws SQLException If a database access error occurs.
     */
    void deleteUserFromTeamMembersTableById(int id) throws SQLException;

    /**
     * Deletes a user from the question-answer table by consultation ID.
     *
     * @param consultationId The consultation ID associated with the user to delete from question-answer table.
     * @throws SQLException If a database access error occurs.
     */
    void deleteUserFromQuestionAnswerTableByConsultationId(int consultationId) throws SQLException;

    /**
     * Deletes a user from consultation requests table by expert ID.
     *
     * @param expertId The expert ID associated with the user to delete from consultation requests table.
     * @throws SQLException If a database access error occurs.
     */
    void deleteUserFromConsultationRequestsTableByExpertId(int expertId) throws SQLException;

    /**
     * Deletes a user from consultation requests table by team ID.
     *
     * @param teamId The team ID associated with the user to delete from consultation requests table.
     * @throws SQLException If a database access error occurs.
     */
    void deleteUserFromConsultationRequestsTableByTeamId(int teamId) throws SQLException;

    /**
     * Deletes a team from the teams table by its ID.
     *
     * @param teamId The ID of the team to delete from teams table.
     * @throws SQLException If a database access error occurs.
     */
    void deleteTeamFromTeamsTableByTeamId(int teamId) throws SQLException;

    /**
     * Finds the expert ID associated with a given team ID.
     *
     * @param teamId The team ID to search for associated expert ID.
     * @return The expert ID associated with the team ID.
     * @throws SQLException If a database access error occurs.
     */
    int findExpertIdByTeamId(int teamId) throws SQLException;

    /**
     * Decreases the count of teams for an expert by their ID.
     *
     * @param expertId The expert ID whose team count should be decreased.
     * @throws SQLException If a database access error occurs.
     */
    void decreaseCountTeamsForExpert(int expertId) throws SQLException;

    /**
     * Deletes a team for other members by its ID, ensuring no remaining members are part of it after deletion.
     *
     * @param teamId The ID of the team to delete for other members.
     * @throws SQLException If a database access error occurs.
     */
    void deleteTeamForOtherMembers(int teamId) throws SQLException;

    /**
     * Checks if a user is the captain of a team by their user ID.
     *
     * @param id The user ID to check if they are captain of any team.
     * @return True if the user is captain, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    boolean isUserCaptainInTeamByUserId(int id) throws SQLException;

    /**
     * Finds the team ID associated with a given captain's ID.
     *
     * @param captainId The captain's ID to search for associated team ID.
     * @return The team ID associated with the captain's ID.
     * @throws SQLException If a database access error occurs.
     */
    int findTeamIdByCaptainId(int captainId) throws SQLException;

    int findTeamIdByUserId(int userId) throws SQLException;

    /**
     * Finds the consultation ID associated with a given team ID.
     *
     * @param teamId The team ID to search for associated consultation ID.
     * @return The consultation ID associated with the team ID.
     * @throws SQLException If a database access error occurs.
     */
    int findConsultationIdByTeamId(int teamId) throws SQLException;
}