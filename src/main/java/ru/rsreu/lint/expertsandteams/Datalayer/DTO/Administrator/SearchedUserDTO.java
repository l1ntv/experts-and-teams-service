package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator;

import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;

public class SearchedUserDTO {
    private String login;
    private AccountsTypesEnum accountType;
    public SearchedUserDTO() {};

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
