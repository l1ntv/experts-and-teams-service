package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Common;

/**
 * The UserDataDTO class is a Data Transfer Object (DTO) that represents user data,
 * including the user's login credentials such as login and password.
 */
public final class UserDataDTO {
    private String login;
    private String password;

    /**
     * Constructs a new UserDataDTO with the specified login and password.
     *
     * @param login    The login of the user.
     * @param password The password of the user.
     */
    public UserDataDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Returns the login of the user.
     *
     * @return A string representing the user's login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Returns the password of the user.
     *
     * @return A string representing the user's password.
     */
    public String getPassword() {
        return password;
    }
}