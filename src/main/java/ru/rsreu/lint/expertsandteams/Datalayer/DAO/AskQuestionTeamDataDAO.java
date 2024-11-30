package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import java.sql.SQLException;

public interface AskQuestionTeamDataDAO {
    int findConsultationIdByTeamId(int teamId) throws SQLException;
    void createQuestionByConsultationId(int consultationId, String question) throws SQLException;
}
