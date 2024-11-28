package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import java.sql.SQLException;

public interface AcceptTeamDataDAO {
    void deleteRequestFromTableByExpertAndTeamId(int expertId, int teamId) throws SQLException;
    void createConsultationInTableByExpertIdAndTeamId(int expertId, int teamId) throws SQLException;
    void increaseCountTeamsForExpertByExpertId(int expertId) throws SQLException;
}
