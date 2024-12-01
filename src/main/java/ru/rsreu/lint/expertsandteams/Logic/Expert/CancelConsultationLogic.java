package ru.rsreu.lint.expertsandteams.Logic.Expert;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert.CancelConsultationDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;

import java.sql.SQLException;

public class CancelConsultationLogic {

    public static int findConsultationIdByExpertAndTeamId(int expertId, int teamId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        CancelConsultationDataDAO cancelConsultationDataDAO = factory.getCancelConsultationDataDAO();
        return cancelConsultationDataDAO.findConsultationIdByExpertAndTeamId(expertId, teamId);
    }

    public static void deleteRecordFromQuestionAnswersTableByConsultationId(int consultationId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        CancelConsultationDataDAO cancelConsultationDataDAO = factory.getCancelConsultationDataDAO();
        cancelConsultationDataDAO.deleteRecordFromQuestionAnswersTableByConsultationId(consultationId);
    }

    public static void deleteConsultationByExpertAndTeamId(int expertId, int teamId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        CancelConsultationDataDAO cancelConsultationDataDAO = factory.getCancelConsultationDataDAO();
        cancelConsultationDataDAO.deleteConsultationByExpertAndTeamId(expertId, teamId);
    }

    public static void decreaseCountTeamsByExpertId(int expertId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        CancelConsultationDataDAO cancelConsultationDataDAO = factory.getCancelConsultationDataDAO();
        cancelConsultationDataDAO.decreaseCountTeamsByExpertId(expertId);
    }

    public static int findTeamIdByCaptainId(int captainId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        CancelConsultationDataDAO cancelConsultationDataDAO = factory.getCancelConsultationDataDAO();
        return cancelConsultationDataDAO.findTeamIdByCaptainId(captainId);
    }

    public static int findExpertIdByTeamId(int teamId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        CancelConsultationDataDAO cancelConsultationDataDAO = factory.getCancelConsultationDataDAO();
        return cancelConsultationDataDAO.findExpertIdByTeamId(teamId);
    }
}
