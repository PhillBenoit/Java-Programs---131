/******************************************************************************
 * Lab_9.java                                                                  *
 * Created by: Phillip Benoit 11-26-16                                         *
 * CIS 131 - Programming and Problem Solving II                                * 
 * Pima Community College - Fall 2016                                          *
 ******************************************************************************* 
 * Lab 9                                                                       *
 * File Payroll Generator                                                      *
 *******************************************************************************
 * This program generates payroll entries with a special class.                *
 * It gets basic payroll info from a file.                                     *
 *******************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lab_9 {

    static final String SOURCE_FILE = "payroll.txt";
    
    static final String TOP_HEADER = " PAYROLL REPORT ";
    static final String[][] COLUMN_HEADERS = {{"Employee ","First   ","Last   ","Pay    ","Hours   ","Regular  ","Overtime  ","Total   "},
            {"Number  ","Name   ","Name   ","Rate   ","Worked  ","Pay    ","Pay    ","Pay    "}};
    static final int COLUMN_WIDTH = 12;

    public static void main(String[] args) {
        IR.displayProgramInformation("Lab_9", "11-26-16", "Lab 9", "File Payroll Generator",
                "This program generates payroll entries with a special class.",
                "It gets basic payroll info from a file.");
        ArrayList<PayrollEntry> payroll = getPayroll();
        printPayroll(payroll);
        IR.displayEndOfProgram();
    }

    static void printPayroll(ArrayList<PayrollEntry> payroll){
        printHeaders();
        for (PayrollEntry p : payroll) {
            System.out.println(p.toString(COLUMN_WIDTH));
        }
    }
    
    static void printHeaders(){
        String hyphens = String.format("%" + ((COLUMN_WIDTH*COLUMN_HEADERS[0].length)
                -TOP_HEADER.length())/2 + "s", "").replace(" ", "-");
        System.out.println(hyphens+TOP_HEADER+hyphens);
        
        for (int row = 0; row < COLUMN_HEADERS.length; row ++) {
            for (int column = 0; column < COLUMN_HEADERS[row].length; column++) {
                printCell(COLUMN_WIDTH, COLUMN_HEADERS[row][column]);
            }
            System.out.print("\n");
        }
        
        hyphens = String.format("%" + (COLUMN_WIDTH-1) + "s", "").replace(" ", "-");
        for (int step = 0; step < COLUMN_HEADERS[0].length; step++) {
            printCell(COLUMN_WIDTH, hyphens);
        }
        System.out.print("\n");
    }
    
    static void printCell(int cellWidth, String text) {
        System.out.print(String.format("%" + cellWidth + "s", text));
    }

    static ArrayList<PayrollEntry> getPayroll(){
        ArrayList<PayrollEntry> payroll = new ArrayList<PayrollEntry>();
        int lineCounter = 0;
        File input = new File(SOURCE_FILE);
        Scanner scan = tryFile(input);        
        while (scan.hasNextLine()) {
            lineCounter++;
            PayrollEntry lineEntry = tryEntry(scan, lineCounter);
            payroll.add(lineEntry);
            tryNextLine(scan);
        }
        scan.close();
        return payroll;
    }
    
    static void tryNextLine(Scanner s){
        try {
            s.nextLine();
        } catch (NoSuchElementException e) {
            System.err.println("Input not recognized.  Please add whitespace to the end of the last line." );
            s.close();
            System.exit(-1);
        }
    }

    static Scanner tryFile(File f){
        try {
            return new Scanner(f);
        } catch (FileNotFoundException e) {
            System.err.println("Input file was not found");
            System.exit(-1);
        }
        return null;
    }

    static PayrollEntry tryEntry(Scanner scan, int line){
        try {
            return new PayrollEntry(scan.nextInt(), scan.next(), scan.next(),
                    scan.nextDouble(), scan.nextDouble());
        } catch (InputMismatchException e) {
            System.err.println("Input not recognized.  Please check line " + line);
            scan.close();
            System.exit(-1);
        }
        return null;
    }

}
