package ru.rsreu.lint.expertsandteams.Listener;

import ru.rsreu.lint.expertsandteams.Logic.Common.LogoutLogic;
import ru.rsreu.lint.expertsandteams.Logic.Common.SessionFilterLogic;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.sql.SQLException;

public class SessionListener implements HttpSessionListener {

    public void sessionDestroyed(HttpSessionEvent se) {
        Integer userIdParam = (Integer) se.getSession().getAttribute(ConfigurationManager.getProperty("USER_ID.CONST"));
        Integer groupTypeIdParam = (Integer) se.getSession().getAttribute(ConfigurationManager.getProperty("GROUP_TYPE_ID.CONST"));
        if (userIdParam != null && groupTypeIdParam != null) {
            try {
                if (groupTypeIdParam != 0) {
                    LogoutLogic.setOfflineStatusByUserId(userIdParam);
                } else {
                    if (!SessionFilterLogic.isUserBannedByUserId(userIdParam))
                        LogoutLogic.setOfflineStatusByUserId(userIdParam);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}