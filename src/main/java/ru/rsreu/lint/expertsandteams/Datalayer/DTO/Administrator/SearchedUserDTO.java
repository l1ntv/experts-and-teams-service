package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator;

import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;

/**
 * The SearchedUserDTO class is a Data Transfer Object (DTO) that represents a user
 * in the system. It contains information about the user's login and account type.
 */
public class SearchedUserDTO {
    private String login;
    private AccountsTypesEnum accountType;

    /**
     * Default constructor for SearchedUserDTO.
     * Initializes a new instance of SearchedUserDTO with default values.
     */
    public SearchedUserDTO() {
    }

    /**
     * Returns the login of the user.
     *
     * @return A string representing the login of the user.
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
     * Returns the account type of the user.
     *
     * @return An {@link AccountsTypesEnum} representing the account type of the user.
     */
    public AccountsTypesEnum getAccountType() {
        return accountType;
    }

    /**
     * Sets the account type of the user.
     *
     * @param accountType An {@link AccountsTypesEnum} representing the new account type of the user.
     */
    public void setAccountType(AccountsTypesEnum accountType) {
        this.accountType = accountType;
    }
}