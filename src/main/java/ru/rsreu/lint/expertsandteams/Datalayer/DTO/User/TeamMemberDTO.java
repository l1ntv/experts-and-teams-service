package ru.rsreu.lint.expertsandteams.Datalayer.DTO.User;

import ru.rsreu.lint.expertsandteams.Enums.TeamRoleEnum;

public class TeamMemberDTO {
    private String login;
    private boolean isOnline;
    private TeamRoleEnum role;

    public TeamMemberDTO(String login, boolean isOnline, TeamRoleEnum role) {
        this.login = login;
        this.isOnline = isOnline;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean getIsOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public TeamRoleEnum getRole() {
        return role;
    }

    public void setRole(TeamRoleEnum role) {
        this.role = role;
    }
}
