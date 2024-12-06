package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.UserDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * The BannedUsersDataDAO interface defines methods for data access operations
 * related to banned users in the system.
 */
public interface BannedUsersDataDAO {

    /**
     * Retrieves a list of users who have been banned from the system.
     *
     * @return A list of {@link UserDTO} objects representing the banned users.
     * @throws SQLException If a database access error occurs while retrieving the list of banned users.
     */
    List<UserDTO> getBannedUsersList() throws SQLException;
}