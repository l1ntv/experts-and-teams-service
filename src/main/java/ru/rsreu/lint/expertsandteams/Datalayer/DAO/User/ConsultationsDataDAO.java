package ru.rsreu.lint.expertsandteams.Datalayer.DAO.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.ExpertsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.User.QuestionAnswerDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * The ConsultationsDataDAO interface provides methods for managing and retrieving
 * data related to consultations, user participation in teams, and expert statistics.
 */
public interface ConsultationsDataDAO {

    /**
     * Checks if a user is a member of a team based on their user ID.
     *
     * @param id The ID of the user to check.
     * @return true if the user is joined in a team; false otherwise.
     * @throws SQLException If a database access error occurs while checking the user's team membership.
     */
    boolean isUserJoinedInTeamByUserId(int id) throws SQLException;

    /**
     * Checks if a user is the captain of a team based on their user ID.
     *
     * @param id The ID of the user to check.
     * @return true if the user is a captain; false otherwise.
     * @throws SQLException If a database access error occurs while checking the user's captain status.
     */
    boolean isUserCaptainByUserId(int id) throws SQLException;

    /**
     * Finds the team ID associated with a given user ID.
     *
     * @param userId The ID of the user for whom to find the team ID.
     * @return The ID of the team associated with the specified user ID.
     * @throws SQLException If a database access error occurs while retrieving the team ID.
     */
    int findTeamIdByUserId(int userId) throws SQLException;

    /**
     * Checks if a team has at least one expert based on the team ID.
     *
     * @param teamId The ID of the team to check.
     * @return true if the team has at least one expert; false otherwise.
     * @throws SQLException If a database access error occurs while checking for experts in the team.
     */
    boolean isTeamHasExpertByTeamId(int teamId) throws SQLException;

    /**
     * Finds expert statistics for a specific team based on the team ID.
     *
     * @param teamId The ID of the team for which to retrieve expert statistics.
     * @return An ExpertsStatisticsDTO object containing statistics for the specified team.
     * @throws SQLException If a database access error occurs while retrieving expert statistics.
     */
    ExpertsStatisticsDTO findTeamExpertByTeamId(int teamId) throws SQLException;

    /**
     * Retrieves a list of available experts.
     *
     * @return A list of ExpertsStatisticsDTO objects representing available experts.
     * @throws SQLException If a database access error occurs while retrieving the list of experts.
     */
    List<ExpertsStatisticsDTO> findListAvailableExperts() throws SQLException;

    /**
     * Finds questions and answers associated with a specific consultation ID.
     *
     * @param consultationId The ID of the consultation for which to retrieve questions and answers.
     * @return A list of QuestionAnswerDTO objects containing questions and their corresponding answers.
     * @throws SQLException If a database access error occurs while retrieving questions and answers.
     */
    List<QuestionAnswerDTO> findQuestionsAndAnswersByConsultationId(int consultationId) throws SQLException;
}