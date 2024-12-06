package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert;

import java.sql.SQLException;

/**
 * The CancelConsultationDataDAO interface defines methods for data access operations
 * related to canceling consultations in the system.
 */
public interface CancelConsultationDataDAO {

    /**
     * Finds the consultation ID associated with a specific expert and team.
     *
     * @param expertId The ID of the expert whose consultation is being searched for.
     * @param teamId   The ID of the team associated with the consultation.
     * @return The ID of the consultation if found, otherwise returns -1.
     * @throws SQLException If a database access error occurs while searching for the consultation ID.
     */
    int findConsultationIdByExpertAndTeamId(int expertId, int teamId) throws SQLException;

    /**
     * Deletes records from the question answers table associated with a specific consultation ID.
     *
     * @param consultationId The ID of the consultation whose related records are to be deleted.
     * @throws SQLException If a database access error occurs while deleting records from the table.
     */
    void deleteRecordFromQuestionAnswersTableByConsultationId(int consultationId) throws SQLException;

    /**
     * Deletes a consultation record associated with a specific expert and team.
     *
     * @param expertId The ID of the expert whose consultation is to be deleted.
     * @param teamId   The ID of the team associated with the consultation to be deleted.
     * @throws SQLException If a database access error occurs while deleting the consultation record.
     */
    void deleteConsultationByExpertAndTeamId(int expertId, int teamId) throws SQLException;

    /**
     * Decreases the count of teams associated with a specific expert by one.
     *
     * @param expertId The ID of the expert whose team count is to be decreased.
     * @throws SQLException If a database access error occurs while updating the team count.
     */
    void decreaseCountTeamsByExpertId(int expertId) throws SQLException;

    /**
     * Finds the team ID associated with a specific captain ID.
     *
     * @param captainId The ID of the captain whose team ID is being searched for.
     * @return The ID of the team if found, otherwise returns -1.
     * @throws SQLException If a database access error occurs while searching for the team ID.
     */
    int findTeamIdByCaptainId(int captainId) throws SQLException;

    /**
     * Finds the expert ID associated with a specific team ID.
     *
     * @param teamId The ID of the team whose expert ID is being searched for.
     * @return The ID of the expert if found, otherwise returns -1.
     * @throws SQLException If a database access error occurs while searching for the expert ID.
     */
    int findExpertIdByTeamId(int teamId) throws SQLException;
}