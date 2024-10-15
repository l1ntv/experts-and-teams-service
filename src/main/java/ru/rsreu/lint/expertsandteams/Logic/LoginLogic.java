package ru.rsreu.lint.expertsandteams.Logic;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.UserDataDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AuthenticationDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Mapper.PasswordMapper;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import java.sql.SQLException;

public class LoginLogic {

    public static boolean isCorrectUserData(String login, String password) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AuthenticationDataDAO authenticationDataDAO = factory.getAuthenticationDataDAO();
        return (authenticationDataDAO.isCorrectUserDataByLoginAndPassword(new UserDataDTO(login, PasswordMapper.mapPassword(password))));
    }

    public static boolean isCaptainByUserId(int userId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AuthenticationDataDAO authenticationDataDAO = factory.getAuthenticationDataDAO();
        return (authenticationDataDAO.isUserCaptainByUserId(userId));
    }

    public static int getUserIdByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AuthenticationDataDAO authenticationDataDAO = factory.getAuthenticationDataDAO();
        return (authenticationDataDAO.getUserIdByLogin(login));
    }

    public static int getUserGroupTypeIdByUserId(int userId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AuthenticationDataDAO authenticationDataDAO = factory.getAuthenticationDataDAO();
        return (authenticationDataDAO.getUserGroupTypeIdByUserId(userId));
    }

    public static void setOnlineStatusByUserId(int userId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AuthenticationDataDAO authenticationDataDAO = factory.getAuthenticationDataDAO();
        authenticationDataDAO.setOnlineStatusByUserId(userId);
    }

    public static String defineCorrectJspPageByGroupTypeId(int groupTypeId) {
        String jsp = new String();
        switch (groupTypeId) {
            case 0:
                jsp = ConfigurationManager.getProperty("USER.MAIN.PAGE");
                break;
            case 1:
                jsp = ConfigurationManager.getProperty("EXPERT.MAIN.PAGE");
                break;
            case 2:
                jsp = ConfigurationManager.getProperty("MODERATOR.MAIN.PAGE");
                break;
            case 3:
                jsp = ConfigurationManager.getProperty("ADMINISTRATION.MAIN.PAGE");
                break;
            default:
                // TO DO error handle
        }
        return jsp;
    }
}
