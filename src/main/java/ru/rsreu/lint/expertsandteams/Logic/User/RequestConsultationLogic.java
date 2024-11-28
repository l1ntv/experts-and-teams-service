package ru.rsreu.lint.expertsandteams.Logic.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.RequestConsultationDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;

import java.sql.SQLException;

public class RequestConsultationLogic {
    public static int findExpertIdByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        RequestConsultationDataDAO requestConsultationDataDAO = factory.getRequestConsultationDataDAO();
        return requestConsultationDataDAO.findExpertIdByLogin(login);
    }

    public static int findTeamIdByUserId(int userId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        RequestConsultationDataDAO requestConsultationDataDAO = factory.getRequestConsultationDataDAO();
        return requestConsultationDataDAO.findTeamIdByUserId(userId);
    }

    public static boolean isTeamSentRequestToExpertByTeamIdAndExpertId(int teamId, int expertId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        RequestConsultationDataDAO requestConsultationDataDAO = factory.getRequestConsultationDataDAO();
        return requestConsultationDataDAO.isTeamSentRequestToExpertByTeamIdAndExpertId(teamId, expertId);
    }

    public static void createNewRequestConsultation(int teamId, int expertId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        RequestConsultationDataDAO requestConsultationDataDAO = factory.getRequestConsultationDataDAO();
        requestConsultationDataDAO.createNewRequestConsultation(teamId, expertId);
    }
}
