package ru.rsreu.lint.expertsandteams.Logic.Common;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.User.MainDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.ConsultingTeamDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamDataDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainLogic {

    public static List<TeamDTO> getListTeams() throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        MainDataDAO oracleMainDataDAO = factory.getMainDataDAO();
        List<TeamDataDTO> list = oracleMainDataDAO.getListTeams();
        List<TeamDTO> listDTO = new ArrayList<>();
        return MainLogic.convertTeamListToTeamDTOList(list, listDTO);
    }

    public static boolean isJoinedInTeamByUserId(int id) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        MainDataDAO oracleMainDataDAO = factory.getMainDataDAO();
        return oracleMainDataDAO.isUserJoinedInTeamByUserId(id);
    }

    public static int findTeamIdByUserId(int id) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        MainDataDAO oracleMainDataDAO = factory.getMainDataDAO();
        return oracleMainDataDAO.findTeamIdByUserId(id);
    }

    public static String findTeamNameByTeamId(int id) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        MainDataDAO oracleMainDataDAO = factory.getMainDataDAO();
        return oracleMainDataDAO.findTeamNameByTeamId(id);
    }

    public static List<TeamDTO> swapTeamsInList(List<TeamDTO> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTeamName().equals(name)) {
                TeamDTO team = list.get(i);
                list.remove(i);
                list.add(0, team);
                return list;
            }
        }
        return list;
    }

    public static List<ConsultingTeamDTO> findListConsultingTeamsDTOByExpertId(int expertId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        MainDataDAO oracleMainDataDAO = factory.getMainDataDAO();
        return oracleMainDataDAO.findListConsultingTeamsDTOByExpertId(expertId);
    }

    private static List<TeamDTO> convertTeamListToTeamDTOList(List<TeamDataDTO> teamList, List<TeamDTO> teamDTOList) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        MainDataDAO oracleMainDataDAO = factory.getMainDataDAO();
        for (int i = 0; i < teamList.size(); i++) {
            TeamDTO teamDto = new TeamDTO();
            teamDto.setCaptainName(oracleMainDataDAO.getCaptainLoginByCaptainId(teamList.get(i).getCaptainId()));
            teamDto.setTeamName(teamList.get(i).getName());
            teamDto.setExpertName(oracleMainDataDAO.getExpertLoginByTeamId(teamList.get(i).getId()));
            teamDto.setMembersCount(teamList.get(i).getCountMembers());
            teamDto.setMaxMembersCount(teamList.get(i).getMaxCountMembers());
            teamDTOList.add(teamDto);
        }
        return teamDTOList;
    }
}
