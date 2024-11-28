package ru.rsreu.lint.expertsandteams.Command.Commands.User;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.User.RequestConsultationLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class RequestConsultationCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            String expertLogin = (String) request.getParameter("expertLogin");
            int userId = (int) session.getAttribute("userId");
            int expertId = RequestConsultationLogic.findExpertIdByLogin(expertLogin);
            int teamId = RequestConsultationLogic.findTeamIdByUserId(userId);
            boolean isTeamAlreadySentRequest = false;
            if (RequestConsultationLogic.isTeamSentRequestToExpertByTeamIdAndExpertId(teamId, expertId)) {
                isTeamAlreadySentRequest = true;
            } else {
                RequestConsultationLogic.createNewRequestConsultation(teamId, expertId);
            }
            session.setAttribute("isTeamAlreadySentRequest", isTeamAlreadySentRequest);
            return new Page(ConfigurationManager.getProperty("USER.CONSULTATIONS.PAGE"), ConfigurationManager.getProperty("USER.CONSULTATIONS.URL"), DirectTypesEnum.REDIRECT, CommandEnum.CONSULTATIONS);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.LOGIN);
    }
}
