package ru.rsreu.lint.expertsandteams.Command.Commands.Expert;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.User.QuestionAnswerDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.User.AskQuestionLogic;
import ru.rsreu.lint.expertsandteams.Logic.User.ConsultationsLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class DoConsultationCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        int expertId = (int) session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST"));
        int teamId = Integer.parseInt(request.getParameter(ConfigurationManager.getProperty("CONSULTATION_TEAM.CONST")));
        int consultationId = AskQuestionLogic.findConsultationIdByTeamId(teamId);
        List<QuestionAnswerDTO> list = ConsultationsLogic.findQuestionsAndAnswersByConsultationId(consultationId);
        request.setAttribute(ConfigurationManager.getProperty("QUESTIONS_ANSWERS.CONST"), list);
        return new Page(ConfigurationManager.getProperty("EXPERT.DO.CONSULTATION.PAGE"), ConfigurationManager.getProperty("EXPERT.DO.CONSULTATION.URL"), DirectTypesEnum.FORWARD, CommandEnum.DO_CONSULTATION); ////EXPERT.DO.CONSULTATION.PAGE=
    }
}