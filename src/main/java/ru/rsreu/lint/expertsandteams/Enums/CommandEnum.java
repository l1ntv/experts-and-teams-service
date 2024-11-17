package ru.rsreu.lint.expertsandteams.Enums;

import ru.rsreu.lint.expertsandteams.Command.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Administrator.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Common.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Moderator.AuthUsersModeratorCommand;
import ru.rsreu.lint.expertsandteams.Command.Commands.Moderator.BannedUsersCommand;
import ru.rsreu.lint.expertsandteams.Command.Commands.Moderator.MessagesUsersCommand;
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
    MESSAGES_USERS {
        {
            this.command = new MessagesUsersCommand();
        }
    },
    AUTH_USERS_MODERATOR {
        {
            this.command = new AuthUsersModeratorCommand();
        }
    },
    BANNED_USERS {
        {
            this.command = new BannedUsersCommand();
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
