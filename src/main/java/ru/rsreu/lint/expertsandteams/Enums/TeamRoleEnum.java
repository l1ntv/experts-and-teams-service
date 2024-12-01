package ru.rsreu.lint.expertsandteams.Enums;

import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

public enum TeamRoleEnum {
    MEMBER {
        public int getTeamRoleId() {
            return Integer.parseInt(ConfigurationManager.getProperty("TEAM.ROLE.ENUM.MEMBER.ID.CONST"));
        }
    },

    CAPTAIN {
        public int getTeamRoleId() {
            return Integer.parseInt(ConfigurationManager.getProperty("TEAM.ROLE.ENUM.CAPTAIN.ID.CONST"));
        }
    };

    public abstract int getTeamRoleId();
}