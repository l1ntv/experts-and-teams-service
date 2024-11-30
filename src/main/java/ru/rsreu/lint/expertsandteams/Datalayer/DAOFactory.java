package ru.rsreu.lint.expertsandteams.Datalayer;

import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.*;

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
}
