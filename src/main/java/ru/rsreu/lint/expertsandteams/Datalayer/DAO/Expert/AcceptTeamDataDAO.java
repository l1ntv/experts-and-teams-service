package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert;

import java.sql.SQLException;

/**
 * The AcceptTeamDataDAO interface defines methods for data access operations
 * related to the acceptance of team requests by experts, including deleting requests,
 * creating consultations, and updating the count of teams for an expert.
 */
public interface AcceptTeamDataDAO {

    /**
     * Deletes a request from the table based on the specified expert ID and team ID.
     *
     * @param expertId The ID of the expert whose request is to be deleted.
     * @param teamId   The ID of the team associated with the request to be deleted.
     * @throws SQLException If a database access error occurs while deleting the request.
     */
    void deleteRequestFromTableByExpertAndTeamId(int expertId, int teamId) throws SQLException;

    /**
     * Creates a consultation entry in the table for the specified expert and team.
     *
     * @param expertId The ID of the expert for whom the consultation is being created.
     * @param teamId   The ID of the team associated with the consultation.
     * @throws SQLException If a database access error occurs while creating the consultation.
     */
    void createConsultationInTableByExpertIdAndTeamId(int expertId, int teamId) throws SQLException;

    /**
     * Increases the count of teams associated with the specified expert.
     *
     * @param expertId The ID of the expert whose team count is to be increased.
     * @throws SQLException If a database access error occurs while updating the team count.
     */
    void increaseCountTeamsForExpertByExpertId(int expertId) throws SQLException;
}