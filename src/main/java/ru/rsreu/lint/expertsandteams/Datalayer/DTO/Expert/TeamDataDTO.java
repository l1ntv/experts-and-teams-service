package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert;

/**
 * The TeamDataDTO class represents a data transfer object for team data.
 * It contains information about a team, including its ID, name, captain's ID,
 * current member count, and maximum member count.
 */
public class TeamDataDTO {
    private int id;
    private String name;
    private int captainId;
    private int countMembers;
    private int maxCountMembers;

    /**
     * Constructs a new TeamDataDTO with the specified parameters.
     *
     * @param id              The unique identifier for the team.
     * @param name            The name of the team.
     * @param captainId       The unique identifier of the team captain.
     * @param countMembers    The current number of members in the team.
     * @param maxCountMembers The maximum number of members allowed in the team.
     */
    public TeamDataDTO(int id, String name, int captainId, int countMembers, int maxCountMembers) {
        this.id = id;
        this.name = name;
        this.captainId = captainId;
        this.countMembers = countMembers;
        this.maxCountMembers = maxCountMembers;
    }

    /**
     * Returns the unique identifier of the team.
     *
     * @return An integer representing the team's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the team.
     *
     * @param id An integer representing the team's ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the team.
     *
     * @return A string representing the team's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the team.
     *
     * @param name A string representing the team's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the unique identifier of the team captain.
     *
     * @return An integer representing the captain's ID.
     */
    public int getCaptainId() {
        return captainId;
    }

    /**
     * Sets the unique identifier for the team captain.
     *
     * @param captainId An integer representing the captain's ID.
     */
    public void setCaptainId(int captainId) {
        this.captainId = captainId;
    }

    /**
     * Returns the current number of members in the team.
     *
     * @return An integer representing the current member count.
     */
    public int getCountMembers() {
        return countMembers;
    }

    /**
     * Sets the current number of members in the team.
     *
     * @param countMembers An integer representing the current member count.
     */
    public void setCountMembers(int countMembers) {
        this.countMembers = countMembers;
    }

    /**
     * Returns the maximum number of members allowed in the team.
     *
     * @return An integer representing the maximum member count.
     */
    public int getMaxCountMembers() {
        return maxCountMembers;
    }

    /**
     * Sets the maximum number of members allowed in the team.
     *
     * @param maxCountMembers An integer representing the maximum member count.
     */
    public void setMaxCountMembers(int maxCountMembers) {
        this.maxCountMembers = maxCountMembers;
    }
}