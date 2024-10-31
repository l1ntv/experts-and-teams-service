package ru.rsreu.lint.expertsandteams.Logic.Administrator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.AuthUserDTO;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthUsersLogic {
    public static List<AuthUserDTO> getAuthUsersList() throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        ResultSet resultSet = administratorDataDAO.getAuthUsersList();
        List<AuthUserDTO> list = new ArrayList<>();
        list = AuthUsersLogic.convertResultSetToAuthUserDTOList(resultSet, list);
        return list;
    }

    private static List<AuthUserDTO> convertResultSetToAuthUserDTOList(ResultSet resultSet, List<AuthUserDTO> list) throws SQLException {
        while (resultSet.next()) {
            AuthUserDTO authUserDTO = new AuthUserDTO();
            authUserDTO.setLogin(resultSet.getString("LOGIN"));
            authUserDTO.setAccountType(AccountsTypesEnum.valueOf(resultSet.getString("ROLE_NAME").toUpperCase()));
            list.add(authUserDTO);
        }
        return list;
    }
}
