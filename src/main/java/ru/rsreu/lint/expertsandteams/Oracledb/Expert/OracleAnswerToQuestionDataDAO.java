package ru.rsreu.lint.expertsandteams.Oracledb.Expert;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert.AnswerToQuestionDataDAO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleAnswerToQuestionDataDAO implements AnswerToQuestionDataDAO {
    private Connection connection;

    public OracleAnswerToQuestionDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void setAnswerToQuestion(String answer, String question) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AnswerToQuestionDataDAO.SET_ANSWER_TO_QUESTION.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), answer);
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), question);
        preparedStatement.execute();
        preparedStatement.close();
    }
}