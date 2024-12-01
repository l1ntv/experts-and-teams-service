package ru.rsreu.lint.expertsandteams.Command.Commands.Moderator;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Moderator.ConsultationMessageDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Moderator.MessagesUsersLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class MessagesUsersCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        List<ConsultationMessageDTO> messagesByExperts = MessagesUsersLogic.findConsultationMessagesByExperts();
        List<ConsultationMessageDTO> messagesByUsers = MessagesUsersLogic.findConsultationMessagesByUsers();
        request.setAttribute(ConfigurationManager.getProperty("MESSAGES_BY_EXPERTS"), messagesByExperts);
        request.setAttribute(ConfigurationManager.getProperty("MESSAGES_BY_USERS"), messagesByUsers);
        return new Page(ConfigurationManager.getProperty("MODERATOR.MESSAGES.USERS.PAGE"), ConfigurationManager.getProperty("MODERATOR.MESSAGES.USERS.URL"), DirectTypesEnum.FORWARD, CommandEnum.MESSAGES_USERS);
    }
}