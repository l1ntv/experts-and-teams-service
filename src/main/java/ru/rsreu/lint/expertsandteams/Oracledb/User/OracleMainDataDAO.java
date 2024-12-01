package ru.rsreu.lint.expertsandteams.Oracledb.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.User.MainDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.ConsultingTeamDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamDataDTO;
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
    public List<TeamDataDTO> getListTeams() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueryManager.getProperty("MainDataDAO.GET_LIST_TEAM"));
        List<TeamDataDTO> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.TEAM_ID.SQL.CONST"));
            String name = resultSet.getString(SQLQueryManager.getProperty("GENERAL.NAME.SQL.CONST"));
            int captainId = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.CAPTAIN_ID.SQL.CONST"));
            int countMembers = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.COUNT_MEMBERS.SQL.CONST"));
            int maxCountMembers = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.NAX_COUNT_MEMBERS.SQL.CONST"));
            TeamDataDTO team = new TeamDataDTO(id, name, captainId, countMembers, maxCountMembers);
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
        String result = SQLQueryManager.getProperty("GENERAL.NONE_RESULT.SQL.CONST");
        while (resultSet.next()) {
            result = resultSet.getString(SQLQueryManager.getProperty("GENERAL.LOGIN.SQL.CONST"));
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
        String result = SQLQueryManager.getProperty("GENERAL.NONE_RESULT.SQL.CONST");
        while (resultSet.next()) {
            result = resultSet.getString(SQLQueryManager.getProperty("GENERAL.LOGIN.SQL.CONST"));
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
            teamId = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.TEAM_ID.SQL.CONST"));
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
        String name = SQLQueryManager.getProperty("GENERAL.NONE_RESULT.SQL.CONST");
        while (resultSet.next()) {
            name = resultSet.getString(SQLQueryManager.getProperty("GENERAL.NAME.SQL.CONST"));
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
            long teamId = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.TEAM_ID.SQL.CONST"));
            String teamName = resultSet.getString(SQLQueryManager.getProperty("GENERAL.NAME.SQL.CONST"));
            String login = resultSet.getString(SQLQueryManager.getProperty("GENERAL.LOGIN.SQL.CONST"));
            int countMembers = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.COUNT_MEMBERS.SQL.CONST"));
            int maxCountMembers = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.NAX_COUNT_MEMBERS.SQL.CONST"));
            ConsultingTeamDTO consultingTeamDTO = new ConsultingTeamDTO(teamId, teamName, login, countMembers, maxCountMembers);
            list.add(consultingTeamDTO);
        }
        resultSet.close();
        preparedStatement.close();
        return list;
    }
}