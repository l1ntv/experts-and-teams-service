package ru.rsreu.lint.expertsandteams.Mapper;

import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordMapper {

    public static String mapPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance(ConfigurationManager.getProperty("SHA-256.CONST"));
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}