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
        String expertLogin = (String) request.getParameter(ConfigurationManager.getProperty("EXPERT_LOGIN.CONST"));
        int userId = (int) session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST"));
        int expertId = RequestConsultationLogic.findExpertIdByLogin(expertLogin);
        int teamId = RequestConsultationLogic.findTeamIdByUserId(userId);
        boolean isTeamAlreadySentRequest = false;
        if (RequestConsultationLogic.isTeamSentRequestToExpertByTeamIdAndExpertId(teamId, expertId)) {
            isTeamAlreadySentRequest = true;
        } else {
            RequestConsultationLogic.createNewRequestConsultation(teamId, expertId);
        }
        session.setAttribute(ConfigurationManager.getProperty("IS_TEAM_ALREADY_SENT_REQUEST_FLAG.CONST"), isTeamAlreadySentRequest);
        request.setAttribute(ConfigurationManager.getProperty("USER_ID.CONST"), session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")));
        return new Page(ConfigurationManager.getProperty("USER.CONSULTATIONS.PAGE"), ConfigurationManager.getProperty("USER.CONSULTATIONS.URL"), DirectTypesEnum.REDIRECT, CommandEnum.CONSULTATIONS);
    }
}