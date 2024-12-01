package ru.rsreu.lint.expertsandteams.Command.Commands.User;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.ExpertsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Expert.CancelConsultationLogic;
import ru.rsreu.lint.expertsandteams.Logic.User.ConsultationsLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CancelConsultationByUserCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            int userId = (int) session.getAttribute("userId");
            int teamId = CancelConsultationLogic.findTeamIdByCaptainId(userId);
            int expertId = CancelConsultationLogic.findExpertIdByTeamId(teamId);
            int consultationId = CancelConsultationLogic.findConsultationIdByExpertAndTeamId(expertId, teamId);
            CancelConsultationLogic.deleteRecordFromQuestionAnswersTableByConsultationId(consultationId);
            CancelConsultationLogic.deleteConsultationByExpertAndTeamId(expertId, teamId);
            CancelConsultationLogic.decreaseCountTeamsByExpertId(expertId);
            List<ExpertsStatisticsDTO> list = new ArrayList<>();
            list = ConsultationsLogic.findListAvailableExperts();
            request.setAttribute("listAvailableExperts", list);
            request.setAttribute("myTeam", true);
            request.setAttribute("isTeamHasExpert", false);
            request.setAttribute("isCaptain", true);
            return new Page(ConfigurationManager.getProperty("USER.CONSULTATIONS.PAGE"), ConfigurationManager.getProperty("USER.CONSULTATIONS.URL"), DirectTypesEnum.FORWARD, CommandEnum.CONSULTATIONS);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.REDIRECT_TO_LOGIN);
    }
}
