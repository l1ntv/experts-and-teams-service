package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Common.UserDataDTO;

import java.sql.SQLException;


public interface AuthenticationDataDAO {
    boolean isBannedUser(String login) throws SQLException;

    boolean isCorrectUserDataByLoginAndPassword(UserDataDTO userDataDTO) throws SQLException;

    void setOnlineStatusByUserId(int userId) throws SQLException;

    int getUserIdByLogin(String login) throws SQLException;

    int getUserGroupTypeIdByUserId(int userId) throws SQLException;

    boolean isUserCaptainByUserId(int userId) throws SQLException;
}