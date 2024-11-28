package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MyTeamDataDAO {
    int findCountMembersByTeamId(int teamId) throws SQLException;
    int findMaxCountMembersByTeamId(int teamId) throws SQLException;
    ResultSet findTeamMemberDTOListByTeamId(int teamId) throws SQLException;
}
