package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert;

/**
 * The ConsultingTeamDTO class represents a data transfer object for a consulting team.
 * It contains information about the team, including its ID, name, captain's login,
 * current member count, and maximum member count.
 */
public class ConsultingTeamDTO {
    private long teamId;
    private String teamName;
    private String captainLogin;
    private int countMembers;
    private int maxCountMembers;

    /**
     * Default constructor for the ConsultingTeamDTO class.
     * Initializes a new instance of the ConsultingTeamDTO with default values.
     */
    public ConsultingTeamDTO() {
    }

    /**
     * Constructs a new ConsultingTeamDTO with the specified parameters.
     *
     * @param teamId          The unique identifier for the team.
     * @param teamName        The name of the consulting team.
     * @param captainLogin    The login of the captain of the team.
     * @param countMembers    The current number of members in the team.
     * @param maxCountMembers The maximum number of members allowed in the team.
     */
    public ConsultingTeamDTO(long teamId, String teamName, String captainLogin, int countMembers, int maxCountMembers) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.captainLogin = captainLogin;
        this.countMembers = countMembers;
        this.maxCountMembers = maxCountMembers;
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
     * Returns the login of the captain of the team.
     *
     * @return A string representing the captain's login.
     */
    public String getCaptainLogin() {
        return captainLogin;
    }

    /**
     * Sets the login of the captain of the team.
     *
     * @param captainLogin A string representing the captain's login.
     */
    public void setCaptainLogin(String captainLogin) {
        this.captainLogin = captainLogin;
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