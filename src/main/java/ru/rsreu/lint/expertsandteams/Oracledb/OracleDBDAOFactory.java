package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.*;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Administrator.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common.AuthenticationDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common.LogoutDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common.RegistrationDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common.SessionFilterDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert.AcceptTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert.AnswerToQuestionDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert.CancelConsultationDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert.ConsultationsRequestsDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator.BanUserDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator.BannedUsersDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator.MessagesUsersDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator.UnbanUserDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.User.*;
import ru.rsreu.lint.expertsandteams.Oracledb.Administrator.OracleAdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Oracledb.Common.OracleAuthenticationDataDAO;
import ru.rsreu.lint.expertsandteams.Oracledb.Common.OracleLogoutDataDAO;
import ru.rsreu.lint.expertsandteams.Oracledb.Common.OracleRegistrationDataDAO;
import ru.rsreu.lint.expertsandteams.Oracledb.Common.OracleSessionFilterDataDAO;
import ru.rsreu.lint.expertsandteams.Oracledb.Expert.OracleAcceptTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Oracledb.Expert.OracleAnswerToQuestionDataDAO;
import ru.rsreu.lint.expertsandteams.Oracledb.Expert.OracleCancelConsultationDataDAO;
import ru.rsreu.lint.expertsandteams.Oracledb.Expert.OracleConsultationsRequestsDataDAO;
import ru.rsreu.lint.expertsandteams.Oracledb.Moderator.OracleBanUserDataDAO;
import ru.rsreu.lint.expertsandteams.Oracledb.Moderator.OracleBannedUsersDataDAO;
import ru.rsreu.lint.expertsandteams.Oracledb.Moderator.OracleMessagesUsersDataDAO;
import ru.rsreu.lint.expertsandteams.Oracledb.Moderator.OracleUnbanUserDataDAO;
import ru.rsreu.lint.expertsandteams.Oracledb.User.*;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class OracleDBDAOFactory extends DAOFactory {
    private static volatile OracleDBDAOFactory instance;
    private Connection connection;

    private OracleDBDAOFactory() {
    }

    public static OracleDBDAOFactory getInstance() throws ClassNotFoundException, SQLException {
        OracleDBDAOFactory factory = instance;
        if (instance == null) {
            synchronized (OracleDBDAOFactory.class) {
                instance = factory = new OracleDBDAOFactory();
                factory.connected();
            }
        }
        return factory;
    }

    private void connected() throws ClassNotFoundException, SQLException {
        Locale.setDefault(Locale.ENGLISH);
        String url = SQLQueryManager.getProperty("ORACLE.SQL.URL");
        String username = SQLQueryManager.getProperty("ORACLE.SQL.USERNAME");
        String password = SQLQueryManager.getProperty("ORACLE.SQL.PASSWORD");
        connection = DriverManager.getConnection(url, username, password);
    }

    @Override
    public AuthenticationDataDAO getAuthenticationDataDAO() {
        return new OracleAuthenticationDataDAO(connection);
    }

    @Override
    public LogoutDataDAO getLogoutDataDAO() {
        return new OracleLogoutDataDAO(connection);
    }

    @Override
    public RegistrationDataDAO getRegistrationDataDAO() {
        return new OracleRegistrationDataDAO(connection);
    }

    @Override
    public MainDataDAO getMainDataDAO() {
        return new OracleMainDataDAO(connection);
    }

    @Override
    public AdministratorDataDAO getAdministratorDataDAO() {
        return new OracleAdministratorDataDAO(connection);
    }

    @Override
    public MyTeamDataDAO getMyTeamDataDAO() {
        return new OracleMyTeamDataDAO(connection);
    }

    @Override
    public CreateTeamDataDAO getCreateTeamDataDAO() {
        return new OracleCreateTeamDataDAO(connection);
    }

    @Override
    public LeaveTeamDataDAO getLeaveTeamDataDAO() {
        return new OracleLeaveTeamDataDAO(connection);
    }

    @Override
    public JoinTeamDataDAO getJoinTeamDataDAO() {
        return new OracleJoinTeamDataDAO(connection);
    }

    @Override
    public ConsultationsDataDAO getConsultationsDataDAO() {
        return new OracleConsultationsDataDAO(connection);
    }

    @Override
    public RequestConsultationDataDAO getRequestConsultationDataDAO() {
        return new OracleRequestConsultationDataDAO(connection);
    }

    @Override
    public ConsultationsRequestsDataDAO getConsultationsRequestsDataDAO() {
        return new OracleConsultationsRequestsDataDAO(connection);
    }

    @Override
    public AcceptTeamDataDAO getAcceptTeamDataDAO() {
        return new OracleAcceptTeamDataDAO(connection);
    }

    @Override
    public CancelConsultationDataDAO getCancelConsultationDataDAO() {
        return new OracleCancelConsultationDataDAO(connection);
    }

    @Override
    public AskQuestionTeamDataDAO getAskQuestionTeamDataDAO() {
        return new OracleAskQuestionTeamDataDAO(connection);
    }

    @Override
    public AnswerToQuestionDataDAO getAnswerToQuestionDataDAO() {
        return new OracleAnswerToQuestionDataDAO(connection);
    }

    @Override
    public BannedUsersDataDAO getBannedUsersDataDAO() {
        return new OracleBannedUsersDataDAO(connection);
    }

    @Override
    public MessagesUsersDataDAO getMessagesUsersDataDAO() {
        return new OracleMessagesUsersDataDAO(connection);
    }

    @Override
    public BanUserDataDAO getBanUserDataDAO() {
        return new OracleBanUserDataDAO(connection);
    }

    @Override
    public UnbanUserDataDAO getUnbanUserDataDAO() {
        return new OracleUnbanUserDataDAO(connection);
    }

    @Override
    public SessionFilterDataDAO getSessionFilterDataDAO() {
        return new OracleSessionFilterDataDAO(connection);
    }
}