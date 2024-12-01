package ru.rsreu.lint.expertsandteams.Logic.Moderator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator.BannedUsersDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.UserDTO;

import java.sql.SQLException;
import java.util.List;

public class BannedUsersLogic {

    public static List<UserDTO> getBannedUsersList() throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        BannedUsersDataDAO bannedUsersDataDAO = factory.getBannedUsersDataDAO();
        return bannedUsersDataDAO.getBannedUsersList();
    }
}
