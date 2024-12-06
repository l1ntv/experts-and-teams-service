package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Common.UserDataDTO;

import java.sql.SQLException;

/**
 * The RegistrationDataDAO interface defines methods for data access operations
 * related to user registration, including checking for existing users,
 * creating new users, and retrieving user IDs by login.
 */
public interface RegistrationDataDAO {

    /**
     * Checks if a user with the specified data already exists in the database.
     *
     * @param userDataDTO The data transfer object containing user information to check.
     * @return true if the user exists, false otherwise.
     * @throws SQLException If a database access error occurs while checking for the user.
     */
    boolean exists(UserDataDTO userDataDTO) throws SQLException;

    /**
     * Creates a new user in the database with the provided user data.
     *
     * @param userDataDTO The data transfer object containing information about the user to create.
     * @throws SQLException If a database access error occurs while creating the user.
     */
    void createUser(UserDataDTO userDataDTO) throws SQLException;

    /**
     * Retrieves the user ID associated with the specified login.
     *
     * @param login The login of the user whose ID is to be retrieved.
     * @return The ID of the user, or -1 if no user with the specified login exists.
     * @throws SQLException If a database access error occurs while retrieving the user ID.
     */
    int getUserIdByLogin(String login) throws SQLException;
}