package ru.rsreu.lint.expertsandteams.Enums;

import ru.rsreu.lint.expertsandteams.Command.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Administrator.AuthUsersCommand;
import ru.rsreu.lint.expertsandteams.Command.Commands.Administrator.ExpertsStatisticsCommand;
import ru.rsreu.lint.expertsandteams.Command.Commands.Administrator.TeamsStatisticsCommand;

public enum CommandEnum {
    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    },
    REGISTRATION_TO_LOGIN {
        {
            this.command = new RegistrationToLoginCommand();
        }
    },
    LOGIN_TO_REGISTRATION {
        {
            this.command = new LoginToRegistrationCommand();
        }
    },
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    MAIN {
        {
            this.command = new MainCommand();
        }
    },
    AUTH_USERS {
        {
            this.command = new AuthUsersCommand();
        }
    },
    TEAMS_STATISTICS {
        {
            this.command = new TeamsStatisticsCommand();
        }
    },
    EXPERTS_STATISTICS {
        {
            this.command = new ExpertsStatisticsCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return this.command;
    }
}
