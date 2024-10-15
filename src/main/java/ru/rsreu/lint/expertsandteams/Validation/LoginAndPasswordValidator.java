package ru.rsreu.lint.expertsandteams.Validation;

import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginAndPasswordValidator {
    public ValidationData validateAuthenticationData(String login, String password) {
        boolean isValid;
        StringBuilder errorMessage = new StringBuilder("");

        if (!this.validateLogin(login)) {
            errorMessage.append("логина. ");
        }

        if (!this.validatePassword(password)) {
            errorMessage.append("пароля. ");
        }

        return new ValidationData(isValid = errorMessage.length() == 0 ? true : false, errorMessage.toString().trim());
    }

    private boolean validateLogin(String login) {
        return this.matches(ConfigurationManager.getProperty("LOGIN.REGEX.CONST"), login);
    }

    private boolean validatePassword(String password) {
        return this.matches(ConfigurationManager.getProperty("PASSWORD.REGEX.CONST"), password);
    }

    private boolean matches(String regex, String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
