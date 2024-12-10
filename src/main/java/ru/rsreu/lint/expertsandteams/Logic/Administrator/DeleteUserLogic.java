package ru.rsreu.lint.expertsandteams.Logic.Administrator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Administrator.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteUserLogic {
    public static void decreaseCountMembers(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        int userId = administratorDataDAO.findUserIdByLogin(login);
        int teamId = administratorDataDAO.findTeamIdByUserId(userId);
        administratorDataDAO.decreaseCountMembers(teamId);
    }
    public static void decreaseTeamCountsForExpert(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        int userId = administratorDataDAO.findUserIdByLogin(login);
        int teamId = administratorDataDAO.findTeamIdByCaptainId(userId);
        int expertId = administratorDataDAO.findExpertIdByTeamId(teamId);
        administratorDataDAO.decreaseCountTeamsForExpert(expertId);
    }

    public static void deleteTeamForOtherMembers(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        int userId = administratorDataDAO.findUserIdByLogin(login);
        int teamId = administratorDataDAO.findTeamIdByCaptainId(userId);
        administratorDataDAO.deleteTeamForOtherMembers(teamId);
    }

    public static int findConsultationIdByExpertId(int expertId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        return administratorDataDAO.findConsultationIdByExpertId(expertId);
    }

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
        int consultationId = DeleteUserLogic.findConsultationIdByExpertId(expertId);
        administratorDataDAO.deleteExpertUserFromConsultationsTableById(expertId);
        administratorDataDAO.deleteExpertUserFromExpertsTableById(expertId);
        administratorDataDAO.deleteUserFromQuestionAnswerTableByConsultationId(consultationId);
        administratorDataDAO.deleteUserFromConsultationRequestsTableByExpertId(expertId);
    }

    public static void deleteCaptainDataByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        int userId = administratorDataDAO.findUserIdByLogin(login);
        int teamId = administratorDataDAO.findTeamIdByCaptainId(userId);
        int consultationId = administratorDataDAO.findConsultationIdByTeamId(teamId);
        administratorDataDAO.deleteUserFromQuestionAnswerTableByConsultationId(consultationId);
        administratorDataDAO.deleteExpertUserFromConsultationsTableByTeamId(teamId);
        administratorDataDAO.deleteUserFromConsultationRequestsTableByTeamId(teamId);
        administratorDataDAO.deleteTeamFromTeamsTableByTeamId(teamId);
        administratorDataDAO.deleteConsultationByTeamId(teamId);
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
        if (resultSet.next()) {
            return AccountsTypesEnum.valueOf(resultSet.getString(ConfigurationManager.getProperty("ROLE_NAME.CONST")).toUpperCase());
        } else {
            throw new SQLException(ConfigurationManager.getProperty("RESULTSET_IS_EMPTY.CONST"));
        }
    }
}