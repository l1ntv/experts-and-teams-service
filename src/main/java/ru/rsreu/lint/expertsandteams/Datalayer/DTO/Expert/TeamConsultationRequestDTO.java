package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert;

/**
 * The TeamConsultationRequestDTO class represents a data transfer object for a team consultation request.
 * It contains information about the team, including its ID, name, captain's name,
 * current member count, and maximum member count.
 */
public class TeamConsultationRequestDTO {
    private long teamId;
    private String teamName;
    private String captainName;
    private int membersCount;
    private int maxMembersCount;

    /**
     * Constructs a new TeamConsultationRequestDTO with the specified parameters.
     *
     * @param teamId          The unique identifier for the team.
     * @param teamName        The name of the consulting team.
     * @param captainName     The name of the captain of the team.
     * @param membersCount    The current number of members in the team.
     * @param maxMembersCount The maximum number of members allowed in the team.
     */
    public TeamConsultationRequestDTO(long teamId, String teamName, String captainName, int membersCount, int maxMembersCount) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.captainName = captainName;
        this.membersCount = membersCount;
        this.maxMembersCount = maxMembersCount;
    }

    /**
     * Returns the name of the consulting team.
     *
     * @return A string representing the team's name.
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets the name of the consulting team.
     *
     * @param teamName A string representing the team's name.
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Returns the name of the captain of the team.
     *
     * @return A string representing the captain's name.
     */
    public String getCaptainName() {
        return captainName;
    }

    /**
     * Sets the name of the captain of the team.
     *
     * @param captainName A string representing the captain's name.
     */
    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    /**
     * Returns the current number of members in the team.
     *
     * @return An integer representing the current member count.
     */
    public int getMembersCount() {
        return membersCount;
    }

    /**
     * Sets the current number of members in the team.
     *
     * @param membersCount An integer representing the current member count.
     */
    public void setMembersCount(int membersCount) {
        this.membersCount = membersCount;
    }

    /**
     * Returns the maximum number of members allowed in the team.
     *
     * @return An integer representing the maximum member count.
     */
    public int getMaxMembersCount() {
        return maxMembersCount;
    }

    /**
     * Sets the maximum number of members allowed in the team.
     *
     * @param maxMembersCount An integer representing the maximum member count.
     */
    public void setMaxMembersCount(int maxMembersCount) {
        this.maxMembersCount = maxMembersCount;
    }

    /**
     * Returns the unique identifier of the team.
     *
     * @return A long representing the team's ID.
     */
    public long getTeamId() {
        return teamId;
    }

    /**
     * Sets the unique identifier for the team.
     *
     * @param teamId A long representing the team's ID.
     */
    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }
}