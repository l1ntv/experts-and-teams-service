package ru.rsreu.lint.expertsandteams.Logic.Administrator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteUserLogic {
    public static boolean isUserExistsByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        return administratorDataDAO.isUserExistsByLogin(login);
    }

    public static AccountsTypesEnum searchDeletedUserRoleByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        ResultSet resultSet = administratorDataDAO.searchUserRoleByLogin(login);
        return DeleteUserLogic.convertResultSetToAccountType(resultSet);
    }

    public static void deleteUserFromUserDataByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        administratorDataDAO.deleteAdministratorUserByLogin(login);
    }

    public static void deleteUserFromTeamMembersByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        int id = administratorDataDAO.findUserIdByLogin(login);
        administratorDataDAO.deleteUserFromTeamMembersTableById(id);
    }

    public static void deleteExpertDataByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        int expertId = administratorDataDAO.findUserIdByLogin(login);
        administratorDataDAO.deleteExpertUserFromConsultationsTableById(expertId);
        administratorDataDAO.deleteExpertUserFromExpertsTableById(expertId);
    }

    public static boolean isUserJoinedInTeamByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        int id = administratorDataDAO.findUserIdByLogin(login);
        return administratorDataDAO.isUserJoinedInTeamByUserId(id);
    }

    public static boolean isUserCaptainInTeamByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        int id = administratorDataDAO.findUserIdByLogin(login);
        return administratorDataDAO.isUserCaptainInTeamByUserId(id);
    }

    private static AccountsTypesEnum convertResultSetToAccountType(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) { // Перемещаем курсор на первую строку
            return AccountsTypesEnum.valueOf(resultSet.getString("ROLE_NAME").toUpperCase());
        } else {
            throw new SQLException("ResultSet is empty");
        }
    }

}
