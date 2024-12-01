package ru.rsreu.lint.expertsandteams.Logic.Common;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Common.UserDataDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Common.RegistrationDataDAO;
import ru.rsreu.lint.expertsandteams.Mapper.PasswordMapper;

import java.sql.SQLException;

public class RegistrationLogic {
    public static boolean isExistsUserData(String login, String password) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        RegistrationDataDAO registrationDataDAO = factory.getRegistrationDataDAO();
        return (registrationDataDAO.exists(new UserDataDTO(login, PasswordMapper.mapPassword(password))));
    }

    public static void createUser(String login, String password) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        RegistrationDataDAO registrationDataDAO = factory.getRegistrationDataDAO();
        registrationDataDAO.createUser(new UserDataDTO(login, PasswordMapper.mapPassword(password)));
    }

    public static int getUserIdByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        RegistrationDataDAO registrationDataDAO = factory.getRegistrationDataDAO();
        return (registrationDataDAO.getUserIdByLogin(login));
    }
}