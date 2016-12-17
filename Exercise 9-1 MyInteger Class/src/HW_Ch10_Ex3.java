/********************************************************************************************************************
 * HW_Ch10_Ex3.java
 * Created by: Phillip Benoit 11-19-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 10.3 page 400
 ******************************************************************************************************************** 
 * This program demonstrates the functionality of the
 * MyInteger class using set routines.
 ********************************************************************************************************************/

public class HW_Ch10_Ex3 {

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch10_Ex3", "11-19-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 10.3 page 400",
                "This program demonstrates the functionality of the",
                "MyInteger class using set routines.");
        runTests();
        IR.displayEndOfProgram();
    }
    
    static void runTests() {
        testConstructor();
        testSet();
        testEvenOdd();
        testEquals();
        testParseInt();
        testPrime();
    }
    
    static void testConstructor() {
        MyInteger x = new MyInteger(420);
        System.out.println("Constructor Test: " + x.getValue());
    }
    
    static void testSet() {
        MyInteger x = new MyInteger();
        System.out.println("No Arg Constructor Test: " + x.getValue());
        x.setValue(420);
        System.out.println("Set Test: " + x.getValue());
    }
    
    static void testEvenOdd() {
        MyInteger x = new MyInteger(420);
        System.out.println("Even Test: " + x.isEven());
        System.out.println("Odd Test: " + x.isOdd());
        System.out.println("Static Even Test: " + MyInteger.isEven(420));
        System.out.println("Static Odd Test: " + MyInteger.isOdd(420));
    }
    
    static void testEquals() {
        MyInteger x = new MyInteger(420);
        System.out.println("Equals Test int: " + x.equals(420));
        MyInteger y = new MyInteger(420);
        System.out.println("Equals Test MyInteger: " + x.equals(y));
    }
    
    static void testParseInt() {
        String fourTwenty = "420";
        char[] c = fourTwenty.toCharArray();
        System.out.println("Parse Int Test Character: " + MyInteger.parseInt(c));
        System.out.println("Parse Int Test String: " + MyInteger.parseInt(fourTwenty));
    }
    
    static void testPrime() {
        MyInteger x = new MyInteger(420);
        System.out.println("Prime Test: " + x.isPrime());
        System.out.println("(Static Prime Test)\nPrime numbers from 1 to 20:");
        for (int test = 1; test < 21; test++) {
            if (MyInteger.isPrime(test)) {System.out.println(test);}
        }
    }

}
