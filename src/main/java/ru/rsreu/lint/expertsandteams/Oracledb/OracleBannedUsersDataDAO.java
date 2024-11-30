package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.BannedUsersDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.UserDTO;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;
import ru.rsreu.lint.expertsandteams.Resource.SQLQueryManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleBannedUsersDataDAO implements BannedUsersDataDAO {
    private Connection connection;

    public OracleBannedUsersDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<UserDTO> getBannedUsersList() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueryManager.getProperty("BannedUsersDataDAO.GET_BANNED_USERS_LIST.SQL.QUERY"));
        List<UserDTO> list = new ArrayList<>();
        while (resultSet.next()) {
            String login = resultSet.getString("LOGIN");
            AccountsTypesEnum type = AccountsTypesEnum.valueOf(resultSet.getString("ROLE_NAME").toUpperCase());
            UserDTO authUserDTO = new UserDTO(login, type);
            list.add(authUserDTO);
        }
        resultSet.close();
        statement.close();
        return list;
    }
}
