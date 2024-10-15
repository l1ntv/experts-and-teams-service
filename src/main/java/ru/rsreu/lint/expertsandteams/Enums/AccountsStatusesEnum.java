package ru.rsreu.lint.expertsandteams.Enums;

import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

public enum AccountsStatusesEnum {
    OFFLINE {
        public int getAccountStatusId() {
            return Integer.parseInt(ConfigurationManager.getProperty("ACCOUNTS.STATUSES.ENUM.OFFLINE.ID.CONST"));
        }
    },
    ONLINE {
        public int getAccountStatusId() {
            return Integer.parseInt(ConfigurationManager.getProperty("ACCOUNTS.STATUSES.ENUM.ONLINE.ID.CONST"));
        }
    },
    BANNED {
        public int getAccountStatusId() {
            return Integer.parseInt(ConfigurationManager.getProperty("ACCOUNTS.STATUSES.ENUM.BANNED.ID.CONST"));
        }
    };

    public abstract int getAccountStatusId();
}
