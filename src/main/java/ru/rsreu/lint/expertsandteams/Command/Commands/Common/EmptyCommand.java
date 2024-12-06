package ru.rsreu.lint.expertsandteams.Command.Commands.Common;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EmptyCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        request.setAttribute(ConfigurationManager.getProperty("USER_ID.CONST"), session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")));
        return new Page(ConfigurationManager.getProperty("REGISTRATION.PAGE"), ConfigurationManager.getProperty("REGISTRATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.REGISTRATION);
    }
}
