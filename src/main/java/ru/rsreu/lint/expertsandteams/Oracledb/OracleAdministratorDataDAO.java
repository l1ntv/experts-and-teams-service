package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.UserDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.TeamsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.ExpertsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Enums.AccountsStatusesEnum;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;
import ru.rsreu.lint.expertsandteams.Mapper.PasswordMapper;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleAdministratorDataDAO implements AdministratorDataDAO {
    private Connection connection;

    public OracleAdministratorDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void deleteUserFromQuestionAnswerTableByConsultationId(int consultationId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_FROM_QUESTION_ANSWER_BY_CONSULTATION_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), consultationId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void deleteUserFromConsultationRequestsTableByExpertId(int expertId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_FROM_CONSULTATION_REQUESTS_BY_EXPERT_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), expertId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void deleteUserFromConsultationRequestsTableByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_FROM_CONSULTATION_REQUESTS_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void deleteTeamFromTeamsTableByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_TEAM_FROM_TEAMS_TABLE_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public int findExpertIdByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.FIND_EXPERT_ID_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int result = -1;
        while (resultSet.next()) {
            result = resultSet.getInt("TEAM_ID");
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public void deleteTeamForOtherMembers(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_TEAM_FOR_OTHER_MEMBERS.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void decreaseCountTeamsForExpert(int expertId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DECREASE_COUNT_TEAMS_FOR_EXPERT.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), expertId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public int findConsultationIdByExpertId(int expertId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.FIND_CONSULTATION_ID_BY_EXPERT_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), expertId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int result = -1;
        while (resultSet.next()) {
            result = resultSet.getInt("CONSULTATION_ID");
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public List<UserDTO> getAuthUsersList() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueryManager.getProperty("AdministratorDataDAO.GET_AUTH_USERS_LIST"));
        List<UserDTO> list = new ArrayList<>();
        while (resultSet.next()) {
            String login = resultSet.getString("LOGIN");
            AccountsTypesEnum type = AccountsTypesEnum.valueOf(resultSet.getString("ROLE_NAME").toUpperCase());
            UserDTO authUserDTO = new UserDTO(login, type);
            list.add(authUserDTO);
        }
        resultSet.close();
        statement.close();
        return list;
    }

    @Override
    public List<TeamsStatisticsDTO> getTeamsStatisticsList() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueryManager.getProperty("AdministratorDataDAO.GET_TEAMS_STATISTICS_LIST"));
        List<TeamsStatisticsDTO> list = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("NAME");
            String captainLogin = resultSet.getString("LOGIN");
            int countMembers = resultSet.getInt("COUNT_MEMBERS");
            int maxCountMembers = resultSet.getInt("MAX_COUNT_MEMBERS");
            TeamsStatisticsDTO teamStatisticsDTO = new TeamsStatisticsDTO(name, captainLogin, countMembers, maxCountMembers);
            list.add(teamStatisticsDTO);
        }
        resultSet.close();
        statement.close();
        return list;
    }

    @Override
    public List<ExpertsStatisticsDTO> getExpertsStatisticsList() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueryManager.getProperty("AdministratorDataDAO.GET_EXPERTS_STATISTICS_LIST"));
        List<ExpertsStatisticsDTO> list = new ArrayList<>();
        while (resultSet.next()) {
            String login = resultSet.getString("LOGIN");
            int countTeams = resultSet.getInt("COUNT_TEAMS");
            int maxCountTeams = resultSet.getInt("MAX_COUNT_TEAMS");
            ExpertsStatisticsDTO expertsStatisticsDTO = new ExpertsStatisticsDTO(login, countTeams, maxCountTeams);
            list.add(expertsStatisticsDTO);
        }
        resultSet.close();
        statement.close();
        return list;
    }

    @Override
    public boolean isUserExistsByLogin(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.IS_USER_EXISTS_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean result = false;
        if (resultSet.next()) {
            result = resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public void createExpertById(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.CREATE_EXPERT_BY_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public boolean createUserByLogin(String login, int roleId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.CREATE_USER_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.SECOND_COLUMN_INDEX.SQL.CONST")), PasswordMapper.mapPassword(SQLQueryManager.getProperty("AdministratorDataDAO.ORIGINAL_PASSWORD.SQL.CONST")));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.THIRD_COLUMN_INDEX.SQL.CONST")), Integer.parseInt(SQLQueryManager.getProperty("AdministratorDataDAO.EMPTY_TEAM_ID.SQL.CONST")));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FOURTH_COLUMN_INDEX.SQL.CONST")), AccountsStatusesEnum.OFFLINE.getAccountStatusId());
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIFTH_COLUMN_INDEX.SQL.CONST")), roleId);
        boolean result = preparedStatement.execute();
        preparedStatement.close();
        return result;
    }

    @Override
    public ResultSet searchUserRoleByLogin(String login) throws SQLException { // Разделить на две функции
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.SEARCH_USER_ROLE_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public boolean isUserJoinedInTeamByUserId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.IS_USER_JOINED_IN_TEAM_BY_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean result = false;
        if (resultSet.next()) {
            result = resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    public int findUserIdByLogin(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.FIND_USER_ID_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        ResultSet resultSet = preparedStatement.executeQuery();
        int result = -1;
        while (resultSet.next()) {
            result = resultSet.getInt("USER_ID");
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public void deleteAdministratorUserByLogin(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_USER_FROM_USER_DATA_TABLE_BY_LOGIN.SQL.QUERY"));
        preparedStatement.setString(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), login);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void deleteExpertUserFromExpertsTableById(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_EXPERT_FROM_EXPERTS_TABLE_BY_EXPERT_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void deleteExpertUserFromConsultationsTableById(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_EXPERT_FROM_CONSULTATIONS_TABLE_BY_EXPERT_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void deleteExpertUserFromConsultationsTableByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_EXPERT_FROM_CONSULTATIONS_TABLE_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void deleteUserFromTeamMembersTableById(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.DELETE_USER_FROM_TEAM_MEMBERS_TABLE_BY_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public boolean isUserCaptainInTeamByUserId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.IS_USER_CAPTAIN_IN_TEAM_BY_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean result = false;
        if (resultSet.next()) {
            result = resultSet.getInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST"))) > Integer.parseInt(SQLQueryManager.getProperty("GENERAL.EMPTY_RESULT_SET.SQL.CONST"));
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public int findTeamIdByCaptainId(int captainId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.FIND_TEAM_ID_BY_CAPTAIN_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), captainId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int result = -1;
        while (resultSet.next()) {
            result = resultSet.getInt("TEAM_ID");
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public int findConsultationIdByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("AdministratorDataDAO.FIND_CONSULTATION_ID_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int result = -1;
        while (resultSet.next()) {
            result = resultSet.getInt("CONSULTATION_ID");
        }
        resultSet.close();
        preparedStatement.close();
        return result;
    }

}
