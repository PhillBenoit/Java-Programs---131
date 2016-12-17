/********************************************************************************************************************
 * HW_Ch7_Ex1.java
 * Created by: Phillip Benoit 10-23-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 7.1 page 276
 ******************************************************************************************************************** 
 * This program asks the user for a number of students, then grades
 * of each, then assigns a grade based off the best score.
 ********************************************************************************************************************/

public class HW_Ch7_Ex1 {
    
    static final int LOWEST_SCORE=1;
    static final int HIGHEST_SCORE=100;
    static final int MIN_STUDENTS=1;
    static final int MAX_STUDENTS=45;
    static final String STUDENTS_QUESTION=String.format("Please enter a number of students: (%d-%d)", MIN_STUDENTS, MAX_STUDENTS);
    static final String SCORE_START="Please enter the score of student ";
    static final String SCORE_END=String.format(": (%d-%d)", LOWEST_SCORE, HIGHEST_SCORE);
    static final String SCORE_FORMAT=SCORE_START + "%d" + SCORE_END;
    static final String SCORE_DISPLAY="The score of student %d is: %d the leter grade is %s";
    
    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch7_Ex1", "10-23-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 7.1 page 276",
                "This program asks the user for a number of students, then grades",
                "of each, then assigns a grade based off the best score.");
        int numberOfStudents = IR.getIntegerBetweenLowAndHigh(STUDENTS_QUESTION, MIN_STUDENTS, MAX_STUDENTS);
        int scores[] = new int[numberOfStudents];
        int bestScore = getScores(scores);
        displayScores(scores, bestScore);
        IR.displayEndOfProgram();
    }
    
    static int getScores(int[] scores) {
        int bestScore=LOWEST_SCORE-1;
        for (int step=0;step<scores.length;step++) {
            scores[step] = IR.getIntegerBetweenLowAndHigh(String.format(SCORE_FORMAT, step), LOWEST_SCORE, HIGHEST_SCORE);
            bestScore = scores[step] > bestScore ? scores[step] : bestScore;
        }
        return bestScore;
    }
    
    static void displayScores(int[] scores, int best) {
        for (int step=0;step<scores.length;step++) {
            System.out.println(String.format(SCORE_DISPLAY, step, scores[step], convertToLetter(scores[step], best)));
        }
    }
    
    static String convertToLetter(int score, int best) {
        int offset = best-score;
        if (offset <= 10) {return "A";}
        if (offset <= 20) {return "B";}
        if (offset <= 30) {return "C";}
        if (offset <= 40) {return "D";}
        return "F";
    }

}
