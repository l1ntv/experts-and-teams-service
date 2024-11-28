package ru.rsreu.lint.expertsandteams.Logic.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.LeaveTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;

import java.sql.SQLException;

public class LeaveTeamLogic {
    public static boolean isUserCaptainByUserId(int id) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        LeaveTeamDataDAO leaveTeamDataDAO = factory.getLeaveTeamDataDAO();
        return leaveTeamDataDAO.isUserCaptainByUserId(id);
    }

    public static void deleteUserFromTeamMembersTableByUserId(int id) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        LeaveTeamDataDAO leaveTeamDataDAO = factory.getLeaveTeamDataDAO();
        leaveTeamDataDAO.deleteUserFromTeamMembersTableByUserId(id);
    }

    public static int findTeamIdByUserId(int userId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        LeaveTeamDataDAO leaveTeamDataDAO = factory.getLeaveTeamDataDAO();
        return leaveTeamDataDAO.findTeamIdByUserId(userId);
    }

    public static void decreaseCountMembersFromTeamsTableByTeamId(int teamId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        LeaveTeamDataDAO leaveTeamDataDAO = factory.getLeaveTeamDataDAO();
        leaveTeamDataDAO.decreaseCountMembersFromTeamsTableByTeamId(teamId);
    }

    public static void updateTeamIdFromUserDataTableByUserId(int userId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        LeaveTeamDataDAO leaveTeamDataDAO = factory.getLeaveTeamDataDAO();
        leaveTeamDataDAO.updateTeamIdFromUserDataTableByUserId(userId);
    }
}
