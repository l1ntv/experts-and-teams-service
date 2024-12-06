package ru.rsreu.lint.expertsandteams.Datalayer.DTO.User;

/**
 * The QuestionAnswerDTO class represents a data transfer object for a question and its corresponding answer
 * in the context of a consultation.
 */
public class QuestionAnswerDTO {
    private int consultationId;
    private String question;
    private String answer;

    /**
     * Constructs a new QuestionAnswerDTO with the specified parameters.
     *
     * @param consultationId The unique identifier for the consultation.
     * @param question       The question asked during the consultation.
     * @param answer         The answer provided in response to the question.
     */
    public QuestionAnswerDTO(int consultationId, String question, String answer) {
        this.consultationId = consultationId;
        this.question = question;
        this.answer = answer;
    }

    /**
     * Returns the unique identifier for the consultation.
     *
     * @return An integer representing the consultation ID.
     */
    public int getConsultationId() {
        return consultationId;
    }

    /**
     * Sets the unique identifier for the consultation.
     *
     * @param consultationId An integer representing the consultation ID to be set.
     */
    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }

    /**
     * Returns the question asked during the consultation.
     *
     * @return A string representing the question.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the question asked during the consultation.
     *
     * @param question A string representing the question to be set.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Returns the answer provided in response to the question.
     *
     * @return A string representing the answer.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Sets the answer provided in response to the question.
     *
     * @param answer A string representing the answer to be set.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}