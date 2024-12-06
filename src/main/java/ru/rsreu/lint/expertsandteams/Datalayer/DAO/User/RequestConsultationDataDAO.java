package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import java.sql.SQLException;

/**
 * The RequestConsultationDataDAO interface provides methods for managing consultation requests
 * between teams and experts in the database. It includes functionalities for checking existing
 * requests and creating new consultation requests.
 */
public interface RequestConsultationDataDAO {

    /**
     * Checks whether a specific team has sent a consultation request to a specific expert.
     *
     * @param teamId   The ID of the team to check.
     * @param expertId The ID of the expert to check against.
     * @return true if the team has sent a request to the expert; false otherwise.
     * @throws SQLException If a database access error occurs while checking the request status.
     */
    boolean isTeamSentRequestToExpertByTeamIdAndExpertId(int teamId, int expertId) throws SQLException;

    /**
     * Finds the expert ID associated with the given login.
     *
     * @param login The login of the expert whose ID is to be retrieved.
     * @return The ID of the expert associated with the given login.
     * @throws SQLException If a database access error occurs while retrieving the expert ID.
     */
    int findExpertIdByLogin(String login) throws SQLException;

    /**
     * Finds the team ID associated with the given user ID.
     *
     * @param userId The ID of the user whose team ID is to be retrieved.
     * @return The ID of the team associated with the given user ID.
     * @throws SQLException If a database access error occurs while retrieving the team ID.
     */
    int findTeamIdByUserId(int userId) throws SQLException;

    /**
     * Creates a new consultation request for a specific team to an expert.
     *
     * @param teamId   The ID of the team making the request.
     * @param expertId The ID of the expert being requested for consultation.
     * @throws SQLException If a database access error occurs while creating the new request.
     */
    void createNewRequestConsultation(int teamId, int expertId) throws SQLException;
}