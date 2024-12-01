package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Moderator.ConsultationMessageDTO;

import java.sql.SQLException;
import java.util.List;

public interface MessagesUsersDataDAO {
    List<ConsultationMessageDTO> findConsultationMessagesByExperts() throws SQLException;

    List<ConsultationMessageDTO> findConsultationMessagesByUsers() throws SQLException;

    void hideMessage(int consultationId, String message) throws SQLException;
}
