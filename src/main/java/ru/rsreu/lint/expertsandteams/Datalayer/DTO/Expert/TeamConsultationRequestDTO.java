package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert;

public class TeamConsultationRequestDTO {
    private long teamId;
    private String teamName;
    private String captainName;
    private int membersCount;
    private int maxMembersCount;

    public TeamConsultationRequestDTO(long teamId, String teamName, String captainName, int membersCount, int maxMembersCount) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.captainName = captainName;
        this.membersCount = membersCount;
        this.maxMembersCount = maxMembersCount;
    }

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

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }
}
