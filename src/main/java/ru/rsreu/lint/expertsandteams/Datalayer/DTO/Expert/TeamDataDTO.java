package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert;

public class TeamDataDTO {
    private int id;
    private String name;
    private int captainId;
    private int countMembers;
    private int maxCountMembers;

    public TeamDataDTO(int id, String name, int captainId, int countMembers, int maxCountMembers) {
        this.id = id;
        this.name = name;
        this.captainId = captainId;
        this.countMembers = countMembers;
        this.maxCountMembers = maxCountMembers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCaptainId() {
        return captainId;
    }

    public void setCaptainId(int captainId) {
        this.captainId = captainId;
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
