package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import java.sql.SQLException;

/**
 * The AskQuestionTeamDataDAO interface provides methods for managing questions
 * related to consultations in a team context.
 */
public interface AskQuestionTeamDataDAO {

    /**
     * Retrieves the consultation ID associated with a given team ID.
     *
     * @param teamId The ID of the team for which to find the consultation ID.
     * @return The consultation ID associated with the specified team ID.
     * @throws SQLException If a database access error occurs while retrieving the consultation ID.
     */
    int findConsultationIdByTeamId(int teamId) throws SQLException;

    /**
     * Creates a question associated with a specific consultation ID.
     *
     * @param consultationId The ID of the consultation to which the question is related.
     * @param question       The content of the question to be created.
     * @throws SQLException If a database access error occurs while creating the question.
     */
    void createQuestionByConsultationId(int consultationId, String question) throws SQLException;
}