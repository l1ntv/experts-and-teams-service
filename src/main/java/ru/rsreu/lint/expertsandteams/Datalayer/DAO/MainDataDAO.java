package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MainDataDAO {
    ResultSet getListTeams() throws SQLException;
    String getCaptainLoginByCaptainId(int captainId) throws SQLException;
    String getExpertLoginByTeamId(int teamId) throws SQLException;
}
