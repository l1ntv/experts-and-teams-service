package ru.rsreu.lint.expertsandteams.Datalayer.DTO.User;

import java.util.List;

/**
 * The MyTeamDTO class represents a data transfer object for a team.
 * It contains information about the team's name, member count, maximum member capacity, and the list of team members.
 */
public class MyTeamDTO {
    private String name;
    private int countMembers;
    private int maxCountMembers;
    private List<TeamMemberDTO> teamMembers;

    /**
     * Constructs a new MyTeamDTO with the specified parameters.
     *
     * @param name            The name of the team.
     * @param countMembers    The current number of members in the team.
     * @param maxCountMembers The maximum number of members that the team can have.
     * @param teamMembers     A list of TeamMemberDTO objects representing the members of the team.
     */
    public MyTeamDTO(String name, int countMembers, int maxCountMembers, List<TeamMemberDTO> teamMembers) {
        this.name = name;
        this.countMembers = countMembers;
        this.maxCountMembers = maxCountMembers;
        this.teamMembers = teamMembers;
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
     * Returns the maximum number of members that the team can have.
     *
     * @return An integer representing the maximum member capacity.
     */
    public int getMaxCountMembers() {
        return maxCountMembers;
    }

    /**
     * Sets the maximum number of members that the team can have.
     *
     * @param maxCountMembers An integer representing the maximum member capacity.
     */
    public void setMaxCountMembers(int maxCountMembers) {
        this.maxCountMembers = maxCountMembers;
    }

    /**
     * Returns a list of TeamMemberDTO objects representing the members of the team.
     *
     * @return A list of TeamMemberDTO objects.
     */
    public List<TeamMemberDTO> getTeamMembers() {
        return teamMembers;
    }

    /**
     * Sets the list of TeamMemberDTO objects representing the members of the team.
     *
     * @param teamMembers A list of TeamMemberDTO objects to be set as team members.
     */
    public void setTeamMembers(List<TeamMemberDTO> teamMembers) {
        this.teamMembers = teamMembers;
    }
}