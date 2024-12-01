package ru.rsreu.lint.expertsandteams.Datalayer.DTO.User;

import java.util.List;

public class MyTeamDTO {
    private String name;
    private int countMembers;
    private int maxCountMembers;
    private List<TeamMemberDTO> teamMembers;

    public MyTeamDTO(String name, int countMembers, int maxCountMembers, List<TeamMemberDTO> teamMembers) {
        this.name = name;
        this.countMembers = countMembers;
        this.maxCountMembers = maxCountMembers;
        this.teamMembers = teamMembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountMembers() {
        return countMembers;
    }

    public void setCountMembers(int countMembers) {
        this.countMembers = countMembers;
    }

    public int getMaxCountMembers() {
        return maxCountMembers;
    }

    public void setMaxCountMembers(int maxCountMembers) {
        this.maxCountMembers = maxCountMembers;
    }

    public List<TeamMemberDTO> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMemberDTO> teamMembers) {
        this.teamMembers = teamMembers;
    }
}
