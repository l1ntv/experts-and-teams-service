package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Moderator;

public class ConsultationMessageDTO {
    private int authorId;
    private int consultationId;
    private String authorLogin;
    private String message;

    public ConsultationMessageDTO(int authorId, int consultationId, String authorLogin, String message) {
        this.authorId = authorId;
        this.consultationId = consultationId;
        this.authorLogin = authorLogin;
        this.message = message;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorLogin() {
        return authorLogin;
    }

    public void setAuthorLogin(String authorLogin) {
        this.authorLogin = authorLogin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }
}
