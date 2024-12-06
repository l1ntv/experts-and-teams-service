package ru.rsreu.lint.expertsandteams.Datalayer.DTO.Moderator;

/**
 * The ConsultationMessageDTO class represents a data transfer object for a consultation message.
 * It contains information about the message's author, the associated consultation, and the message content.
 */
public class ConsultationMessageDTO {
    private int authorId;
    private int consultationId;
    private String authorLogin;
    private String message;

    /**
     * Constructs a new ConsultationMessageDTO with the specified parameters.
     *
     * @param authorId       The unique identifier of the message author.
     * @param consultationId The unique identifier of the consultation associated with the message.
     * @param authorLogin    The login of the message author.
     * @param message        The content of the consultation message.
     */
    public ConsultationMessageDTO(int authorId, int consultationId, String authorLogin, String message) {
        this.authorId = authorId;
        this.consultationId = consultationId;
        this.authorLogin = authorLogin;
        this.message = message;
    }

    /**
     * Returns the unique identifier of the message author.
     *
     * @return An integer representing the author's ID.
     */
    public int getAuthorId() {
        return authorId;
    }

    /**
     * Sets the unique identifier of the message author.
     *
     * @param authorId An integer representing the author's ID.
     */
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    /**
     * Returns the login of the message author.
     *
     * @return A string representing the author's login.
     */
    public String getAuthorLogin() {
        return authorLogin;
    }

    /**
     * Sets the login of the message author.
     *
     * @param authorLogin A string representing the author's login.
     */
    public void setAuthorLogin(String authorLogin) {
        this.authorLogin = authorLogin;
    }

    /**
     * Returns the content of the consultation message.
     *
     * @return A string representing the message content.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the content of the consultation message.
     *
     * @param message A string representing the message content.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns the unique identifier of the consultation associated with the message.
     *
     * @return An integer representing the consultation ID.
     */
    public int getConsultationId() {
        return consultationId;
    }

    /**
     * Sets the unique identifier of the consultation associated with the message.
     *
     * @param consultationId An integer representing the consultation ID.
     */
    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }
}