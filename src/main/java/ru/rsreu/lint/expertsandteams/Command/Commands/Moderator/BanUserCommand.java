package ru.rsreu.lint.expertsandteams.Command.Commands.Moderator;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.SearchedUserDTO;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;
import ru.rsreu.lint.expertsandteams.Enums.CommandEnum;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Logic.Administrator.SearchUserLogic;
import ru.rsreu.lint.expertsandteams.Logic.Moderator.BanUserLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class BanUserCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request) throws SQLException, UnsupportedEncodingException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) != null) {
            String login = request.getParameter(ConfigurationManager.getProperty("LOGIN.PROPERTY.CONST"));
            SearchedUserDTO searchedUserDTO = SearchUserLogic.searchUserDTOByLogin(login);
            boolean isUserBanned = false;
            if (searchedUserDTO.getAccountType().equals(AccountsTypesEnum.USER)) {
                isUserBanned = true;
                BanUserLogic.banUserByLogin(login);
            }
            request.setAttribute(ConfigurationManager.getProperty("SEARCHED_USER.CONST"), searchedUserDTO);
            request.setAttribute(ConfigurationManager.getProperty("IS_USER_BANNED_FLAG.CONST"), isUserBanned);
            return new Page(ConfigurationManager.getProperty("MODERATOR.BANNED.USERS.PAGE"), ConfigurationManager.getProperty("MODERATOR.BANNED.USERS.URL"), DirectTypesEnum.FORWARD, CommandEnum.BANNED_USERS);
        }
        return new Page(ConfigurationManager.getProperty("AUTHENTICATION.PAGE"), ConfigurationManager.getProperty("AUTHENTICATION.URL"), DirectTypesEnum.REDIRECT, CommandEnum.REDIRECT_TO_LOGIN);
    }
}
