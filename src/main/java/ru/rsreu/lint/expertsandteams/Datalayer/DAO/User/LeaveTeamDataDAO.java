package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import java.sql.SQLException;

public interface LeaveTeamDataDAO {
    boolean isUserCaptainByUserId(int userId) throws SQLException;

    void deleteUserFromTeamMembersTableByUserId(int userId) throws SQLException;

    int findTeamIdByUserId(int userId) throws SQLException;

    void decreaseCountMembersFromTeamsTableByTeamId(int teamId) throws SQLException;

    void updateTeamIdFromUserDataTableByUserId(int userId) throws SQLException;
}