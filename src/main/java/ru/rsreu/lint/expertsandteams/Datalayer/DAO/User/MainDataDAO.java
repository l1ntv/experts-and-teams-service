package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.ConsultingTeamDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamDataDTO;

import java.sql.SQLException;
import java.util.List;

public interface MainDataDAO {
    List<TeamDataDTO> getListTeams() throws SQLException;

    String getCaptainLoginByCaptainId(int captainId) throws SQLException;

    String getExpertLoginByTeamId(int teamId) throws SQLException;

    boolean isUserJoinedInTeamByUserId(int id) throws SQLException;

    int findTeamIdByUserId(int id) throws SQLException;

    String findTeamNameByTeamId(int id) throws SQLException;

    List<ConsultingTeamDTO> findListConsultingTeamsDTOByExpertId(int expertId) throws SQLException;
}
