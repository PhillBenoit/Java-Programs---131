import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/********************************************************************************************************************
 * IntFile.java
 * Created by: Phillip Benoit 11-30-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 12.15, 17.1, and 12.3
 ******************************************************************************************************************** 
 * This is a special class utilized for all programs in Exercise 11.
 * It handles an Array list, File IO and generating integers.
 ********************************************************************************************************************/

public class IntFile {
    
    public static final int ARRAY_SIZE = 100;
    
    public static final int RND_MIN = -9;
    public static final int RND_MAX = 99;
    
    public static void main(String[] args) {
        IR.displayProgramInformation("IntFile", "11-30-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 12.15, 17.1, and 12.3",
                "This is a special class utilized for all programs in Exercise 11.",
                "It handles an Array list, File IO and generating integers.");
        IR.displayEndOfProgram();
    }
    
    public static int[] getRandomArray(){
        int[] returnArray = new int[ARRAY_SIZE + 1];
        returnArray[0] = columnSize(RND_MIN, RND_MAX);//index 0 is column width
        for (int i=1; i < returnArray.length; i++) {
            returnArray[i] = IR.getRandomNumber(RND_MIN, RND_MAX);
        }
        return returnArray;
    }
    
    //element 0 holds the column width
    public static void displayArray(int a[]){
        int columnCounter = 1;//counts number of columns printed to the row
        int rowSize = 80 / a[0];//number of columns per row
        for (int i = 1; i < a.length; i++) {
            if (columnCounter > rowSize) {
                System.out.print("\n");
                columnCounter = 1;
            }
            IR.displayCell(a[0], Integer.toString(a[i]));
            columnCounter += 1;            
        }
        System.out.print("\n");
    }
    
    //calculates column width based on string length of min / max numbers
    public static int columnSize(int min, int max){
        return Math.max(
                Integer.toString(min).length(),
                Integer.toString(max).length()) + 1;
    }
    
    public static int[] readArray(String fileName){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        inputList.add(0);//placeholder for column width measurement
        
        FileReader file = tryReader(fileName);
        Scanner stream = new Scanner(file);
        while (stream.hasNextInt()){
            int i = stream.nextInt();
            inputList.add(i);
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        stream.close();
        tryClose(file);
        
        int[] a = new int[inputList.size()];
        a[0] = columnSize(min, max);
        for (int i = 1; i < a.length; i++) {
            a[i] = inputList.get(i);
        }
        return a;
    }
    
    public static void writeArray(int[] a, String fileName){
        Writer output = tryWriter(fileName);
        for (int i = 1; i < a.length; i++){
            tryAppend(output, a[i] + " ");
        }
        tryClose(output);
    }
    
    public static void overwriteArray(int[] a, String fileName){
        destroyExisting(Paths.get(fileName));
        writeArray(a, fileName);
    }
    
    //---------------------------------------------------------------------------------------------------------
    private static FileReader tryReader(String path){
        FileReader file;
        try {
            file = new FileReader(path);
            return file;
        } catch (FileNotFoundException e) {
            notFoundStop();
        }
        return null;
    }
    
    private static void tryAppend(Writer w, String s){
        try {
            w.append(s);
        } catch (IOException e) {
            IOStop();
        }
    }
    
    private static void tryClose(Writer w){
        try {
            w.close();
        } catch (IOException e) {
            IOStop();
        }
    }
    
    private static void tryClose(FileReader file) {
        try {
            file.close();
        } catch (IOException e) {
            IOStop();
        }
    }
    
    private static Writer tryWriter(String fileName){
        try {
            Writer file = new FileWriter(fileName);
            return file;
        } catch (IOException e) {
            IOStop();
        }
        return null;
    }
    
    static void destroyExisting(Path path){
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            IOStop();
        }
    }
    
    public static boolean exists(String fileName){
        return Files.exists(Paths.get(fileName));
    }
    
    //-----------------------------------------------------------------------------------------------------
    static void IOStop(){
        System.err.format("Program encountered an IOException.");
        System.exit(-1);
    }
    
    static void notFoundStop(){
        System.err.format("Input File not found.");
        System.exit(-1);
    }

}
