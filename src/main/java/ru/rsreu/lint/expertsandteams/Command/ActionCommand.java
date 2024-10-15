package ru.rsreu.lint.expertsandteams.Command;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface ActionCommand {
    Page execute(HttpServletRequest request) throws SQLException;
}
