package ru.rsreu.lint.expertsandteams.Command.Commands.Expert;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamConsultationRequestDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Expert.AcceptTeamLogic;
import ru.rsreu.lint.expertsandteams.Logic.Expert.ConsultationsRequestsLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AcceptTeamCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            int expertId = (int) session.getAttribute("userId");
            int teamId = Integer.parseInt(request.getParameter("acceptTeam"));
            AcceptTeamLogic.deleteRequestFromTableByExpertIdAndTeamId(expertId, teamId);
            AcceptTeamLogic.createConsultationInTableByExpertIdAndTeamId(expertId, teamId);
            AcceptTeamLogic.increaseCountTeamsForExpertByExpertId(expertId);
            List<TeamConsultationRequestDTO> list = new ArrayList<>();
            list = ConsultationsRequestsLogic.findConsultationsRequestsFromTeams(expertId);
            int countTeams = ConsultationsRequestsLogic.findCountTeamsByExpertId(expertId);
            int maxCountTeams = ConsultationsRequestsLogic.findMaxCountTeamsByExpertId(expertId);
            request.setAttribute("consultationsRequests", list);
            request.setAttribute("countTeams", countTeams);
            request.setAttribute("maxCountTeams", maxCountTeams);
            return new Page(ConfigurationManager.getProperty("EXPERT.CONSULTATIONS.REQUESTS.PAGE"), ConfigurationManager.getProperty("EXPERT.CONSULTATIONS.REQUESTS.URL"), DirectTypesEnum.FORWARD, CommandEnum.CONSULTATIONS_REQUESTS);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.REDIRECT_TO_LOGIN);
    }
}
