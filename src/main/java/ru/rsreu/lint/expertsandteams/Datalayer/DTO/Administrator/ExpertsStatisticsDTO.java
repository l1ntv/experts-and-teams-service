package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator;

/**
 * The ExpertsStatisticsDTO class is a Data Transfer Object (DTO) that holds statistics
 * related to experts. It encapsulates the login of an expert, the count of teams they
 * consult, and the maximum number of teams they can consult.
 */
public class ExpertsStatisticsDTO {

    private String login;
    private int consultingTeamCount;
    private int maxConsultingTeamCount;

    /**
     * Constructs a new ExpertsStatisticsDTO with the specified login, consulting team count,
     * and maximum consulting team count.
     *
     * @param login                  The login of the expert.
     * @param consultingTeamCount    The current number of teams the expert consults.
     * @param maxConsultingTeamCount The maximum number of teams the expert can consult.
     */
    public ExpertsStatisticsDTO(String login, int consultingTeamCount, int maxConsultingTeamCount) {
        this.login = login;
        this.consultingTeamCount = consultingTeamCount;
        this.maxConsultingTeamCount = maxConsultingTeamCount;
    }

    /**
     * Returns the login of the expert.
     *
     * @return A string representing the login of the expert.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login of the expert.
     *
     * @param login A string representing the new login of the expert.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Returns the current number of teams the expert consults.
     *
     * @return An integer representing the count of consulting teams.
     */
    public int getConsultingTeamCount() {
        return consultingTeamCount;
    }

    /**
     * Sets the current number of teams the expert consults.
     *
     * @param consultingTeamCount An integer representing the new count of consulting teams.
     */
    public void setConsultingTeamCount(int consultingTeamCount) {
        this.consultingTeamCount = consultingTeamCount;
    }

    /**
     * Returns the maximum number of teams the expert can consult.
     *
     * @return An integer representing the maximum count of consulting teams.
     */
    public int getMaxConsultingTeamCount() {
        return maxConsultingTeamCount;
    }

    /**
     * Sets the maximum number of teams the expert can consult.
     *
     * @param maxConsultingTeamCount An integer representing the new maximum count of consulting teams.
     */
    public void setMaxConsultingTeamCount(int maxConsultingTeamCount) {
        this.maxConsultingTeamCount = maxConsultingTeamCount;
    }
}