package ru.rsreu.lint.expertsandteams.Command.Commands.Common;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.ConsultingTeamDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamDTO;
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
        int groupTypeId = (int) session.getAttribute(ConfigurationManager.getProperty("GROUP_TYPE_ID.CONST"));
        String jsp = ViewContentDefiner.defineCorrectJspPageByGroupTypeId(groupTypeId);
        switch (groupTypeId) {
            case 0:
                int userId = (int) session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST"));
                List<TeamDTO> list = MainLogic.getListTeams();
                boolean teamFlag = false;
                if (MainLogic.isJoinedInTeamByUserId(userId)) {
                    int teamId = MainLogic.findTeamIdByUserId(userId);
                    String name = MainLogic.findTeamNameByTeamId(teamId);
                    list = MainLogic.swapTeamsInList(list, name);
                    teamFlag = true;
                }
                request.setAttribute(ConfigurationManager.getProperty("TEAM_FLAG.CONST"), teamFlag);
                request.setAttribute(ConfigurationManager.getProperty("TEAMS.CONST"), list);
                break;
            case 1:
                int expertId = (int) session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST"));
                List<ConsultingTeamDTO> listExpert = new ArrayList<>();
                listExpert = MainLogic.findListConsultingTeamsDTOByExpertId(expertId);
                request.setAttribute(ConfigurationManager.getProperty("LIST_EXPERT.CONST"), listExpert);
                int countTeams = ConsultationsRequestsLogic.findCountTeamsByExpertId(expertId);
                int maxCountTeams = ConsultationsRequestsLogic.findMaxCountTeamsByExpertId(expertId);
                request.setAttribute(ConfigurationManager.getProperty("COUNT_TEAMS.CONST"), countTeams);
                request.setAttribute(ConfigurationManager.getProperty("MAX_COUNT_TEAMS.CONST"), maxCountTeams);
                break;
        }
        request.setAttribute(ConfigurationManager.getProperty("USER_ID.CONST"), session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")));
        request.setAttribute(ConfigurationManager.getProperty("USER_LOGIN.CONST"), session.getAttribute(ConfigurationManager.getProperty("USER_LOGIN.CONST")));
        return new Page(jsp, ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.FORWARD, CommandEnum.MAIN);
    }
}