package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.ConsultingTeamDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.TeamData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface MainDataDAO {
    List<TeamData> getListTeams() throws SQLException;
    String getCaptainLoginByCaptainId(int captainId) throws SQLException;
    String getExpertLoginByTeamId(int teamId) throws SQLException;
    boolean isUserJoinedInTeamByUserId(int id) throws SQLException;
    int findTeamIdByUserId(int id) throws SQLException;
    String findTeamNameByTeamId(int id) throws SQLException;
    List<ConsultingTeamDTO> findListConsultingTeamsDTOByExpertId(int expertId) throws SQLException;
}
