package ru.rsreu.lint.expertsandteams.Logic.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.User.JoinTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;

import java.sql.SQLException;

public class JoinTeamLogic {
    public static int findTeamIdByTeamName(String teamName) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        JoinTeamDataDAO joinTeamDataDAO = factory.getJoinTeamDataDAO();
        return joinTeamDataDAO.findTeamIdByTeamName(teamName);
    }

    public static boolean isUserJoinedInTeamByUserId(int id) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        JoinTeamDataDAO joinTeamDataDAO = factory.getJoinTeamDataDAO();
        return joinTeamDataDAO.isUserJoinedInTeamByUserId(id);
    }

    public static void changeTeamIdInUserDataTableByUserId(int teamId, int userId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        JoinTeamDataDAO joinTeamDataDAO = factory.getJoinTeamDataDAO();
        joinTeamDataDAO.changeTeamIdInUserDataTableByUserId(teamId, userId);
    }

    public static void addNewMemberInTeamMembersTable(int userId, int teamId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        JoinTeamDataDAO joinTeamDataDAO = factory.getJoinTeamDataDAO();
        joinTeamDataDAO.addNewMemberInTeamMembersTable(userId, teamId);
    }

    public static void increaseCountMembersInTeamTableByTeamId(int teamId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        JoinTeamDataDAO joinTeamDataDAO = factory.getJoinTeamDataDAO();
        joinTeamDataDAO.updateCountMembersInTeamsTableByTeamId(teamId);
    }
}