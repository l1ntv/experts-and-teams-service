package ru.rsreu.lint.expertsandteams.Logic.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.User.AskQuestionTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;

import java.sql.SQLException;

public class AskQuestionLogic {
    public static int findConsultationIdByTeamId(int teamId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AskQuestionTeamDataDAO askQuestionTeamDataDAO = factory.getAskQuestionTeamDataDAO();
        return askQuestionTeamDataDAO.findConsultationIdByTeamId(teamId);
    }

    public static void createQuestionByConsultationId(int consultationId, String question) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AskQuestionTeamDataDAO askQuestionTeamDataDAO = factory.getAskQuestionTeamDataDAO();
        askQuestionTeamDataDAO.createQuestionByConsultationId(consultationId, question);
    }
}