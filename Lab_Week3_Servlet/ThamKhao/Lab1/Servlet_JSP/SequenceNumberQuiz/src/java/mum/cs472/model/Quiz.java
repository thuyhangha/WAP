package mum.cs472.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author SOKLY
 */
public class Quiz {

    private List<Question> quizList = new ArrayList();
    static private int countNumCorrect;

    public Quiz() {
        countNumCorrect = 0;
        quizList.add(new Question("9", "[3, 1, 4, 1, 5, ? ]"));
        quizList.add(new Question("8", "[1, 1, 2, 3, 5, ? ]"));
        quizList.add(new Question("36", "[1, 4, 9, 16, 25, ? ]"));
        quizList.add(new Question("13", "[2, 3, 5, 7, 11, ? ]"));
        quizList.add(new Question("32", "[1, 2, 4, 8, 16, ? ]"));
    }

    public int getNumCorrect() {
        return countNumCorrect;
    }

    public int getNumQuestions() {

        return 5;
    }

    public String getCurrentQuestion() {

        return quizList.get(countNumCorrect).getQuestion();
    }

    public boolean isCorrect(String anwer) {
        boolean isCorrectResult = false;
        String currentAnswer = quizList.get(countNumCorrect).getAnswer();
        if (anwer.equals(currentAnswer)) {
            isCorrectResult = true;
        }
        return isCorrectResult;
    }

    public void scoreAnswer() {
        countNumCorrect++;
    }
}
