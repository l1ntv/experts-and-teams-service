package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert;

public class ConsultingTeamDTO {
    private long teamId;
    private String teamName;
    private String captainLogin;
    private int countMembers;
    private int maxCountMembers;

    public ConsultingTeamDTO() {}

    public ConsultingTeamDTO(long teamId, String teamName, String captainLogin, int countMembers, int maxCountMembers) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.captainLogin = captainLogin;
        this.countMembers = countMembers;
        this.maxCountMembers = maxCountMembers;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCaptainLogin() {
        return captainLogin;
    }

    public void setCaptainLogin(String captainLogin) {
        this.captainLogin = captainLogin;
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
}
