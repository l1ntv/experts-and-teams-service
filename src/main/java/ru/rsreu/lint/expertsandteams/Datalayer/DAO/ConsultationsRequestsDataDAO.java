package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamConsultationRequestDTO;

import java.sql.SQLException;
import java.util.List;

public interface ConsultationsRequestsDataDAO {
    int findCountTeamsByExpertId(int expertId) throws SQLException;
    int findMaxCountTeamsByExpertId(int expertId) throws SQLException;

    List<TeamConsultationRequestDTO> findConsultationsRequestsFromTeams(int expertId) throws SQLException;

}
