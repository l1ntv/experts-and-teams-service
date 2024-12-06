package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator;

/**
 * The TeamsStatisticsDTO class is a Data Transfer Object (DTO) that represents
 * statistics related to a team in the system. It contains information about the team's
 * name, captain, and member counts.
 */
public class TeamsStatisticsDTO {
    private String name;
    private String captainLogin;
    private int memberCount;
    private int maxMemberCount;

    /**
     * Constructs a new TeamsStatisticsDTO with the specified team name, captain's login,
     * current member count, and maximum member count.
     *
     * @param name            The name of the team.
     * @param captainLogin    The login of the team captain.
     * @param membersCount    The current number of members in the team.
     * @param maxMembersCount The maximum number of members allowed in the team.
     */
    public TeamsStatisticsDTO(String name, String captainLogin, int membersCount, int maxMembersCount) {
        this.name = name;
        this.captainLogin = captainLogin;
        this.memberCount = membersCount;
        this.maxMemberCount = maxMembersCount;
    }

    /**
     * Returns the name of the team.
     *
     * @return A string representing the name of the team.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the team.
     *
     * @param name A string representing the new name of the team.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the login of the team captain.
     *
     * @return A string representing the login of the captain.
     */
    public String getCaptainLogin() {
        return captainLogin;
    }

    /**
     * Sets the login of the team captain.
     *
     * @param captainLogin A string representing the new login of the captain.
     */
    public void setCaptainLogin(String captainLogin) {
        this.captainLogin = captainLogin;
    }

    /**
     * Returns the current number of members in the team.
     *
     * @return An integer representing the current member count.
     */
    public int getMemberCount() {
        return memberCount;
    }

    /**
     * Sets the current number of members in the team.
     *
     * @param memberCount An integer representing the new member count.
     */
    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    /**
     * Returns the maximum number of members allowed in the team.
     *
     * @return An integer representing the maximum member count.
     */
    public int getMaxMemberCount() {
        return maxMemberCount;
    }

    /**
     * Sets the maximum number of members allowed in the team.
     *
     * @param maxMemberCount An integer representing the new maximum member count.
     */
    public void setMaxMemberCount(int maxMemberCount) {
        this.maxMemberCount = maxMemberCount;
    }
}