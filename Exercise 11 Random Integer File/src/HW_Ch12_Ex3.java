/********************************************************************************************************************
 * HW_Ch12_Ex3.java
 * Created by: Phillip Benoit 11-30-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 12.3
 ******************************************************************************************************************** 
 * This program generates an array of random integers.
 * It then asks for an index and catches an out of bounds exception.
 ********************************************************************************************************************/

public class HW_Ch12_Ex3 {

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch12_Ex3", "11-30-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 12.3",
                "This program generates an array of random integers.",
                "It then asks for an index and catches an out of bounds exception.");
        int a[] = IntFile.getRandomArray();
        IntFile.displayArray(a);
        tryIndex(a);
        IR.displayEndOfProgram();
    }
    
    public static void tryIndex(int[] a){
        //special adjustments made to eliminate index 0 containing a column width value
        int index = IR.getInteger(String.format("Please enter an index: (0-%d)", a.length-2));
        index = index == -1 ? -2 : index;
        try {
            System.out.format("The value at index (%d) is (%d)\n", index, a[index+1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("The index you entered is not valid.");
            System.exit(-1);
        }
    }

}
