package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.UserDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.TeamsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.ExpertsStatisticsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface AdministratorDataDAO {
    List<UserDTO> getAuthUsersList() throws SQLException;
    List<TeamsStatisticsDTO> getTeamsStatisticsList() throws SQLException;
    List<ExpertsStatisticsDTO> getExpertsStatisticsList() throws SQLException;
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
