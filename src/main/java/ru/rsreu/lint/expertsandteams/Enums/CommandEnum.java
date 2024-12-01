package ru.rsreu.lint.expertsandteams.Enums;

import ru.rsreu.lint.expertsandteams.Command.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Administrator.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Common.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Expert.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Moderator.*;
import ru.rsreu.lint.expertsandteams.Command.Commands.Administrator.SearchUserByAdminCommand;
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
            this.command = new SearchUserByAdminCommand();
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
    CANCEL_CONSULTATION {
        {
            this.command = new CancelConsultationCommand();
        }
    },
    USER_CANCEL_CONSULTATION {
        {
            this.command = new CancelConsultationByUserCommand();
        }
    },
    ASK_QUESTION {
        {
            this.command = new AskQuestionCommand();
        }
    },
    ANSWER_TO_QUESTION {
        {
            this.command = new AnswerToQuestionCommand();
        }
    },
    SEARCH_USER_BY_MODERATOR {
        {
            this.command = new SearchUserByModeratorCommand();
        }
    },
    HIDE_MESSAGE {
        {
            this.command = new HideMessageCommand();
        }
    },
    BAN_USER {
        {
            this.command = new BanUserCommand();
        }
    },
    UNBAN_USER {
        {
            this.command = new UnbanUserCommand();
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