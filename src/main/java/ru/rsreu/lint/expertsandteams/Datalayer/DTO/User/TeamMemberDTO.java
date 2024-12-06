package ru.rsreu.lint.expertsandteams.Datalayer.DTO.User;

import ru.rsreu.lint.expertsandteams.Enums.TeamRoleEnum;

/**
 * The TeamMemberDTO class represents a data transfer object for a team member,
 * including their login, online status, and role within the team.
 */
public class TeamMemberDTO {
    private String login;
    private boolean isOnline;
    private TeamRoleEnum role;

    /**
     * Constructs a new TeamMemberDTO with the specified parameters.
     *
     * @param login    The login of the team member.
     * @param isOnline The online status of the team member.
     * @param role     The role of the team member within the team.
     */
    public TeamMemberDTO(String login, boolean isOnline, TeamRoleEnum role) {
        this.login = login;
        this.isOnline = isOnline;
        this.role = role;
    }

    /**
     * Returns the login of the team member.
     *
     * @return A string representing the login of the team member.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login of the team member.
     *
     * @param login A string representing the login to be set.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Returns the online status of the team member.
     *
     * @return A boolean indicating whether the team member is online.
     */
    public boolean getIsOnline() {
        return isOnline;
    }

    /**
     * Sets the online status of the team member.
     *
     * @param online A boolean indicating the online status to be set.
     */
    public void setOnline(boolean online) {
        isOnline = online;
    }

    /**
     * Returns the role of the team member within the team.
     *
     * @return A TeamRoleEnum representing the role of the team member.
     */
    public TeamRoleEnum getRole() {
        return role;
    }

    /**
     * Sets the role of the team member within the team.
     *
     * @param role A TeamRoleEnum representing the role to be set.
     */
    public void setRole(TeamRoleEnum role) {
        this.role = role;
    }
}