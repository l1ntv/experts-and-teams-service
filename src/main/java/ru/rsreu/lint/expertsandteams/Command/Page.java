package ru.rsreu.lint.expertsandteams.Command;

import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;

public final class Page {

    private String jsp;
    private String url;
    private DirectTypesEnum directTypesEnum;
    private CommandEnum commandEnum;

    public Page(String jsp, String url, DirectTypesEnum directTypesEnum, CommandEnum commandEnum) {
        this.jsp = jsp;
        this.url = url;
        this.directTypesEnum = directTypesEnum;
        this.commandEnum = commandEnum;
    }

    public String getJsp() {
        return jsp;
    }

    public String getUrl() {
        return url;
    }

    public DirectTypesEnum getDirectTypes() {
        return directTypesEnum;
    }

    public CommandEnum getCommandEnum() {
        return commandEnum;
    }
}
