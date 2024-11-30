package ru.rsreu.lint.expertsandteams.Logic.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.ConsultationsDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.ExpertsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.QuestionAnswerDTO;

import java.sql.SQLException;
import java.util.List;

public class ConsultationsLogic {
    public static boolean isJoinedInTeamByUserId(int id) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        ConsultationsDataDAO consultationsDataDAO = factory.getConsultationsDataDAO();
        return consultationsDataDAO.isUserJoinedInTeamByUserId(id);
    }

    public static boolean isUserCaptainByUserId(int id) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        ConsultationsDataDAO consultationsDataDAO = factory.getConsultationsDataDAO();
        return consultationsDataDAO.isUserCaptainByUserId(id);
    }

    public static int findTeamIdByUserId(int userId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        ConsultationsDataDAO consultationsDataDAO = factory.getConsultationsDataDAO();
        return consultationsDataDAO.findTeamIdByUserId(userId);
    }

    public static boolean isTeamHasExpertByTeamId(int teamId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        ConsultationsDataDAO consultationsDataDAO = factory.getConsultationsDataDAO();
        return consultationsDataDAO.isTeamHasExpertByTeamId(teamId);
    }

    public static ExpertsStatisticsDTO findTeamExpertByTeamId(int teamId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        ConsultationsDataDAO consultationsDataDAO = factory.getConsultationsDataDAO();
        return consultationsDataDAO.findTeamExpertByTeamId(teamId);
    }

    public static List<ExpertsStatisticsDTO> findListAvailableExperts() throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        ConsultationsDataDAO consultationsDataDAO = factory.getConsultationsDataDAO();
        return consultationsDataDAO.findListAvailableExperts();
    }

    public static List<QuestionAnswerDTO> findQuestionsAndAnswersByConsultationId(int consultationId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        ConsultationsDataDAO consultationsDataDAO = factory.getConsultationsDataDAO();
        return consultationsDataDAO.findQuestionsAndAnswersByConsultationId(consultationId);
    }
}
