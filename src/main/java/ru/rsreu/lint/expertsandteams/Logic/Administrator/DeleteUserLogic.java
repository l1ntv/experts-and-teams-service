package ru.rsreu.lint.expertsandteams.Logic.Administrator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class DeleteUserLogic {
    public static boolean isUserExistsByLogin(String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        return administratorDataDAO.isUserExistsByLogin(login);
    }

    public static boolean deleteUserByLogin(HttpServletRequest request, String login) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        HttpSession session = request.getSession(false);
        int groupTypeId = (int) session.getAttribute("groupTypeId");
        if (groupTypeId == 0) {
            boolean isCaptain = (boolean) session.getAttribute("isCaptain");
            boolean isJoinedInTeam = administratorDataDAO.isUserJoinedInTeamByLogin(login);
            if (!isJoinedInTeam) {

            } else {

            }
        }
        return true;
        // если пользователь просто юзер => проверить состоит ли в команде
        // если не состоит, то просто удалить из user_data
        // если состоит в команде => проверить является ли он капитаном
            // если не капитан, то удалить его из teams_members
            // если капитан, то проверить если ли кто-то еще в команде
                // если в команде кто-то есть, то передать права капитана другому участнику команды
                // если в команде никого нет, то удалить полностью команду (в том числе и консультации, если они есть)
    }
}
