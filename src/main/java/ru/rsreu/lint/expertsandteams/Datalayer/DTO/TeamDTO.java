package ru.rsreu.lint.expertsandteams.Datalayer.DTO;

public class TeamDTO {
    private String teamName;
    private String captainName;
    private String expertName;
    private int membersCount;
    private int maxMembersCount;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public int getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(int membersCount) {
        this.membersCount = membersCount;
    }

    public int getMaxMembersCount() {
        return maxMembersCount;
    }

    public void setMaxMembersCount(int maxMembersCount) {
        this.maxMembersCount = maxMembersCount;
    }
}
