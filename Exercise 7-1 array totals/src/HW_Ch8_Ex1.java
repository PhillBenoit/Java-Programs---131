import java.util.Arrays;

/********************************************************************************************************************
 * HW_Ch8_Ex1.java
 * Created by: Phillip Benoit 10-28-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 8.1 page 305-306
 ******************************************************************************************************************** 
 * This program is designed around a specific method from the book.
 * It gives the totals of a 2d array column.
 ********************************************************************************************************************/

public class HW_Ch8_Ex1 {

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch8_Ex1", "10-23-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 8.1 page 305-306",
                "This program is designed around a specific method from the book.",
                "It gives the totals of a 2d array column.");
        int rows = IR.getIntegerBetweenLowAndHigh("How many rows would you like in your matrix? (1-10)", 1, 10);
        int columns = IR.getIntegerBetweenLowAndHigh("How many columns would you like in your matrix? (1-10)", 1, 10);
        double[][] matrix = new double[rows][columns];
        double[] columnTotals = new double[columns];
        Arrays.fill(columnTotals, 0);
        getMatrix(matrix);
        getTotals(matrix, columnTotals);
        displayAll(matrix, columnTotals);
        IR.displayEndOfProgram();
    }
    
    static void displayAll(double[][] matrix, double[] totals) {
        leftCell(" ");
        for (int header = 0; header < totals.length; header++) {
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
        
        leftCell("Totals");
        for (int footer = 0; footer < totals.length; footer++) {
            rightCell(Double.toString(totals[footer]));
        }
        System.out.print("\n");
    }
    
    static void leftCell(String text) {
        System.out.format("%-7s", text);
    }
    
    static void rightCell(String text) {
        System.out.format("%7s", text);
    }
    
    public static double sumColumn(double[][] m, int columnIndex) {
        double total = 0;
        for (int row = 0; row < m.length; row++) {
            total += m[row][columnIndex];        
        }
        return total;
    }
    
    static void getTotals(double[][] matrix, double[] totals) {
        for (int column = 0; column < matrix[0].length; column++) {
            totals[column] = sumColumn(matrix, column);
        }
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
    

}
