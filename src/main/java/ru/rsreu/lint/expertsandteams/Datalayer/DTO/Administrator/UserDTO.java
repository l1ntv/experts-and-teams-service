package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator;

import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;

/**
 * The UserDTO class is a Data Transfer Object (DTO) that represents a user in the system.
 * It contains information about the user's login and account type.
 */
public class UserDTO {
    private String login;
    private AccountsTypesEnum accountType;

    /**
     * Constructs a new UserDTO with the specified login and account type.
     *
     * @param login       The login of the user.
     * @param accountType The type of account associated with the user.
     */
    public UserDTO(String login, AccountsTypesEnum accountType) {
        this.login = login;
        this.accountType = accountType;
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
     * Sets the login of the user.
     *
     * @param login A string representing the new login of the user.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Returns the type of account associated with the user.
     *
     * @return An {@link AccountsTypesEnum} representing the user's account type.
     */
    public AccountsTypesEnum getAccountType() {
        return accountType;
    }

    /**
     * Sets the type of account associated with the user.
     *
     * @param accountType An {@link AccountsTypesEnum} representing the new account type for the user.
     */
    public void setAccountType(AccountsTypesEnum accountType) {
        this.accountType = accountType;
    }
}