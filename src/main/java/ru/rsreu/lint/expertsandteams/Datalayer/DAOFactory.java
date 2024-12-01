package ru.rsreu.lint.expertsandteams.Datalayer;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Administrator.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common.AuthenticationDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common.LogoutDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common.RegistrationDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert.AcceptTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert.AnswerToQuestionDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert.CancelConsultationDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert.ConsultationsRequestsDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator.BanUserDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator.BannedUsersDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator.MessagesUsersDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator.UnbanUserDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.User.*;

public abstract class DAOFactory {
    public static DAOFactory getInstance(DBType dbType) {
        DAOFactory result = dbType.getDAOFactory();
        return result;
    }

    public abstract AuthenticationDataDAO getAuthenticationDataDAO();

    public abstract LogoutDataDAO getLogoutDataDAO();

    public abstract RegistrationDataDAO getRegistrationDataDAO();

    public abstract MainDataDAO getMainDataDAO();

    public abstract AdministratorDataDAO getAdministratorDataDAO();

    public abstract MyTeamDataDAO getMyTeamDataDAO();

    public abstract CreateTeamDataDAO getCreateTeamDataDAO();

    public abstract LeaveTeamDataDAO getLeaveTeamDataDAO();

    public abstract JoinTeamDataDAO getJoinTeamDataDAO();

    public abstract ConsultationsDataDAO getConsultationsDataDAO();

    public abstract RequestConsultationDataDAO getRequestConsultationDataDAO();

    public abstract ConsultationsRequestsDataDAO getConsultationsRequestsDataDAO();

    public abstract AcceptTeamDataDAO getAcceptTeamDataDAO();

    public abstract CancelConsultationDataDAO getCancelConsultationDataDAO();

    public abstract AskQuestionTeamDataDAO getAskQuestionTeamDataDAO();

    public abstract AnswerToQuestionDataDAO getAnswerToQuestionDataDAO();

    public abstract BannedUsersDataDAO getBannedUsersDataDAO();

    public abstract MessagesUsersDataDAO getMessagesUsersDataDAO();

    public abstract BanUserDataDAO getBanUserDataDAO();

    public abstract UnbanUserDataDAO getUnbanUserDataDAO();
}
