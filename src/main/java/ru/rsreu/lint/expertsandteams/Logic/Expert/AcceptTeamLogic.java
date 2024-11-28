package ru.rsreu.lint.expertsandteams.Logic.Expert;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AcceptTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;

import java.sql.SQLException;

public class AcceptTeamLogic {
    public static void deleteRequestFromTableByExpertIdAndTeamId(int expertId, int teamId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AcceptTeamDataDAO acceptTeamDataDAO = factory.getAcceptTeamDataDAO();
        acceptTeamDataDAO.deleteRequestFromTableByExpertAndTeamId(expertId, teamId);
    }

    public static void createConsultationInTableByExpertIdAndTeamId(int expertId, int teamId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AcceptTeamDataDAO acceptTeamDataDAO = factory.getAcceptTeamDataDAO();
        acceptTeamDataDAO.createConsultationInTableByExpertIdAndTeamId(expertId, teamId);
    }

    public static void increaseCountTeamsForExpertByExpertId(int expertId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AcceptTeamDataDAO acceptTeamDataDAO = factory.getAcceptTeamDataDAO();
        acceptTeamDataDAO.increaseCountTeamsForExpertByExpertId(expertId);
    }
}
