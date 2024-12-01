package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert;

import java.sql.SQLException;

public interface CancelConsultationDataDAO {
    int findConsultationIdByExpertAndTeamId(int expertId, int teamId) throws SQLException;

    void deleteRecordFromQuestionAnswersTableByConsultationId(int consultationId) throws SQLException;

    void deleteConsultationByExpertAndTeamId(int expertId, int teamId) throws SQLException;

    void decreaseCountTeamsByExpertId(int expertId) throws SQLException;

    int findTeamIdByCaptainId(int captainId) throws SQLException;

    int findExpertIdByTeamId(int teamId) throws SQLException;
}