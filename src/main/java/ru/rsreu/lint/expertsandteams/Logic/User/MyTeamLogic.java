package ru.rsreu.lint.expertsandteams.Logic.User;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.User.MyTeamDataDAO;
import ru.rsreu.lint.expertsandteams.Datalayer.DAOFactory;
import ru.rsreu.lint.expertsandteams.Datalayer.DBType;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.User.MyTeamDTO;
import ru.rsreu.lint.expertsandteams.Datalayer.DTO.User.TeamMemberDTO;
import ru.rsreu.lint.expertsandteams.Logic.Common.MainLogic;

import java.sql.SQLException;
import java.util.List;

public class MyTeamLogic {
    public static MyTeamDTO createMyTeamDTOByTeamId(int teamId) throws SQLException {
        DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
        MyTeamDataDAO myTeamDataDAO = factory.getMyTeamDataDAO();
        String name = MainLogic.findTeamNameByTeamId(teamId);
        int countMembers = myTeamDataDAO.findCountMembersByTeamId(teamId);
        int maxCountMembers = myTeamDataDAO.findMaxCountMembersByTeamId(teamId);
        List<TeamMemberDTO> list = myTeamDataDAO.findTeamMemberDTOListByTeamId(teamId);
        MyTeamDTO myTeamDTO = new MyTeamDTO(name, countMembers, maxCountMembers, list);
        return myTeamDTO;
    }
}
