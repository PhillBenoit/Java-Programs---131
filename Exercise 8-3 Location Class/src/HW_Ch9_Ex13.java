/********************************************************************************************************************
 * HW_Ch9_Ex13.java
 * Created by: Phillip Benoit 11-13-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 9.13 pages 363-364
 ******************************************************************************************************************** 
 * This program demonstrates the Location class. The location class contains 
 * info about the element with the greatest value in a two dimensional array.
 ********************************************************************************************************************/

public class HW_Ch9_Ex13 {
    
    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch9_Ex13", "11-13-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 9.13 pages 363-364",
                "This program demonstrates the Location class. The location class contains",
                "info about the element with the greatest value in a two dimensional array.");
        double[][] matrix = getMatrix();
        Location max = Location.locateLargest(matrix);
        printMax(max);
        IR.displayEndOfProgram();
    }
    
    static void printMax(Location max) {
        System.out.println("Greatest Value:   " + max.maxValue);
        System.out.format("First occurrs at: [%d][%d]\n", max.row, max.column);
        System.out.println("Occurrences:      " + max.occurrences);
    }
    
    static double[][] getMatrix() {
        int rows = IR.getIntegerBetweenLowAndHigh("How many rows would you like in your matrix? (1-10)", 1, 10);
        int columns = IR.getIntegerBetweenLowAndHigh("How many columns would you like in your matrix? (1-10)", 1, 10);
        double[][] matrix = new double[rows][columns];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                matrix[row][column] = IR.getDoubleBetweenLowAndHigh(String.format("Please enter a value for cell [%d][%d] : (1.0-100.0)",
                        row, column), 1, 100);
                System.out.println("You entered:" + matrix[row][column]);
            }
        }
        return matrix;
    }

}
