package ru.rsreu.lint.expertsandteams.Logic.Expert;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AnswerToQuestionDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;

import java.sql.SQLException;

public class AnswerToQuestionLogic {
    public static void setAnswerToQuestion(String answer, String question) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AnswerToQuestionDataDAO answerToQuestionDataDAO = factory.getAnswerToQuestionDataDAO();
        answerToQuestionDataDAO.setAnswerToQuestion(answer, question);
    }
}
