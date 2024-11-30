package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface BannedUsersDataDAO {
    List<UserDTO> getBannedUsersList() throws SQLException;
}
