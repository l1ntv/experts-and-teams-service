package ru.rsreu.lint.expertsandteams.Logic.Administrator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.UserDTO;

import java.sql.SQLException;
import java.util.List;

public class AuthUsersLogic {
    public static List<UserDTO> getAuthUsersList() throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        List<UserDTO> list = administratorDataDAO.getAuthUsersList();
        return list;
    }
}
