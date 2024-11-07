package ru.rsreu.lint.expertsandteams.Enums;

import ru.rsreu.lint.expertsandteams.Command.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Administrator.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Common.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Service.SearchUserCommand;

public enum CommandEnum {
    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    },
    REDIRECT_TO_LOGIN {
        {
            this.command = new RedirectToLoginCommand();
        }
    },
    REDIRECT_TO_REGISTRATION {
        {
            this.command = new RedirectToRegistrationCommand();
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
    SEARCH_USER {
        {
            this.command = new SearchUserCommand();
        }
    },
    CREATE_USER {
        {
            this.command = new CreateUserCommand();
        }
    },
    DELETE_USER {
        {
            this.command = new DeleteUserCommand();
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
