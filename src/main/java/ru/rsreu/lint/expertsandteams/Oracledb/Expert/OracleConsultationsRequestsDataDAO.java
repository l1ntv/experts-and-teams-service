package ru.rsreu.lint.expertsandteams.Oracledb.Expert;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert.ConsultationsRequestsDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamConsultationRequestDTO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleConsultationsRequestsDataDAO implements ConsultationsRequestsDataDAO {
    private Connection connection;

    public OracleConsultationsRequestsDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int findCountTeamsByExpertId(int expertId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("ConsultationsRequestsDataDAO.FIND_COUNT_TEAMS_BY_EXPERT_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), expertId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int countTeams = -1;
        while (resultSet.next()) {
            countTeams = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.COUNT_TEAMS.SQL.CONST"));
        }
        resultSet.close();
        preparedStatement.close();
        return countTeams;
    }

    @Override
    public int findMaxCountTeamsByExpertId(int expertId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("ConsultationsRequestsDataDAO.FIND_MAX_COUNT_TEAMS_BY_EXPERT_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), expertId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int maxCountTeams = -1;
        while (resultSet.next()) {
            maxCountTeams = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.MAX_COUNT_TEAMS.SQL.CONST"));
        }
        resultSet.close();
        preparedStatement.close();
        return maxCountTeams;
    }

    @Override
    public List<TeamConsultationRequestDTO> findConsultationsRequestsFromTeams(int expertId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("ConsultationsRequestsDataDAO.FIND_CONSULTATIONS_REQUESTS_FROM_TEAMS.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), expertId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<TeamConsultationRequestDTO> list = new ArrayList<>();
        while (resultSet.next()) {
            long teamId = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.TEAM_ID.SQL.CONST"));
            String teamName = resultSet.getString(SQLQueryManager.getProperty("GENERAL.NAME.SQL.CONST"));
            String captainName = resultSet.getString(SQLQueryManager.getProperty("GENERAL.LOGIN.SQL.CONST"));
            int countMembers = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.COUNT_MEMBERS.SQL.CONST"));
            int maxCountMembers = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.NAX_COUNT_MEMBERS.SQL.CONST"));
            TeamConsultationRequestDTO teamConsultationRequestDTO = new TeamConsultationRequestDTO(teamId, teamName, captainName, countMembers, maxCountMembers);
            list.add(teamConsultationRequestDTO);
        }
        resultSet.close();
        preparedStatement.close();
        return list;
    }
}