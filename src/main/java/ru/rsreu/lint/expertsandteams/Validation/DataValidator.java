package ru.rsreu.lint.expertsandteams.Validation;

import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    private DataValidator() {};
    public static ValidationData validateAuthenticationData(String login, String password) {
        boolean isValid;
        StringBuilder errorMessage = new StringBuilder("");

        if (!DataValidator.validateLogin(login)) {
            errorMessage.append("логина. ");
        }

        if (!DataValidator.validatePassword(password)) {
            errorMessage.append("пароля. ");
        }

        return new ValidationData(isValid = errorMessage.length() == 0 ? true : false, errorMessage.toString().trim());
    }

    public static ValidationData validateCreationUserData(String login) {
        boolean isValid;
        StringBuilder errorMessage = new StringBuilder("");
        if (!DataValidator.validateLogin(login)) {
            errorMessage.append("логина. ");
        }
        return new ValidationData(isValid = errorMessage.length() == 0 ? true : false, errorMessage.toString().trim());
    }

    private static boolean validateUserLogin(String login) {
        return DataValidator.validateLogin(login);
    }

    private static boolean validateLogin(String login) {
        return DataValidator.matches(ConfigurationManager.getProperty("LOGIN.REGEX.CONST"), login);
    }

    private static boolean validatePassword(String password) {
        return DataValidator.matches(ConfigurationManager.getProperty("PASSWORD.REGEX.CONST"), password);
    }

    private static boolean matches(String regex, String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
