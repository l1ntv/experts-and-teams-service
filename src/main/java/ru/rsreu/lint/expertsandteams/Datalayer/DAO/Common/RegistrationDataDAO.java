package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Common.UserDataDTO;

import java.sql.SQLException;

public interface RegistrationDataDAO {
    boolean exists(UserDataDTO userDataDTO) throws SQLException;

    void createUser(UserDataDTO userDataDTO) throws SQLException;

    int getUserIdByLogin(String login) throws SQLException;
}
