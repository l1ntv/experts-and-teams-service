package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Common.UserDataDTO;

import java.sql.SQLException;

/**
 * The AuthenticationDataDAO interface defines methods for data access operations
 * related to user authentication, including checking user status and retrieving user information.
 */
public interface AuthenticationDataDAO {

    /**
     * Checks if a user is banned based on their login.
     *
     * @param login The login of the user to check.
     * @return True if the user is banned, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    boolean isBannedUser(String login) throws SQLException;

    /**
     * Validates user credentials by checking the provided login and password.
     *
     * @param userDataDTO The UserDataDTO object containing the user's login and password.
     * @return True if the user data is correct, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    boolean isCorrectUserDataByLoginAndPassword(UserDataDTO userDataDTO) throws SQLException;

    /**
     * Sets the online status of a user based on their user ID.
     *
     * @param userId The ID of the user whose online status is to be set.
     * @throws SQLException If a database access error occurs.
     */
    void setOnlineStatusByUserId(int userId) throws SQLException;

    /**
     * Retrieves the user ID associated with a given login.
     *
     * @param login The login of the user whose ID is to be retrieved.
     * @return The user ID associated with the login.
     * @throws SQLException If a database access error occurs.
     */
    int getUserIdByLogin(String login) throws SQLException;

    /**
     * Retrieves the group type ID associated with a given user ID.
     *
     * @param userId The ID of the user whose group type ID is to be retrieved.
     * @return The group type ID associated with the user ID.
     * @throws SQLException If a database access error occurs.
     */
    int getUserGroupTypeIdByUserId(int userId) throws SQLException;

    /**
     * Checks if a user is a captain based on their user ID.
     *
     * @param userId The ID of the user to check if they are a captain.
     * @return True if the user is a captain, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    boolean isUserCaptainByUserId(int userId) throws SQLException;
}