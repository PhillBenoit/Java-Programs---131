import java.util.Arrays;

/********************************************************************************************************************
 * HW_Ch8_Ex13.java
 * Created by: Phillip Benoit 10-28-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 8.13 page 310
 ******************************************************************************************************************** 
 * This program is designed around a specific method from the book.
 * It finds the largest value in a 2d array.
 ********************************************************************************************************************/

public class HW_Ch8_Ex13 {

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch8_Ex13", "10-28-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 8.13 page 310",
                "This program is designed around a specific method from the book.",
                "It finds the largest value in a 2d array.");
        int rows = IR.getIntegerBetweenLowAndHigh("How many rows would you like in your matrix? (1-10)", 1, 10);
        int columns = IR.getIntegerBetweenLowAndHigh("How many columns would you like in your matrix? (1-10)", 1, 10);
        double[][] matrix = new double[rows][columns];
        getMatrix(matrix);
        int[] largestLocation = locateLargest(matrix);
        displayAll(matrix, largestLocation);
        IR.displayEndOfProgram();
    }
    
    public static int[] locateLargest(double[][] a) {
        int[] largestLocation = new int[3];
        double largestValue = -1;
        Arrays.fill(largestLocation, 0);
        for (int row = 0; row < a.length; row++) {
            for (int column = 0; column < a[0].length; column++) {
                if (a[row][column] > largestValue) {
                    largestValue = a[row][column];
                    largestLocation[0] = row;
                    largestLocation[1] = column;
                    largestLocation[2] = 0;
                }
                if (a[row][column] == largestValue) {largestLocation[2]++;}
            }
        }
        return largestLocation;
    }
    
    static void getMatrix(double[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                matrix[row][column] = IR.getDoubleBetweenLowAndHigh(String.format("Please enter a value for cell [%d][%d] : (0-100)",
                        row, column), 0, 100);
                System.out.println("You entered:" + matrix[row][column]);
            }
        }
    }
    
    static void displayAll(double[][] matrix, int[] location) {
        leftCell(" ");
        for (int header = 0; header < matrix[0].length; header++) {
            rightCell(Integer.toString(header));
        }
        System.out.print("\n");
        
        for (int row = 0; row < matrix.length; row++) {
            rightCell(Integer.toString(row));
            for (int column = 0; column < matrix[0].length; column++) {
                rightCell(Double.toString(matrix[row][column]));
            }
            System.out.print("\n");
        }
        
        System.out.print("\n");
        System.out.format("The largest value is: %f and it first occurs at [%d][%d] and occurs %d time(s).\n",
                matrix[location[0]][location[1]], location[0], location[1], location[2]);
    }
    
    static void leftCell(String text) {
        System.out.format("%-7s", text);
    }
    
    static void rightCell(String text) {
        System.out.format("%7s", text);
    }

}