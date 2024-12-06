package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert;

import java.sql.SQLException;

/**
 * The AnswerToQuestionDataDAO interface defines methods for data access operations
 * related to setting answers for questions in the system.
 */
public interface AnswerToQuestionDataDAO {

    /**
     * Sets an answer to a specified question in the database.
     *
     * @param answer   The answer to be set for the question.
     * @param question The question for which the answer is being set.
     * @throws SQLException If a database access error occurs while setting the answer.
     */
    void setAnswerToQuestion(String answer, String question) throws SQLException;
}