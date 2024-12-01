package ru.rsreu.lint.expertsandteams.Oracledb.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.User.MyTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.User.TeamMemberDTO;
import ru.rsreu.lint.expertsandteams.Enums.TeamRoleEnum;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleMyTeamDataDAO implements MyTeamDataDAO {
    private Connection connection;

    public OracleMyTeamDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int findCountMembersByTeamId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("MyTeamDataDAO.FIND_COUNT_MEMBERS_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        ResultSet resultSet = preparedStatement.executeQuery();
        int countMember = 0;
        while (resultSet.next()) {
            countMember = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.COUNT_MEMBERS.SQL.CONST"));
        }
        resultSet.close();
        preparedStatement.close();
        return countMember;
    }

    @Override
    public int findMaxCountMembersByTeamId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("MyTeamDataDAO.FIND_MAX_COUNT_MEMBERS_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        ResultSet resultSet = preparedStatement.executeQuery();
        int countMember = 0;
        while (resultSet.next()) {
            countMember = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.NAX_COUNT_MEMBERS.SQL.CONST"));
        }
        resultSet.close();
        preparedStatement.close();
        return countMember;
    }

    @Override
    public List<TeamMemberDTO> findTeamMemberDTOListByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("MyTeamDataDAO.GET_TEAM_MEMBER_DTO_LIST_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<TeamMemberDTO> list = new ArrayList<>();
        while (resultSet.next()) {
            String login = resultSet.getString(SQLQueryManager.getProperty("GENERAL.LOGIN.SQL.CONST"));
            boolean isOnline = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.STATUS_ID.SQL.CONST")) == 0 ? false : true;
            TeamRoleEnum role = resultSet.getInt(SQLQueryManager.getProperty("GENERAL.TEAM_ROLE_ID.SQL.CONST")) == 0 ? TeamRoleEnum.MEMBER : TeamRoleEnum.CAPTAIN;
            TeamMemberDTO teamMemberDTO = new TeamMemberDTO(login, isOnline, role);
            list.add(teamMemberDTO);
        }
        resultSet.close();
        preparedStatement.close();
        return list;
    }
}