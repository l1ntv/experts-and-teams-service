package ru.rsreu.lint.expertsandteams.Logic.Expert;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.ConsultationsRequestsDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamConsultationRequestDTO;

import java.sql.SQLException;
import java.util.List;

public class ConsultationsRequestsLogic {

    public static int findCountTeamsByExpertId(int expertId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        ConsultationsRequestsDataDAO consultationsRequestsDataDAO = factory.getConsultationsRequestsDataDAO();
        return consultationsRequestsDataDAO.findCountTeamsByExpertId(expertId);
    }

    public static int findMaxCountTeamsByExpertId(int expertId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        ConsultationsRequestsDataDAO consultationsRequestsDataDAO = factory.getConsultationsRequestsDataDAO();
        return consultationsRequestsDataDAO.findMaxCountTeamsByExpertId(expertId);
    }

    public static List<TeamConsultationRequestDTO> findConsultationsRequestsFromTeams(int expertId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        ConsultationsRequestsDataDAO consultationsRequestsDataDAO = factory.getConsultationsRequestsDataDAO();
        List<TeamConsultationRequestDTO> list = consultationsRequestsDataDAO.findConsultationsRequestsFromTeams(expertId);
        return list;
    }

}
