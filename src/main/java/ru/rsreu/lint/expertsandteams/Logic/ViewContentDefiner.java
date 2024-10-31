package ru.rsreu.lint.expertsandteams.Logic;

import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

public class ViewContentDefiner {
    public static String defineCorrectJspPageByGroupTypeId(int groupTypeId) {
        String jsp = new String();
        switch (groupTypeId) {
            case 0:
                jsp = ConfigurationManager.getProperty("USER.MAIN.PAGE");
                break;
            case 1:
                jsp = ConfigurationManager.getProperty("EXPERT.MAIN.PAGE");
                break;
            case 2:
                jsp = ConfigurationManager.getProperty("MODERATOR.MAIN.PAGE");
                break;
            case 3:
                jsp = ConfigurationManager.getProperty("ADMINISTRATOR.MAIN.PAGE");
                break;
            default:
                // TO DO error handle
        }
        return jsp;
    }
}
