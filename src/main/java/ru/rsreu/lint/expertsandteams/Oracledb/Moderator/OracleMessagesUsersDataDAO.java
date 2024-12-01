package ru.rsreu.lint.expertsandteams.Oracledb.Moderator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator.MessagesUsersDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Moderator.ConsultationMessageDTO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleMessagesUsersDataDAO implements MessagesUsersDataDAO {
    private Connection connection;

    public OracleMessagesUsersDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<ConsultationMessageDTO> findConsultationMessagesByExperts() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueryManager.getProperty("MessagesUsersDataDAO.FIND_CONSULTATION_MESSAGES_BY_EXPERTS.SQL.QUERY"));
        List<ConsultationMessageDTO> list = new ArrayList<>();
        while (resultSet.next()) {
            int authorId = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.USER_ID.SQL.CONST"));
            int consultationId = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.CONSULTATION_ID.SQL.CONST"));
            String login = resultSet.getString(SQLQueryManager.getProperty("GENERAL.LOGIN.SQL.CONST"));
            String answer = resultSet.getString(SQLQueryManager.getProperty("GENERAL.ANSWER.SQL.CONST"));
            ConsultationMessageDTO consultationMessageDTO = new ConsultationMessageDTO(authorId, consultationId, login, answer);
            list.add(consultationMessageDTO);
        }
        resultSet.close();
        statement.close();
        return list;
    }

    @Override
    public List<ConsultationMessageDTO> findConsultationMessagesByUsers() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueryManager.getProperty("MessagesUsersDataDAO.FIND_CONSULTATION_MESSAGES_BY_USERS.SQL.QUERY"));
        List<ConsultationMessageDTO> list = new ArrayList<>();
        while (resultSet.next()) {
            int authorId = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.USER_ID.SQL.CONST"));
            int consultationId = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.CONSULTATION_ID.SQL.CONST"));
            String login = resultSet.getString(SQLQueryManager.getProperty("GENERAL.LOGIN.SQL.CONST"));
            String answer = resultSet.getString(SQLQueryManager.getProperty("GENERAL.QUESTION.SQL.CONST"));
            ConsultationMessageDTO consultationMessageDTO = new ConsultationMessageDTO(authorId, consultationId, login, answer);
            list.add(consultationMessageDTO);
        }
        resultSet.close();
        statement.close();
        return list;
    }

    @Override
    public void hideMessage(int consultationId, String message) throws SQLException {
        PreparedStatement preparedStatementQuestion = connection.prepareStatement(SQLQueryManager.getProperty("MessagesUsersDataDAO.HIDE_QUESTION.SQL.QUERY"));
        preparedStatementQuestion.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), consultationId);
        preparedStatementQuestion.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), message);
        PreparedStatement preparedStatementAnswer = connection.prepareStatement(SQLQueryManager.getProperty("MessagesUsersDataDAO.HIDE_ANSWER.SQL.QUERY"));
        preparedStatementAnswer.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), consultationId);
        preparedStatementAnswer.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), message);
        preparedStatementQuestion.execute();
        preparedStatementAnswer.execute();
        preparedStatementAnswer.close();
        preparedStatementQuestion.close();
    }
}