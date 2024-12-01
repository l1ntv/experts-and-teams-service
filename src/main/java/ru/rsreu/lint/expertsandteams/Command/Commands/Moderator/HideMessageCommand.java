package ru.rsreu.lint.expertsandteams.Command.Commands.Moderator;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Moderator.ConsultationMessageDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Moderator.MessagesUsersLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class HideMessageCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException, UnsupportedEncodingException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            request.setCharacterEncoding("UTF-8");
            int userId = Integer.parseInt(request.getParameter("userId"));
            int consultationId = Integer.parseInt(request.getParameter("consultationId"));
            String login = request.getParameter("login");
            String message = request.getParameter("message");
            MessagesUsersLogic.hideMessage(consultationId, message);
            List<ConsultationMessageDTO> messagesByExperts = MessagesUsersLogic.findConsultationMessagesByExperts();
            List<ConsultationMessageDTO> messagesByUsers = MessagesUsersLogic.findConsultationMessagesByUsers();
            request.setAttribute("messagesByExperts", messagesByExperts);
            request.setAttribute("messagesByUsers", messagesByUsers);
            return new Page(ConfigurationManager.getProperty("MODERATOR.MESSAGES.USERS.PAGE"), ConfigurationManager.getProperty("MODERATOR.MESSAGES.USERS.URL"), DirectTypesEnum.FORWARD, CommandEnum.MESSAGES_USERS);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.REDIRECT_TO_LOGIN);
    }
}
