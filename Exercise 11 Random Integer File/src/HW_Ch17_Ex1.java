/********************************************************************************************************************
 * HW_Ch17_Ex1.java
 * Created by: Phillip Benoit 11-30-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 17.1 page 701
 ******************************************************************************************************************** 
 * This program appends 100 integers to a test file.
 * it then reads back and displays the contents of the file.
 ********************************************************************************************************************/

public class HW_Ch17_Ex1 {
    
    private static final String FILE_NAME = "Exercise17_1.txt";

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch17_Ex1", "11-30-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 17.1 page 701",
                "This program appends 100 integers to a test file.",
                "it then reads back and displays the contents of the file.");
        int a[] = IntFile.getRandomArray();
        int b[], c[];
        if (IntFile.exists(FILE_NAME)) {
            b = IntFile.readArray(FILE_NAME);
            c = appendArray(a, b);
        } else {
            c = a;
        }
        IntFile.writeArray(c, FILE_NAME);
        int d[] = IntFile.readArray(FILE_NAME);
        IntFile.displayArray(d);
        IR.displayEndOfProgram();
    }
    
    public static int[] appendArray(int[] a, int[] b){
        int c[] = new int[a.length + b.length - 1];//-1 because both have column width
        c[0] = Math.max(a[0], b[0]);//new max column width
        copyArray(a, c, 0);
        copyArray(b, c, a.length-1);
        return c;
    }
    
    //IS is an index start
    public static void copyArray(int[] a, int[] b, int IS){
        for (int i = 1; i < a.length; i++) {
            b[i+IS] = a[i];
        }
    }
    
}