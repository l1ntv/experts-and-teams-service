package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface BannedUsersDataDAO {
    List<UserDTO> getBannedUsersList() throws SQLException;
}