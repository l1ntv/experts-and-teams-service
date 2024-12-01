package ru.rsreu.lint.expertsandteams.Logic.Moderator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.MessagesUsersDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Moderator.ConsultationMessageDTO;

import java.sql.SQLException;
import java.util.List;

public class MessagesUsersLogic {
    public static List<ConsultationMessageDTO> findConsultationMessagesByExperts() throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        MessagesUsersDataDAO messagesUsersDataDAO = factory.getMessagesUsersDataDAO();
        return messagesUsersDataDAO.findConsultationMessagesByExperts();
    }

    public static List<ConsultationMessageDTO> findConsultationMessagesByUsers() throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        MessagesUsersDataDAO messagesUsersDataDAO = factory.getMessagesUsersDataDAO();
        return messagesUsersDataDAO.findConsultationMessagesByUsers();
    }

    public static void hideMessage(int consultationId, String message) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        MessagesUsersDataDAO messagesUsersDataDAO = factory.getMessagesUsersDataDAO();
        messagesUsersDataDAO.hideMessage(consultationId, message);
    }

}
