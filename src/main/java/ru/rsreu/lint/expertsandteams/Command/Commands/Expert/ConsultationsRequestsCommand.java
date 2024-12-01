package ru.rsreu.lint.expertsandteams.Command.Commands.Expert;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamConsultationRequestDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Expert.ConsultationsRequestsLogic;
import ru.rsreu.lint.expertsandteams.Logic.User.ConsultationsLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultationsRequestsCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) != null) {
            int expertId = (int) session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST"));
            List<TeamConsultationRequestDTO> list = new ArrayList<>();
            list = ConsultationsRequestsLogic.findConsultationsRequestsFromTeams(expertId);
            int countTeams = ConsultationsRequestsLogic.findCountTeamsByExpertId(expertId);
            int maxCountTeams = ConsultationsRequestsLogic.findMaxCountTeamsByExpertId(expertId);
            request.setAttribute(ConfigurationManager.getProperty("CONSULTATION_REQUESTS.CONST"), list);
            request.setAttribute(ConfigurationManager.getProperty("COUNT_TEAMS.CONST"), countTeams);
            request.setAttribute(ConfigurationManager.getProperty("MAX_COUNT_TEAMS.CONST"), maxCountTeams);
            return new Page(ConfigurationManager.getProperty("EXPERT.CONSULTATIONS.REQUESTS.PAGE"), ConfigurationManager.getProperty("EXPERT.CONSULTATIONS.REQUESTS.URL"), DirectTypesEnum.FORWARD, CommandEnum.CONSULTATIONS_REQUESTS);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.REDIRECT_TO_LOGIN);
    }
}
