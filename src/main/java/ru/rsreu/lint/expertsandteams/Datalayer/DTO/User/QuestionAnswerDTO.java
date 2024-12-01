package ru.rsreu.lint.expertsandteams.Datalayer.DTO.User;

public class QuestionAnswerDTO {
    private int consultationId;
    private String question;
    private String answer;

    public QuestionAnswerDTO(int consultationId, String question, String answer) {
        this.consultationId = consultationId;
        this.question = question;
        this.answer = answer;
    }

    public int getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
