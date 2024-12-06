package ru.rsreu.lint.expertsandteams.Datalayer.DAO.Expert;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamConsultationRequestDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * The ConsultationsRequestsDataDAO interface defines methods for data access operations
 * related to consultation requests from teams for a specific expert.
 */
public interface ConsultationsRequestsDataDAO {

    /**
     * Finds the count of teams associated with a specific expert.
     *
     * @param expertId The ID of the expert whose team count is to be retrieved.
     * @return The number of teams associated with the specified expert.
     * @throws SQLException If a database access error occurs while retrieving the team count.
     */
    int findCountTeamsByExpertId(int expertId) throws SQLException;

    /**
     * Finds the maximum count of teams associated with a specific expert.
     *
     * @param expertId The ID of the expert whose maximum team count is to be retrieved.
     * @return The maximum number of teams associated with the specified expert.
     * @throws SQLException If a database access error occurs while retrieving the maximum team count.
     */
    int findMaxCountTeamsByExpertId(int expertId) throws SQLException;

    /**
     * Retrieves a list of consultation requests from teams for a specific expert.
     *
     * @param expertId The ID of the expert whose consultation requests are to be retrieved.
     * @return A list of {@link TeamConsultationRequestDTO} objects representing consultation requests from teams.
     * @throws SQLException If a database access error occurs while retrieving the consultation requests.
     */
    List<TeamConsultationRequestDTO> findConsultationsRequestsFromTeams(int expertId) throws SQLException;
}