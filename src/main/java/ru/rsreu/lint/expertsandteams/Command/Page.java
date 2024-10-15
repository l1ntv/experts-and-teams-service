package ru.rsreu.lint.expertsandteams.Command;

import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;

public class Page {

    private String jsp;
    private String url;
    private DirectTypesEnum directTypesEnum;
    private CommandEnum commandEnum;

    public Page() {}

    public Page(String jsp, String url, DirectTypesEnum directTypesEnum, CommandEnum commandEnum) {
        this.jsp = jsp;
        this.url = url;
        this.directTypesEnum = directTypesEnum;
        this.commandEnum = commandEnum;
    }

    public String getJsp() {
        return jsp;
    }

    public void setJsp(String jsp) {
        this.jsp = jsp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DirectTypesEnum getDirectTypes() {
        return directTypesEnum;
    }

    public void setDirectTypes(DirectTypesEnum directTypesEnum) {
        this.directTypesEnum = directTypesEnum;
    }

    public CommandEnum getCommandEnum() {
        return commandEnum;
    }

    public void setCommandEnum(CommandEnum commandEnum) {
        this.commandEnum = commandEnum;
    }
}
