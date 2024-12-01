package ru.rsreu.lint.expertsandteams.Command.Commands.Administrator;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.SearchedUserDTO;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Administrator.SearchUserLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class SearchUserByAdminCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request) throws SQLException {
        String login = request.getParameter(ConfigurationManager.getProperty("LOGIN.PROPERTY.CONST"));
        SearchedUserDTO searchedUserDTO = SearchUserLogic.searchUserDTOByLogin(login);
        request.setAttribute(ConfigurationManager.getProperty("SEARCHED_USER.CONST"), searchedUserDTO);
        return new Page(ConfigurationManager.getProperty("ADMINISTRATOR.MAIN.PAGE"), ConfigurationManager.getProperty("MAIN.URL"), DirectTypesEnum.FORWARD, CommandEnum.MAIN);
    }
}