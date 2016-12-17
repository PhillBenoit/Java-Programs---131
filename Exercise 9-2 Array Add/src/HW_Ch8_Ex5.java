/********************************************************************************************************************
 * HW_Ch8_Ex5.java
 * Created by: Phillip Benoit 11-19-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 8.5 page 307
 ******************************************************************************************************************** 
 * This program asks the user for 2 3x3 arrays.
 * It then adds them.
 ********************************************************************************************************************/

import java.text.DecimalFormat;

public class HW_Ch8_Ex5 {
    
    static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch8_Ex5", "11-19-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 8.5 page 307",
                "This program asks the user for 2 3x3 arrays.",
                "It then adds them.");
        double[][][] matrix = new double[3][3][3];
        getMatrix(matrix);
        matrix[2] = addMatrix(matrix[0], matrix[1]);
        displayResults(matrix);
        IR.displayEndOfProgram();
    }
    
    static void displayResults(double[][][] matrix) {
        System.out.println("\nFirst Matrix:");
        displayMatrix(matrix[0]);
        System.out.println("\nSecond Matrix:");
        displayMatrix(matrix[1]);
        System.out.println("\nTotal:");
        displayMatrix(matrix[2]);
    }
    
    static void getMatrix(double[][][] matrix) {
        for (int m = 0; m < 2; m++ ) {
            for (int row = 0; row < matrix[0].length; row++) {
                for (int column = 0; column < matrix[0][0].length; column++) {
                    matrix[m][row][column] = IR.getDoubleBetweenLowAndHigh(String.format(
                            "Please enter a value for cell [%d][%d] in matrix %d: (0 - 100)",
                            row, column, m), 0, 100);
                    System.out.println("You entered: " + df.format(matrix[m][row][column]));
                }
            }    
        }
    }
    
    static double[][] addMatrix(double[][] a, double[][] b) {
        double[][] c = new double[a.length][a[0].length];
        for (int row = 0; row < a.length; row++) {
            for (int column = 0; column < a[row].length; column++) {
                c[row][column] = a[row][column] + b[row][column];
            }
        }
        return c;
    }
    
    static void displayMatrix(double[][] matrix) {
        leftCell(" ");
        for (int header = 0; header < matrix[0].length; header++) {
            rightCell("[" + Integer.toString(header) + "]");
        }
        System.out.print("\n");
        
        for (int row = 0; row < matrix.length; row++) {
            rightCell("[" + Integer.toString(row) + "]");
            for (int column = 0; column < matrix[0].length; column++) {
                rightCell(df.format(matrix[row][column]));
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

}
