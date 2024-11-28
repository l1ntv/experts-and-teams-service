package ru.rsreu.lint.expertsandteams.Command.Commands.Expert;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamConsultationRequestDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Expert.ConsultationsRequestsLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoConsultationCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            int expertId = (int) session.getAttribute("userId");
            List<TeamConsultationRequestDTO> list = new ArrayList<>();
            list = ConsultationsRequestsLogic.findConsultationsRequestsFromTeams(expertId);
            request.setAttribute("consultationsChats", list);
            return new Page(ConfigurationManager.getProperty("EXPERT.DO.CONSULTATION.PAGE"), ConfigurationManager.getProperty("EXPERT.DO.CONSULTATION.URL"), DirectTypesEnum.FORWARD, CommandEnum.DO_CONSULTATION); ////EXPERT.DO.CONSULTATION.PAGE=
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.REDIRECT_TO_LOGIN);
    }
}
