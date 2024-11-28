package ru.rsreu.lint.expertsandteams.Enums;

import ru.rsreu.lint.expertsandteams.Command.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Administrator.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Common.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Expert.AcceptTeamCommand;
import ru.rsreu.lint.expertsandteams.Command.Commands.Expert.ConsultationsRequestsCommand;
import ru.rsreu.lint.expertsandteams.Command.Commands.Expert.DoConsultationCommand;
import ru.rsreu.lint.expertsandteams.Command.Commands.Moderator.AuthUsersModeratorCommand;
import ru.rsreu.lint.expertsandteams.Command.Commands.Moderator.BannedUsersCommand;
import ru.rsreu.lint.expertsandteams.Command.Commands.Moderator.MessagesUsersCommand;
import ru.rsreu.lint.expertsandteams.Command.Commands.Service.SearchUserCommand;
import ru.rsreu.lint.expertsandteams.Command.Commands.User.*;

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
    MY_TEAM {
        {
            this.command = new MyTeamCommand();
        }
    },
    CREATE_TEAM {
        {
            this.command = new CreateTeamCommand();
        }
    },
    CREATE_NEW_TEAM {
        {
            this.command = new CreateNewTeamCommand();
        }
    },
    LEAVE_TEAM {
        {
            this.command = new LeaveTeamCommand();
        }
    },
    JOIN_TEAM {
        {
            this.command = new JoinTeamCommand();
        }
    },
    NO_PLACES {
        {
            this.command = new NoPlacesCommand();
        }
    },
    CONSULTATIONS {
        {
            this.command = new ConsultationsCommand();
        }
    },
    REQUEST_CONSULTATION {
        {
            this.command = new RequestConsultationCommand();
        }
    },
    CONSULTATIONS_REQUESTS {
        {
            this.command = new ConsultationsRequestsCommand();
        }
    },
    DO_CONSULTATION {
        {
            this.command = new DoConsultationCommand();
        }
    },
    ACCEPT_CONSULTATION {
        {
            this.command = new AcceptTeamCommand();
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
