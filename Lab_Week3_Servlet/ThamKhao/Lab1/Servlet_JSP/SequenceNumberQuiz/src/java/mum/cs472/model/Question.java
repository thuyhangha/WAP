package mum.cs472.model;

/**
 *
 * @author SOKLY
 */
public class Question {

    private String question;
    private String answer;

    public Question(String answer, String question) {
        this.answer = answer;
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

}
