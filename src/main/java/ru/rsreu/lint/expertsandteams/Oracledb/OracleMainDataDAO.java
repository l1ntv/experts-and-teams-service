package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.MainDataDAO;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.*;

public class OracleMainDataDAO implements MainDataDAO {

    private Connection connection;

    public OracleMainDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ResultSet getListTeams() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueryManager.getProperty("MainDataDAO.GET_LIST_TEAM"));
        return resultSet;
    }

    @Override
    public String getCaptainLoginByCaptainId(int captainId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("MainDataDAO.FIND_CAPTAIN_LOGIN_BY_CAPTAIN_ID"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), captainId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("LOGIN");
        }
        return "None";
    }

    @Override
    public String getExpertLoginByTeamId(int teamId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryManager.getProperty("MainDataDAO.FIND_EXPERT_LOGIN_BY_TEAM_ID"));
        preparedStatement.setInt(Integer.parseInt(SQLQueryManager.getProperty("GENERAL.FIRST_COLUMN_INDEX.SQL.CONST")), teamId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("LOGIN");
        }
        return "None";
    }

}
