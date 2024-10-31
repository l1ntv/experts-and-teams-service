package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator;

public class TeamsStatisticsDTO {
    private String name;
    private String captainLogin;
    private int memberCount;
    private int maxMemberCount;
    public TeamsStatisticsDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaptainLogin() {
        return captainLogin;
    }

    public void setCaptainLogin(String captainLogin) {
        this.captainLogin = captainLogin;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public int getMaxMemberCount() {
        return maxMemberCount;
    }

    public void setMaxMemberCount(int maxMemberCount) {
        this.maxMemberCount = maxMemberCount;
    }

    ;

}
