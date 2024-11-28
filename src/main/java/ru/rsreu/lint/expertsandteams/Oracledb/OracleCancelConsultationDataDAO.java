package ru.rsreu.lint.expertsandteams.Oracledb;

import ru.rsreu.lint.expertsandteams.Datalayer.DAO.CancelConsultationDataDAO;

import java.sql.Connection;

public class OracleCancelConsultationDataDAO implements CancelConsultationDataDAO {
    private Connection connection;

    public OracleCancelConsultationDataDAO(Connection connection) {
        this.connection = connection;
    }
}
