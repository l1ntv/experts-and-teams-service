package ru.rsreu.lint.expertsandteams.Datalayer;

public class DBTypeException extends RuntimeException {
    public DBTypeException() {
        super();
    }

    public DBTypeException(String message) {
        super(message);
    }
}
