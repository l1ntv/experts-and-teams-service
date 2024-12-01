package ru.rsreu.lint.expertsandteams.Logic.Administrator;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.Administrator.AdministratorDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.TeamsStatisticsDTO;

import java.sql.SQLException;
import java.util.List;

public class TeamsStatisticsLogic {
    public static List<TeamsStatisticsDTO> getTeamsStatisticList() throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        AdministratorDataDAO administratorDataDAO = factory.getAdministratorDataDAO();
        List<TeamsStatisticsDTO> list = administratorDataDAO.getTeamsStatisticsList();
        return list;
    }
}
