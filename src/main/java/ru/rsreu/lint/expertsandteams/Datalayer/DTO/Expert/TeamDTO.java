package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert;

/**
 * The TeamDTO class represents a data transfer object for team information.
 * It contains details about the team, including the team name, captain's name,
 * expert's name, current member count, and maximum member count.
 */
public class TeamDTO {
    private String teamName;
    private String captainName;
    private String expertName;
    private int membersCount;
    private int maxMembersCount;

    /**
     * Returns the name of the team.
     *
     * @return A string representing the team's name.
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets the name of the team.
     *
     * @param teamName A string representing the team's name.
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Returns the name of the team captain.
     *
     * @return A string representing the captain's name.
     */
    public String getCaptainName() {
        return captainName;
    }

    /**
     * Sets the name of the team captain.
     *
     * @param captainName A string representing the captain's name.
     */
    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    /**
     * Returns the name of the expert associated with the team.
     *
     * @return A string representing the expert's name.
     */
    public String getExpertName() {
        return expertName;
    }

    /**
     * Sets the name of the expert associated with the team.
     *
     * @param expertName A string representing the expert's name.
     */
    public void setExpertName(String expertName) {
        this.expertName = expertName;
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
}