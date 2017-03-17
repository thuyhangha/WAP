package mum.cs472.model;

/**
 *
 * @author SOKLY
 */
public class Question {

    private String question;
    private String answer;
    private String hint;

    public Question(String answer, String question, String hint) {
        this.answer = answer;
        this.question = question;
        this.hint = hint;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
    public String getHint() {
        return hint;
    }
    

}
