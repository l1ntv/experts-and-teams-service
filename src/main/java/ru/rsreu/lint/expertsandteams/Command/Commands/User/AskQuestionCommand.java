package ru.rsreu.lint.expertsandteams.Command.Commands.User;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.CancelConsultationLogic;
import ru.rsreu.lint.expertsandteams.Logic.User.AskQuestionLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class AskQuestionCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            int userId = (int) session.getAttribute("userId");
            String question = request.getParameter("question");
            int teamId = CancelConsultationLogic.findTeamIdByCaptainId(userId);
            int consultationId = AskQuestionLogic.findConsultationIdByTeamId(teamId);
            AskQuestionLogic.createQuestionByConsultationId(consultationId, question);
            session.setAttribute("isQuestionAsked", true);
            return new Page(ConfigurationManager.getProperty("USER.CONSULTATIONS.PAGE"), ConfigurationManager.getProperty("USER.CONSULTATIONS.URL"), DirectTypesEnum.REDIRECT, CommandEnum.CONSULTATIONS);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.REDIRECT_TO_LOGIN);
    }
}
