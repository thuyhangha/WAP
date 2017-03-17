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
    private int countNumCorrect = 0;
    private int countNumAttempt = 0;
    private int currentScore = 0;

    public Quiz() {
        quizList.add(new Question("9", "[3, 1, 4, 1, 5, ? ]", "PI"));
        quizList.add(new Question("8", "[1, 1, 2, 3, 5, ? ]", "Fibonacci"));
        quizList.add(new Question("36", "[1, 4, 9, 16, 25, ? ]", "Self multiply"));
        quizList.add(new Question("13", "[2, 3, 5, 7, 11, ? ]", "Prime number"));
        quizList.add(new Question("32", "[1, 2, 4, 8, 16, ? ]", "n x 2"));
    }

    public int getNumCorrect() {
        return countNumCorrect;
    }

    public void increaseNumCorrect() {
        countNumCorrect++;
    }

    public int getNumQuestions() {
        return quizList.size();
    }

    public String getCurrentQuestion() {
        if (countNumCorrect < quizList.size()) {
            return quizList.get(countNumCorrect).getQuestion();
        }
        return "";
    }

    public String getQuizAnswer(){
        if (countNumCorrect < quizList.size()) {
            return quizList.get(countNumCorrect).getAnswer();
        }
        return "";
    }
    public String getHint() {
        if (countNumCorrect < quizList.size()) {
            return quizList.get(countNumCorrect).getHint();
        }
        return "";
    }

    public int getCountNumAttempt() {
        return countNumAttempt;
    }

    public void setCountNumAttempt(int value) {
        this.countNumAttempt = value;
    }

    public boolean isCorrect(String anwer) {
        boolean isCorrectResult = false;
        if (countNumCorrect < quizList.size()) {
            countNumAttempt++;
            String currentAnswer = quizList.get(countNumCorrect).getAnswer();
            if (anwer.equals(currentAnswer)) {
                isCorrectResult = true;
            }
        }

        return isCorrectResult;
    }

    public void scoreAnswer() {
        if (countNumAttempt == 1) {
            currentScore += 10;
        } else if (countNumAttempt == 2) {
            currentScore += 5;
        } else if (countNumAttempt == 3) {
            currentScore += 2;
        }
        countNumAttempt = 0;
        countNumCorrect++;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public boolean isQuizOver() {
        return getNumCorrect() == getNumQuestions();
    }

    public String getErrorMessage() {
        return "Your last answer was not correct! Please try again";
    }
    
    public String getShowGrade(){
        String grade = "A";
        if(getCurrentScore() > 44){
            grade = "A";
        }else if(getCurrentScore() > 34){
            grade = "B";
        }else if(getCurrentScore() > 24){
            grade = "C";
        }else{
            grade = "NC";
        }
        return grade;
    }
}
