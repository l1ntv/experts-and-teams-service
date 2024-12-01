package ru.rsreu.lint.expertsandteams.Enums;

import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

public enum AccountsTypesEnum {
    USER {
        public int getAccountTypeId() {
            return Integer.parseInt(ConfigurationManager.getProperty("ACCOUNTS.TYPES.ENUM.USER.ID.CONST"));
        }
    },
    EXPERT {
        public int getAccountTypeId() {
            return Integer.parseInt(ConfigurationManager.getProperty("ACCOUNTS.TYPES.ENUM.EXPERT.ID.CONST"));
        }
    },
    MODERATOR {
        public int getAccountTypeId() {
            return Integer.parseInt(ConfigurationManager.getProperty("ACCOUNTS.TYPES.ENUM.MODERATOR.ID.CONST"));
        }
    },
    ADMINISTRATOR {
        public int getAccountTypeId() {
            return Integer.parseInt(ConfigurationManager.getProperty("ACCOUNTS.TYPES.ENUM.ADMINISTRATOR.ID.CONST"));
        }
    };

    public abstract int getAccountTypeId();
}