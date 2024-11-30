package ru.rsreu.lint.expertsandteams.Datalayer.DTO;

import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;

public class UserDTO {
    private String login;
    private AccountsTypesEnum accountType;

    public UserDTO(String login, AccountsTypesEnum accountType) {
        this.login = login;
        this.accountType = accountType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public AccountsTypesEnum getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountsTypesEnum accountType) {
        this.accountType = accountType;
    }
}
