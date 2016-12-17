/********************************************************************************************************************
 * HW_Ch12_Ex15.java
 * Created by: Phillip Benoit 11-30-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 12.15 page 490
 ******************************************************************************************************************** 
 * This program writes 100 integers to a file.
 * It then reads them back and sorts them in ascending order.
 ********************************************************************************************************************/

import java.util.Arrays;

public class HW_Ch12_Ex15 {
    
    private static final String FILE_NAME = "Exercise12_15.txt";

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch12_Ex15", "11-30-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 12.15 page 490",
                "This program writes 100 integers to a file.",
                "It then reads them back and sorts them in ascending order.");
        int a[] = IntFile.getRandomArray();
        IntFile.overwriteArray(a, FILE_NAME);
        int b[] = IntFile.readArray(FILE_NAME);
        sortArray(b);
        IntFile.displayArray(b);
        IR.displayEndOfProgram();
    }
    
    static void sortArray(int[] a){
        int widthValue = a[0];//holds column width while sorting
        a[0] = Integer.MIN_VALUE;//prevents 0 index from being sorted
        Arrays.sort(a);
        a[0] = widthValue;//returns width to 0 after sorting
    }
    
}