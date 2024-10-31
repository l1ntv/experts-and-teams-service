package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AdministratorDataDAO {
    ResultSet getAuthUsersList() throws SQLException;
    ResultSet getTeamsStatisticsList() throws SQLException;
    ResultSet getExpertsStatisticsList() throws SQLException;
}
