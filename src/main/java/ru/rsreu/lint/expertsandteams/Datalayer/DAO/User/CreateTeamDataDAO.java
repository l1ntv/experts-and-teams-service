package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import java.sql.SQLException;

public interface CreateTeamDataDAO {
    void createTeamInTeamsTableByCaptainIdAndTeamName(int captainId, String teamName) throws SQLException;

    void createTeamInTeamMembersTableByCaptainIdAndTeamId(int captainId, int teamId) throws SQLException;

    int findTeamIdByTeamName(String teamName) throws SQLException;

    boolean isTeamExistsByName(String teamName) throws SQLException;

    void updateTeamIdFromUserDataTableByUserIdAndTeamId(int teamId, int userId) throws SQLException;
}
