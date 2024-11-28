package ru.rsreu.lint.expertsandteams.Command.Commands.User;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.ExpertsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
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
        if (session != null && session.getAttribute("userId") != null) {
            int userId = (int) session.getAttribute("userId");
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
                        request.setAttribute("expertsStatisticsDTO", expertsStatisticsDTO);
                    } else {
                        List<ExpertsStatisticsDTO> list = new ArrayList<>();
                        list = ConsultationsLogic.findListAvailableExperts();
                        request.setAttribute("listAvailableExperts", list);
                    }
                } else {
                    if (ConsultationsLogic.isTeamHasExpertByTeamId(teamId)) {
                        isTeamHasExpert = true;
                        ExpertsStatisticsDTO expertsStatisticsDTO = ConsultationsLogic.findTeamExpertByTeamId(teamId);
                        request.setAttribute("expertsStatisticsDTO", expertsStatisticsDTO);
                    }
                }
            }
            request.setAttribute("myTeam", myTeam);
            request.setAttribute("isTeamHasExpert", isTeamHasExpert);
            request.setAttribute("isCaptain", isCaptain);
            return new Page(ConfigurationManager.getProperty("USER.CONSULTATIONS.PAGE"), ConfigurationManager.getProperty("USER.CONSULTATIONS.URL"), DirectTypesEnum.FORWARD, CommandEnum.CONSULTATIONS);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.LOGIN);
    }
}
