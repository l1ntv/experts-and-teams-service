package ru.rsreu.lint.expertsandteams.Command.Commands;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LoginToRegistrationCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) {
        return new Page(ConfigurationManager.getProperty("REGISTRATION.PAGE"), ConfigurationManager.getProperty("REGISTRATION.URL"), DirectTypesEnum.FORWARD, CommandEnum.LOGIN_TO_REGISTRATION);
    }
}
