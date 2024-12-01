package ru.rsreu.lint.expertsandteams.Oracledb.Moderator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Moderator.BannedUsersDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.UserDTO;
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
            String login = resultSet.getString(SQLQueryManager.getProperty("GENERAL.LOGIN.SQL.CONST"));
            AccountsTypesEnum type = AccountsTypesEnum.valueOf(resultSet.getString(SQLQueryManager.getProperty("GENERAL.ROLE_NAME.SQL.CONST")).toUpperCase());
            UserDTO authUserDTO = new UserDTO(login, type);
            list.add(authUserDTO);
        }
        resultSet.close();
        statement.close();
        return list;
    }
}