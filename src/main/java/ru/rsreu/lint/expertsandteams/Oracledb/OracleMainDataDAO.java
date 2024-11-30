package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.MainDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.ConsultingTeamDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.TeamData;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleMainDataDAO implements MainDataDAO {

    private Connection connection;

    public OracleMainDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<TeamData> getListTeams() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueryManager.getProperty("MainDataDAO.GET_LIST_TEAM"));
        List<TeamData> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("TEAM_ID");
            String name = resultSet.getString("NAME");
            int captainId = resultSet.getInt("CAPTAIN_ID");
            int countMembers = resultSet.getInt("COUNT_MEMBERS");
            int maxCountMembers = resultSet.getInt("MAX_COUNT_MEMBERS");
            TeamData team = new TeamData(id, name, captainId, countMembers, maxCountMembers);
            list.add(team);
        }
        resultSet.close();
        statement.close();
        return list;
    }

    @Override
    public String getCaptainLoginByCaptainId(int captainId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("MainDataDAO.FIND_CAPTAIN_LOGIN_BY_CAPTAIN_ID"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), captainId);
        ResultSet resultSet = preparedStatement.executeQuery();
        String result = "None";
        while (resultSet.next()) {
            result = resultSet.getString("LOGIN");
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public String getExpertLoginByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("MainDataDAO.FIND_EXPERT_LOGIN_BY_TEAM_ID"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        String result = "None";
        while (resultSet.next()) {
            result = resultSet.getString("LOGIN");
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public boolean isUserJoinedInTeamByUserId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("MainDataDAO.IS_USER_JOINED_IN_TEAM_BY_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean result = false;
        while (resultSet.next()) {
            result = resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        preparedStatement.close();
        resultSet.close();
        return result;
    }

    @Override
    public int findTeamIdByUserId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("MainDataDAO.FIND_TEAM_ID_BY_USER_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        int teamId = -1;
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            teamId = resultSet.getInt("TEAM_ID");
        }
        resultSet.close();
        preparedStatement.close();
        return teamId;
    }

    @Override
    public String findTeamNameByTeamId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("MainDataDAO.FIND_TEAM_NAME_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        ResultSet resultSet = preparedStatement.executeQuery();
        String name = "";
        while (resultSet.next()) {
            name = resultSet.getString("NAME");
        }
        resultSet.close();
        preparedStatement.close();
        return name;
    }

    @Override
    public List<ConsultingTeamDTO> findListConsultingTeamsDTOByExpertId(int expertId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("MainDataDAO.FIND_LIST_CONSULTING_TEAMS_DTO_BY_EXPERT_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), expertId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<ConsultingTeamDTO> list = new ArrayList<>();
        while (resultSet.next()) {
            long teamId = resultSet.getInt("TEAM_ID");
            String teamName = resultSet.getString("NAME");
            String login = resultSet.getString("LOGIN");
            int countMembers = resultSet.getInt("COUNT_MEMBERS");
            int maxCountMembers = resultSet.getInt("MAX_COUNT_MEMBERS");
            ConsultingTeamDTO consultingTeamDTO = new ConsultingTeamDTO(teamId, teamName, login, countMembers, maxCountMembers);
            list.add(consultingTeamDTO);
        }
        resultSet.close();
        preparedStatement.close();
        return list;
    }
}
