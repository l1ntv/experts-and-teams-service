package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Administrator;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.UserDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.TeamsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.ExpertsStatisticsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface AdministratorDataDAO {
    int findConsultationIdByExpertId(int expertId) throws SQLException;

    List<UserDTO> getAuthUsersList() throws SQLException;

    List<TeamsStatisticsDTO> getTeamsStatisticsList() throws SQLException;

    List<ExpertsStatisticsDTO> getExpertsStatisticsList() throws SQLException;

    boolean isUserExistsByLogin(String login) throws SQLException;

    boolean createUserByLogin(String login, int roleId) throws SQLException;

    void createExpertById(int id) throws SQLException;

    ResultSet searchUserRoleByLogin(String login) throws SQLException;

    boolean isUserJoinedInTeamByUserId(int id) throws SQLException;

    int findUserIdByLogin(String login) throws SQLException;

    void deleteAdministratorUserByLogin(String login) throws SQLException;

    void deleteExpertUserFromExpertsTableById(int id) throws SQLException;

    void deleteExpertUserFromConsultationsTableById(int id) throws SQLException;

    void deleteExpertUserFromConsultationsTableByTeamId(int teamId) throws SQLException;

    void deleteUserFromTeamMembersTableById(int id) throws SQLException;

    void deleteUserFromQuestionAnswerTableByConsultationId(int consultationId) throws SQLException;

    void deleteUserFromConsultationRequestsTableByExpertId(int expertId) throws SQLException;

    void deleteUserFromConsultationRequestsTableByTeamId(int teamId) throws SQLException;

    void deleteTeamFromTeamsTableByTeamId(int teamId) throws SQLException;

    int findExpertIdByTeamId(int teamId) throws SQLException;

    void decreaseCountTeamsForExpert(int expertId) throws SQLException;

    void deleteTeamForOtherMembers(int teamId) throws SQLException;

    boolean isUserCaptainInTeamByUserId(int id) throws SQLException;

    int findTeamIdByCaptainId(int captainId) throws SQLException;

    int findConsultationIdByTeamId(int teamId) throws SQLException;
}
