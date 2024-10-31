package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AdministratorDataDAO {
    ResultSet getAuthUsersList() throws SQLException;
}
