package ru.rsreu.lint.expertsandteams.Datalayer;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AuthenticationDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.LogoutDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.RegistrationDataDAO;

public abstract class DAOFactory {
	public static DAOFactory getInstance(DBType dbType) {
		DAOFactory result = dbType.getDAOFactory();
		return result;
	}

	public abstract AuthenticationDataDAO getAuthenticationDataDAO();
	public abstract LogoutDataDAO getLogoutDataDAO();
	public abstract RegistrationDataDAO getRegistrationDataDAO();

}
