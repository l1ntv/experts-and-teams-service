package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import java.sql.SQLException;

public interface JoinTeamDataDAO {
    int findTeamIdByTeamName(String teamName) throws SQLException;

    boolean isUserJoinedInTeamByUserId(int userId) throws SQLException;

    void changeTeamIdInUserDataTableByUserId(int teamId, int userId) throws SQLException;

    void addNewMemberInTeamMembersTable(int userId, int teamId) throws SQLException;

    void updateCountMembersInTeamsTableByTeamId(int teamId) throws SQLException;
}
