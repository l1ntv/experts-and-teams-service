package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.SearchedUserDTO;
import ru.rsreu.lint.expertsandteams.Enums.AccountsTypesEnum;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AdministratorDataDAO {
    ResultSet getAuthUsersList() throws SQLException;
    ResultSet getTeamsStatisticsList() throws SQLException;
    ResultSet getExpertsStatisticsList() throws SQLException;
    boolean isUserExistsByLogin(String login) throws SQLException;
    boolean createUserByLogin(String login) throws SQLException;
    ResultSet searchUserRoleByLogin(String login) throws SQLException;
    boolean isUserJoinedInTeamByUserId(int id) throws SQLException;
    int findUserIdByLogin(String login) throws SQLException;
    void deleteAdministratorUserByLogin(String login) throws SQLException;
    void deleteExpertUserFromExpertsTableById(int id) throws SQLException;
    void deleteExpertUserFromConsultationsTableById(int id) throws SQLException;
    void deleteUserFromTeamMembersTableById(int id) throws SQLException;
    boolean isUserCaptainInTeamByUserId(int id) throws SQLException;

}
