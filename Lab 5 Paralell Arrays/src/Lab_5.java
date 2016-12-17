/******************************************************************************
* Lab_5.java                                                                  *
* Created by: Phillip Benoit 10-24-16                                         *
* CIS 131 - Programming and Problem Solving II                                * 
* Pima Community College - Fall 2016                                          *
******************************************************************************* 
* Lab 5                                                                       *
* Payroll Generator                                                           *
*******************************************************************************
* This program generates payroll entries with a special class.                *
* It then displays the generated entries.                                     *
*******************************************************************************/

import java.text.DecimalFormat;

public class Lab_5 {
    
    static final int NUMBER_OF_EMPLOYEES = 6;
    static DecimalFormat moneyFormat = new DecimalFormat("$#0.00");
    static DecimalFormat hoursFormat = new DecimalFormat("#0.00");
    static final String TOP_HEADER = " PAYROLL REPORT ";
    static final String[][] COLUMN_HEADERS = {{"Employee","  Pay ","Hours","Regular","Overtime","Total "},
            {"Number"," Rate ","Worked","  Pay  ","  Pay  ","  Pay  "}};

    public static void main(String[] args) {
        IR.displayProgramInformation("Lab_5", "10-24-16", "Lab 5", "Payroll Generator",
                "This program generates payroll entries with a special class.",
                "It then displays the generated entries.");
        int[] empNo = new int[NUMBER_OF_EMPLOYEES];
        double[] payRate = new double[NUMBER_OF_EMPLOYEES];
        double[] hoursWorked = new double[NUMBER_OF_EMPLOYEES];
        double[] regularPay = new double[NUMBER_OF_EMPLOYEES];
        double[] overtimePay = new double[NUMBER_OF_EMPLOYEES];
        double[] totalPay = new double[NUMBER_OF_EMPLOYEES];
        generateEmployeeData(empNo, payRate, hoursWorked);
        double largestTotal = calculateTotals(payRate, hoursWorked, regularPay, overtimePay, totalPay);
        displayEmployeeList(empNo, payRate, hoursWorked, regularPay, overtimePay, totalPay, largestTotal);
        IR.displayEndOfProgram();
    }
    
    static double calculateTotals(double[] payRate, double[] hoursWorked, double[] regularPay,
            double[] overtimePay, double[] totalPay) {
        double largestTotal = -1;
        for (int step = 0; step < totalPay.length; step++) {
            regularPay[step] = PayrollEntry.getRegularPay(payRate[step], hoursWorked[step]);
            overtimePay[step] = PayrollEntry.getOvertimePay(payRate[step], hoursWorked[step]);
            totalPay[step] = PayrollEntry.getTotalPay(regularPay[step], overtimePay[step]);
            largestTotal = largestTotal < totalPay[step] ? totalPay[step] : largestTotal;
        }
        return largestTotal;
    }
    
    static void generateEmployeeData(int[] empNo, double[] payRate, double[] hoursWorked) {
        for (int step = 0; step < empNo.length; step++) {
            empNo[step] = PayrollEntry.generateEmpNo();
            payRate[step] = PayrollEntry.generatePayRate();
            hoursWorked[step] = PayrollEntry.generateHoursWorked();
        }
        removeDuplicates(empNo);
    }
    
    static void removeDuplicates(int[] list) {
        boolean retest;
        do {
            retest = false;
            for (int step = 0; step < list.length - 1; step++) {
                for (int compare = step + 1;compare < list.length; compare++) {
                    if (list[step] == list[compare]) {
                        list[compare] = PayrollEntry.generateEmpNo();
                        retest = true;
                    }
                }
            }
        } while (retest);
    }
    
    static void displayEmployeeList(int[] empNo, double[] payRate, double[] hoursWorked,
            double[] regularPay, double[] overtimePay, double[] totalPay, double largestTotal) {
        int cellWidth = moneyFormat.format(largestTotal).length() + 1;
        cellWidth = cellWidth < 9 ? 9 : cellWidth;
        displayHeader(cellWidth);
        for (int step = 0; step < empNo.length; step++) {
            displayCell(cellWidth, Integer.toString(empNo[step]));
            displayCell(cellWidth, moneyFormat.format(payRate[step]));
            displayCell(cellWidth, hoursFormat.format(hoursWorked[step]));
            displayCell(cellWidth, moneyFormat.format(regularPay[step]));
            displayCell(cellWidth, moneyFormat.format(overtimePay[step]));
            displayCell(cellWidth, moneyFormat.format(totalPay[step]));
            System.out.print("\n");
        }
    }
    
    static void displayHeader(int cellWidth) {
        String hyphens = String.format("%" + ((cellWidth*COLUMN_HEADERS[0].length)-TOP_HEADER.length())/2 + "s", "").replace(" ", "-");
        System.out.println(hyphens+TOP_HEADER+hyphens);
        
        for (int row = 0; row < COLUMN_HEADERS.length; row ++) {
            for (int column = 0; column < COLUMN_HEADERS[row].length; column++) {
                displayCell(cellWidth, COLUMN_HEADERS[row][column]);
            }
            System.out.print("\n");
        }
        
        hyphens = String.format("%" + (cellWidth-1) + "s", "").replace(" ", "-");
        for (int step = 0; step < COLUMN_HEADERS[0].length; step++) {
            displayCell(cellWidth, hyphens);
        }
        System.out.print("\n");
    }
    
    static void displayCell(int cellWidth, String text) {
        System.out.print(String.format("%" + cellWidth + "s", text));
    }
}
