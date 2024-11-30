package ru.rsreu.lint.expertsandteams.Datalayer.DAO;

import ru.rsreu.lint.expertsandteams.Datalayer.DTO.ExpertsStatisticsDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.QuestionAnswerDTO;

import java.sql.SQLException;
import java.util.List;

public interface ConsultationsDataDAO {
    boolean isUserJoinedInTeamByUserId(int id) throws SQLException;

    boolean isUserCaptainByUserId(int id) throws SQLException;

    int findTeamIdByUserId(int userId) throws SQLException;

    boolean isTeamHasExpertByTeamId(int teamId) throws SQLException;

    ExpertsStatisticsDTO findTeamExpertByTeamId(int teamId) throws SQLException;

    List<ExpertsStatisticsDTO> findListAvailableExperts() throws SQLException;

    List<QuestionAnswerDTO> findQuestionsAndAnswersByConsultationId(int consultationId) throws SQLException;
}
