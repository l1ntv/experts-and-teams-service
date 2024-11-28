package ru.rsreu.lint.expertsandteams.Command.Commands.Common;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.ConsultingTeamDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.TeamDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Logic.Common.MainLogic;
import ru.rsreu.lint.expertsandteams.Logic.Common.ViewContentDefiner;
import ru.rsreu.lint.expertsandteams.Logic.Expert.ConsultationsRequestsLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            int groupTypeId = (int) session.getAttribute("groupTypeId");
            String jsp = ViewContentDefiner.defineCorrectJspPageByGroupTypeId(groupTypeId);
            switch (groupTypeId) {
                case 0:
                    int userId = (int) session.getAttribute("userId");
                    List<TeamDTO> list = MainLogic.getListTeams();
                    boolean teamFlag = false;
                    if (MainLogic.isJoinedInTeamByUserId(userId)) {
                        int teamId = MainLogic.findTeamIdByUserId(userId);
                        String name = MainLogic.findTeamNameByTeamId(teamId);
                        list = MainLogic.swapTeamsInList(list, name);
                        teamFlag = true;
                    }
                    request.setAttribute("teamFlag", teamFlag);
                    request.setAttribute("teams", list);
                    break;
                case 1:
                    int expertId = (int) session.getAttribute("userId");
                    List<ConsultingTeamDTO> listExpert = new ArrayList<>();
                    listExpert = MainLogic.findListConsultingTeamsDTOByExpertId(expertId);
                    request.setAttribute("listExpert", listExpert);
                    int countTeams = ConsultationsRequestsLogic.findCountTeamsByExpertId(expertId);
                    int maxCountTeams = ConsultationsRequestsLogic.findMaxCountTeamsByExpertId(expertId);
                    request.setAttribute("countTeams", countTeams);
                    request.setAttribute("maxCountTeams", maxCountTeams);
                    break;
            }
            return new Page(jsp, ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.FORWARD, CommandEnum.MAIN);
        }
        else
            return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.REDIRECT_TO_LOGIN);
    }
}
