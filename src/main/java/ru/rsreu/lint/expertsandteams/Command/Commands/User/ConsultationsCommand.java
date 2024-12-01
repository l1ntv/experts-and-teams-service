package ru.rsreu.lint.expertsandteams.Command.Commands.User;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.ExpertsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.User.QuestionAnswerDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.User.AskQuestionLogic;
import ru.rsreu.lint.expertsandteams.Logic.User.ConsultationsLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultationsCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST"));
        boolean myTeam = false;
        boolean isCaptain = false;
        boolean isTeamHasExpert = false;
        if (ConsultationsLogic.isJoinedInTeamByUserId(userId)) {
            myTeam = true;
            int teamId = ConsultationsLogic.findTeamIdByUserId(userId);
            if (ConsultationsLogic.isUserCaptainByUserId(userId)) {
                isCaptain = true;
                if (ConsultationsLogic.isTeamHasExpertByTeamId(teamId)) {
                    isTeamHasExpert = true;
                    ExpertsStatisticsDTO expertsStatisticsDTO = ConsultationsLogic.findTeamExpertByTeamId(teamId);
                    int consultationId = AskQuestionLogic.findConsultationIdByTeamId(teamId);
                    List<QuestionAnswerDTO> list = ConsultationsLogic.findQuestionsAndAnswersByConsultationId(consultationId);
                    request.setAttribute(ConfigurationManager.getProperty("IS_QUESTIONS_ANSWERS_FLAG.CONST"), list);
                    request.setAttribute(ConfigurationManager.getProperty("EXPERTS_STATISTICS_DTO.CONST"), expertsStatisticsDTO);
                } else {
                    List<ExpertsStatisticsDTO> list = new ArrayList<>();
                    list = ConsultationsLogic.findListAvailableExperts();
                    request.setAttribute(ConfigurationManager.getProperty("LIST_AVAILABLE_EXPERTS.CONST"), list);
                }
            } else {
                if (ConsultationsLogic.isTeamHasExpertByTeamId(teamId)) {
                    isTeamHasExpert = true;
                    ExpertsStatisticsDTO expertsStatisticsDTO = ConsultationsLogic.findTeamExpertByTeamId(teamId);
                    int consultationId = AskQuestionLogic.findConsultationIdByTeamId(teamId);
                    List<QuestionAnswerDTO> list = ConsultationsLogic.findQuestionsAndAnswersByConsultationId(consultationId);
                    request.setAttribute(ConfigurationManager.getProperty("IS_QUESTIONS_ANSWERS_FLAG.CONST"), list);
                    request.setAttribute(ConfigurationManager.getProperty("EXPERTS_STATISTICS_DTO.CONST"), expertsStatisticsDTO);
                }
            }
        }
        request.setAttribute(ConfigurationManager.getProperty("MY_TEAM.CONST"), myTeam);
        request.setAttribute(ConfigurationManager.getProperty("IS_TEAM_HAS_EXPERT_FLAG.CONST"), isTeamHasExpert);
        request.setAttribute(ConfigurationManager.getProperty("IS_CAPTAIN_FLAG.CONST"), isCaptain);
        return new Page(ConfigurationManager.getProperty("USER.CONSULTATIONS.PAGE"), ConfigurationManager.getProperty("USER.CONSULTATIONS.URL"), DirectTypesEnum.FORWARD, CommandEnum.CONSULTATIONS);
    }
}