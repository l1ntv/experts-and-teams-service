package ru.rsreu.lint.expertsandteams.Logic.Common;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.MainDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.ConsultingTeamDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.TeamDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.TeamData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainLogic {

    public static List<TeamDTO> getListTeams() throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        MainDataDAO oracleMainDataDAO = factory.getMainDataDAO();
        ResultSet resultSet = oracleMainDataDAO.getListTeams();
        List<TeamData> list = new ArrayList<>();
        list = MainLogic.convertTeamResultListToArrayList(resultSet, list);
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
                list.add(0, team);//Vadim123_Lint1234
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

    private static List<TeamData> convertTeamResultListToArrayList(ResultSet resultSet, List<TeamData> list) throws SQLException {
        while (resultSet.next()) {
            TeamData team = new TeamData(); // classNotFound
            team.setId(resultSet.getInt("TEAM_ID"));
            team.setName(resultSet.getString("NAME"));
            team.setCaptainId(resultSet.getInt("CAPTAIN_ID"));
            team.setCountMembers(resultSet.getInt("COUNT_MEMBERS"));
            team.setMaxCountMembers(resultSet.getInt("MAX_COUNT_MEMBERS"));
            list.add(team);
        }
        return list;
    }

    private static List<TeamDTO> convertTeamListToTeamDTOList(List<TeamData> teamList, List<TeamDTO> teamDTOList) throws SQLException {
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
