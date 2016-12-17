import java.util.Arrays;

/********************************************************************************************************************
 * HW_Ch7_Ex15.java
 * Created by: Phillip Benoit 10-23-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 7.15 page 279
 ******************************************************************************************************************** 
 * This program asks for 10 integers and eliminates any duplicates
 ********************************************************************************************************************/

public class HW_Ch7_Ex15 {
    
    static final int NUMBERS_TO_COUNT=10;
    static final int MIN_NUMBER=1;
    static final int MAX_NUMBER=100;
    static final String QUESTION_START="Please input number ";
    static final String QUESTION_END=String.format(": (%d-%d)", MIN_NUMBER, MAX_NUMBER);
    static final String QUESTION = QUESTION_START + "%d" + QUESTION_END;
    static final String OUTPUT = "The distinct numbers are:";
    
    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch7_Ex15", "10-23-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 7.15 page 279",
                "This program asks for 10 integers and eliminates any duplicates",
                "");
        int numbers[] = getNumbers();
        numbers = eliminateDuplacates(numbers);
        displayNumbers(numbers);
        IR.displayEndOfProgram();
    }
    
    static void displayNumbers(int[] numbers) {
        System.out.println(OUTPUT);
        for (int step=0;step<numbers.length && numbers[step] != MIN_NUMBER - 1;step++) {
            System.out.println(numbers[step]);
        }
    }
    
    static int[] getNumbers() {
        int[] numbers = new int[NUMBERS_TO_COUNT];
        for (int step=0;step < numbers.length;step++) {
            numbers[step] = IR.getIntegerBetweenLowAndHigh(String.format(QUESTION, step), MIN_NUMBER, MAX_NUMBER);
        }
        return numbers;
    }
    
    public static int[] eliminateDuplacates(int[] list) {
        int[] newArray = new int[list.length];
        Arrays.fill(newArray, MIN_NUMBER - 1);
        boolean[] numbers = new boolean[MAX_NUMBER+1];
        Arrays.fill(numbers, true);
        int repeatCounter = 0;
        for (int step = 0;step<list.length;step++) {
            if (numbers[list[step]]) {
                newArray[repeatCounter] = list[step];
                repeatCounter++;
                numbers[list[step]] = false;
            }
        }
        return newArray;
    }
    

}
