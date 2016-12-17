/********************************************************************************************************************
 * HW_Ch5_Ex9.java
 * Created by: Phillip Benoit 11-13-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 5.9 page 193
 ******************************************************************************************************************** 
 * This program asks the user for the number of students in a class. It then
 * asks for names and scores for all those students and returns the top two.
 ********************************************************************************************************************/

public class HW_Ch5_Ex9 {
    
    private final static int CLASS_MIN = 5;
    private final static int CLASS_MAX = 45;
    private final static int SCORE_MIN = 0;
    private final static int SCORE_MAX = 100;
    private final static String CLASS_SIZE = String.format("Please input the size of your class: (%d-%d)", CLASS_MIN, CLASS_MAX);
    private final static String SCORE = "Please input the score of Student %d: (%d-%d)";
    private final static String NAME = "Please input the name of Student %d:";
    private final static String TOP = "Top Score: %s %d";
    private final static String SECOND = "Second Place: %s %d";
    
    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch5_Ex9", "11-13-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 5.9 page 193",
                "This program asks the user for the number of students in a class. It then",
                "asks for names and scores for all those students and returns the top two.");
        String[] topNames = new String[2];
        int[] topScores = new int[2];
        getStudents(topNames, topScores);
        printTopStudents(topNames, topScores);
        IR.displayEndOfProgram();
    }
    
    static void getStudents(String[] topNames, int[] topScores) {
        int classSize = IR.getIntegerBetweenLowAndHigh(CLASS_SIZE, CLASS_MIN, CLASS_MAX);
        for (int step = 0; step < classSize; step++) {
            String testName = IR.getString(String.format(NAME, step+1));
            int testScore = IR.getIntegerBetweenLowAndHigh(
                    String.format(SCORE, step+1, SCORE_MIN, SCORE_MAX), SCORE_MIN, SCORE_MAX);
            if (testScore >= topScores[0]) {
                topScores[1] = topScores[0];
                topNames[1] = topNames[0];
                topScores[0] = testScore;
                topNames[0] = testName;
            } else if (testScore >= topScores[1]) {
                topScores[1] = testScore;
                topNames[1] = testName;
            }
        }
    }
    
    static void printTopStudents(String[] topNames, int[] topScores) {
        System.out.format(TOP + "\n", topNames[0], topScores[0]);
        System.out.format(SECOND + "\n", topNames[1], topScores[1]);
    }

}
