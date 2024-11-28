package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.MyTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            countMember = resultSet.getInt("COUNT_MEMBERS");
        }
        return countMember;
    }

    @Override
    public int findMaxCountMembersByTeamId(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("MyTeamDataDAO.FIND_MAX_COUNT_MEMBERS_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), id);
        ResultSet resultSet = preparedStatement.executeQuery();
        int countMember = 0;
        while (resultSet.next()) {
            countMember = resultSet.getInt("MAX_COUNT_MEMBERS");
        }
        return countMember;
    }

    @Override
    public ResultSet findTeamMemberDTOListByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("MyTeamDataDAO.GET_TEAM_MEMBER_DTO_LIST_BY_TEAM_ID.SQL.QUERY"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
}
