package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert;

import java.sql.SQLException;

public interface AnswerToQuestionDataDAO {
    void setAnswerToQuestion(String answer, String question) throws SQLException;
}
