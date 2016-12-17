import java.util.Arrays;

/********************************************************************************************************************
 * HW_Ch8_Ex29.java
 * Created by: Phillip Benoit 10-29-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 8.29 page 316
 ******************************************************************************************************************** 
 * This program is designed around a specific method from the book.
 * It compares two arrays and returns a boolean indicating their similarity.
 ********************************************************************************************************************/

public class HW_Ch8_Ex29 {

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch8_Ex29", "10-29-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 8.29 page 316",
                "This program is designed around a specific method from the book.",
                "It compares two arrays and returns a boolean indicating their similarity.");
        int rows = IR.getIntegerBetweenLowAndHigh("How many rows would you like in your matrices? (1-10)", 1, 10);
        int columns = IR.getIntegerBetweenLowAndHigh("How many columns would you like in your matrices? (1-10)", 1, 10);
        int[][][] matrix = new int[2][rows][columns];
        getMatrix(matrix);
        boolean compare = equals(matrix[0], matrix[1]);
        displayAll(matrix, compare);
        IR.displayEndOfProgram();
    }
    
    static void displayAll(int[][][] matrix, boolean compare) {
        for (int m = 0; m < matrix.length; m++ ) {
            displayMatrix(matrix[m]);
        }
        
        if (compare) {
            System.out.println("The matrices are equal.");
        } else {
            System.out.println("The matrices are not equal.");
        }
        
    }
    
    static void displayMatrix(int[][] matrix) {
        leftCell(" ");
        for (int header = 0; header < matrix[0].length; header++) {
            rightCell(Integer.toString(header));
        }
        System.out.print("\n");
        
        for (int row = 0; row < matrix.length; row++) {
            rightCell(Integer.toString(row));
            for (int column = 0; column < matrix[0].length; column++) {
                rightCell(Integer.toString(matrix[row][column]));
            }
            System.out.print("\n");
        }
        
        System.out.print("\n");
    }
    
    static void leftCell(String text) {
        System.out.format("%-7s", text);
    }
    
    static void rightCell(String text) {
        System.out.format("%7s", text);
    }
    
    public static boolean equals(int[][] m1, int[][] m2) {
        boolean check = true;
        for (int step = 0; check && step < m1[0].length; step++) {
            check = Arrays.equals(m1[step], m2[step]);
        }
        return check;
    }
    
    static void getMatrix(int[][][] matrix) {
        for (int m = 0; m < matrix.length; m++ ) {
            for (int row = 0; row < matrix[0].length; row++) {
                for (int column = 0; column < matrix[0][0].length; column++) {
                    matrix[m][row][column] = IR.getIntegerBetweenLowAndHigh(String.format("Please enter a value for cell [%d][%d] in matrix %d: (0-100)",
                            row, column, m), 0, 100);
                    System.out.println("You entered:" + matrix[m][row][column]);
                }
            }    
        }
    }

}
