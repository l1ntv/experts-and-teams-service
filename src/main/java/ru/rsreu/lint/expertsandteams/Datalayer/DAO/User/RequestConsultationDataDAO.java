package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import java.sql.SQLException;

public interface RequestConsultationDataDAO {
    boolean isTeamSentRequestToExpertByTeamIdAndExpertId(int teamId, int expertId) throws SQLException;

    int findExpertIdByLogin(String login) throws SQLException;

    int findTeamIdByUserId(int userId) throws SQLException;

    void createNewRequestConsultation(int teamId, int expertId) throws SQLException;
}
