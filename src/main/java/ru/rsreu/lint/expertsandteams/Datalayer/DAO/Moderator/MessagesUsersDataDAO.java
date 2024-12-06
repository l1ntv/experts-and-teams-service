package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Moderator.ConsultationMessageDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * The MessagesUsersDataDAO interface provides methods for accessing and manipulating
 * consultation messages in the system, specifically for both experts and users.
 */
public interface MessagesUsersDataDAO {

    /**
     * Retrieves a list of consultation messages sent by experts.
     *
     * @return A list of {@link ConsultationMessageDTO} objects representing the messages
     * sent by experts.
     * @throws SQLException If a database access error occurs while retrieving the messages.
     */
    List<ConsultationMessageDTO> findConsultationMessagesByExperts() throws SQLException;

    /**
     * Retrieves a list of consultation messages sent by users.
     *
     * @return A list of {@link ConsultationMessageDTO} objects representing the messages
     * sent by users.
     * @throws SQLException If a database access error occurs while retrieving the messages.
     */
    List<ConsultationMessageDTO> findConsultationMessagesByUsers() throws SQLException;

    /**
     * Hides a specific consultation message based on its ID and content.
     *
     * @param consultationId The ID of the consultation to which the message belongs.
     * @param message        The content of the message to be hidden.
     * @throws SQLException If a database access error occurs while trying to hide the message.
     */
    void hideMessage(int consultationId, String message) throws SQLException;
}