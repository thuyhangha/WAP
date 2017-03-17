package model;

public class Quiz {
	private static String[] questions = { "3, 1, 4, 1, 5, ?", "1, 1, 2, 3, 5, ?", "1, 4, 9, 16, 25, ?", "2, 3, 5, 7, 11, ?",
			"1, 2, 4, 8, 16" };
	private static int[] answers = { 9, 8, 36, 13, 32 };
	
	private static String[] hints = { "PI", "Fibonacci", "Self multiply", "Prime number", "n x 2" };

	public String[] getQuestions() {
		return questions;
	}

	public int[] getAnswers() {
		return answers;
	}
	
	public String[] getHints() {
		return hints;
	}
	
	 public int getCurrentScore(int countNumAttempt, int currentScore) {
        if (countNumAttempt == 1) {
            currentScore += 10;
        } else if (countNumAttempt == 2) {
            currentScore += 5;
        } else if (countNumAttempt == 3) {
            currentScore += 2;
        }
        return currentScore;
    }
 
	public String getShowGrade(int currentScore){
        String grade = "A";
        if(currentScore > 44){
            grade = "A";
        }else if(currentScore > 34){
            grade = "B";
        }else if(currentScore > 24){
            grade = "C";
        }else{
            grade = "NC";
        }
        return grade;
    }
}