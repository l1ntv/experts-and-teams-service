package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator;

public class ExpertsStatisticsDTO {
    private String login;
    private int teamCount;
    private int maxTeamCount;

    public ExpertsStatisticsDTO(String login, int teamCount, int maxTeamCount) {
        this.login = login;
        this.teamCount = teamCount;
        this.maxTeamCount = maxTeamCount;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getTeamCount() {
        return teamCount;
    }

    public void setTeamCount(int teamCount) {
        this.teamCount = teamCount;
    }

    public int getMaxTeamCount() {
        return maxTeamCount;
    }

    public void setMaxTeamCount(int maxTeamCount) {
        this.maxTeamCount = maxTeamCount;
    }
}
