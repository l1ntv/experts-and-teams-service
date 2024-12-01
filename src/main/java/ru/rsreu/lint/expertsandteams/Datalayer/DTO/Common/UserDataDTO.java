package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Common;

public final class UserDataDTO {
    private String login;

    private String password;

    public UserDataDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
