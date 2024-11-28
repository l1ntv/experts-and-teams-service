package ru.rsreu.lint.expertsandteams.Logic.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.CreateTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.LeaveTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;

import java.sql.SQLException;

public class CreateTeamLogic {

    public static boolean isTeamExistsByName(String teamName) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        CreateTeamDataDAO createTeamDataDAO = factory.getCreateTeamDataDAO();
        return createTeamDataDAO.isTeamExistsByName(teamName);
    }

    public static void createTeamInTeamsTable(int captainId, String teamName) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        CreateTeamDataDAO createTeamDataDAO = factory.getCreateTeamDataDAO();
        createTeamDataDAO.createTeamInTeamsTableByCaptainIdAndTeamName(captainId, teamName);
    }

    public static void createTeamInTeamMembersTable(int captainId, int teamId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        CreateTeamDataDAO createTeamDataDAO = factory.getCreateTeamDataDAO();
        createTeamDataDAO.createTeamInTeamMembersTableByCaptainIdAndTeamId(captainId, teamId);
    }

    public static int findTeamIdByTeamName(String name) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        CreateTeamDataDAO createTeamDataDAO = factory.getCreateTeamDataDAO();
        return createTeamDataDAO.findTeamIdByTeamName(name);
    }

    public static void updateTeamIdFromUserDataTableByUserId(int teamId, int userId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        CreateTeamDataDAO createTeamDataDAO = factory.getCreateTeamDataDAO();
        createTeamDataDAO.updateTeamIdFromUserDataTableByUserIdAndTeamId(teamId, userId);
    }

}
