package ru.rsreu.lint.expertsandteams.Logic.Administrator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.ExpertsStatisticsDTO;

import java.sql.SQLException;
import java.util.List;

public class ExpertsStatisticsLogic {
    public static List<ExpertsStatisticsDTO> getExpertsStatisticsList() throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        List<ExpertsStatisticsDTO> list = administratorDataDAO.getExpertsStatisticsList();
        return list;
    }
}
