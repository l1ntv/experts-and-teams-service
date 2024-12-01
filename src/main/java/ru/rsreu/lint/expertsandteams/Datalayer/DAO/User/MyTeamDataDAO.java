package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.User.TeamMemberDTO;

import java.sql.SQLException;
import java.util.List;

public interface MyTeamDataDAO {
    int findCountMembersByTeamId(int teamId) throws SQLException;

    int findMaxCountMembersByTeamId(int teamId) throws SQLException;

    List<TeamMemberDTO> findTeamMemberDTOListByTeamId(int teamId) throws SQLException;
}