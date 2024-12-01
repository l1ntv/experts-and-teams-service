package ru.rsreu.lint.expertsandteams.Logic.Administrator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Administrator.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.SearchedUserDTO;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchUserLogic {
    public static SearchedUserDTO searchUserDTOByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        ResultSet resultSet = administratorDataDAO.searchUserRoleByLogin(login);
        return SearchUserLogic.convertResultSetToUserSearchedDTO(login, resultSet);
    }

    private static SearchedUserDTO convertResultSetToUserSearchedDTO(String login, ResultSet resultSet) throws SQLException {
        SearchedUserDTO searchedUserDTO = new SearchedUserDTO();
        while (resultSet.next()) {
            searchedUserDTO.setLogin(login);
            searchedUserDTO.setAccountType(AccountsTypesEnum.valueOf(resultSet.getString(ConfigurationManager.getProperty("ROLE_NAME.CONST")).toUpperCase()));
        }
        return searchedUserDTO;
    }
}