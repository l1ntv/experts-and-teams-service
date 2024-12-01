package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.*;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.*;

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
        String url = "jdbc:oracle:thin:@localhost:1521/xepdb1?useUnicode=true&characterEncoding=utf8";
        String username = "lint";
        String password = "16042004";
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
    public BanUserDataDAO getBanUserDataDAO() { return new OracleBanUserDataDAO(connection); }

    @Override
    public UnbanUserDataDAO getUnbanUserDataDAO() {return new OracleUnbanUserDataDAO(connection); }
}
