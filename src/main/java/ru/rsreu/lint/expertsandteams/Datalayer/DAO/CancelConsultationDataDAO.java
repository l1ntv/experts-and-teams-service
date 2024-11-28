package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import java.sql.SQLException;

public interface CancelConsultationDataDAO {
    void deleteRecordFromQuestionAnswersTableByExpertAndTeamId(int expertId, int teamId) throws SQLException;
    void deleteConsultationByExpertAndTeamId(int expertId, int teamId) throws SQLException;
    void decreaseCountTeamsByExpertId(int expertId) throws SQLException;


}
