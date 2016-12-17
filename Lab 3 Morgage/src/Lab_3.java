/******************************************************************************
* Lab_3.java                                                                  *
* Created by: Phillip Benoit 10-15-16                                         *
* CIS 131 - Programming and Problem Solving II                                * 
* Pima Community College - Fall 2016                                          *
******************************************************************************* 
* Lab 3                                                                       *
* Mortgage Calculator                                                         *
*******************************************************************************
* This program generates mortgage payments based off of input                 *
* amount, term range and interest rate range                                  *
*******************************************************************************/

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Lab_3 {
    //-----Initialize----------------------------------------------------------------------------------
    //formatting for money and percentages
    static DecimalFormat moneyFormat = new DecimalFormat("$##,###,###.00");
    static DecimalFormat percentFormat = new DecimalFormat("%0.000");
    
    private static final int YEARS_STEP = 5;//number of years to add in each iteration of the years loop
    private static final int YEARS_MAX = 50;//Max years based on typical market products
    private static final int YEARS_STEP_MAX = YEARS_STEP*5;//Max years based on 6 columns worth of output
    
    private static final int INTEREST_STEP = 250;//amount to add each time through the interest rate loop measured in thousandths of a percent
    private static final int INTEREST_STATE_MAX = 10000;//Max interest rate based on Arizona state law measured in thousandths of a percent
    private static final int INTEREST_STEP_MAX = INTEREST_STEP*12;//max interest rate based on 12 lines of output
    
    //Minimum and maximum loan amounts based on typical market products
    private static final BigDecimal LOAN_MINIMUM = BigDecimal.valueOf(10000.0);
    private static final BigDecimal LOAN_MAXIMUM = BigDecimal.valueOf(45000000.0);
    
    //-------Main--------------------------------------------------------------------------------------
    public static void main(String[] args) {
        IR.displayProgramInformation("Lab_3", "10-15-16", "Lab 3", "Mortgage Calculator",
                "This program generates mortgage payments based off of input",
                "amount, term range and interest rate range");
        generateTable();
        System.out.println("\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'END OF PROGRAM\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'");
    }
    
    //-------Display Function---------------------------------------------------------------------------------
    //draws table based on constraints defined when variables are declared
    static void generateTable() {
        BigDecimal loanAmount = IR.getBDBetweenLowAndHigh("Please enter the loan amount: (" +
                moneyFormat.format(LOAN_MINIMUM) + " to " + moneyFormat.format(LOAN_MAXIMUM) + ")",
                LOAN_MINIMUM, LOAN_MAXIMUM, "Amount entered is out of range.");
        
        //interest rate assignments
        Double doubleInterest= IR.getDoubleBetweenLowAndHigh("Please enter a starting interest rate: (" +
                percentFormat.format(INTEREST_STEP/100000d) + " to " + percentFormat.format(INTEREST_STATE_MAX/100000d) + ")",
                INTEREST_STEP/1000d, INTEREST_STATE_MAX/1000d, "That intrest rate is not avalible.");
        //counverts to int in thousanths of a percent for concise loop stepping
        doubleInterest = doubleInterest * 1000;
        int minimumInterest = doubleInterest.intValue();
        //sets maximum interest rate based off the lower of output or legal constraints
        int maximumInterest=minimumInterest+INTEREST_STEP_MAX>INTEREST_STATE_MAX?INTEREST_STATE_MAX:minimumInterest+INTEREST_STEP_MAX;
        //redefines maximum using user input
        doubleInterest=IR.getDoubleBetweenLowAndHigh("Please enter the ending interest rate: (" +
                percentFormat.format(minimumInterest/100000d) + " to " + percentFormat.format(maximumInterest/100000d) + ")",
                minimumInterest/1000d, maximumInterest/1000d, "That intrest rate is not avalible.");
        //counverts to int in thousanths of a percent for concise loop stepping
        doubleInterest = doubleInterest * 1000;
        maximumInterest = doubleInterest.intValue();
        int stepInterest=minimumInterest;//this is the stepping variable tested and modified by the loop
        
        //term assignments
        int minimumTerm = IR.getIntegerBetweenLowAndHigh("Please enter the first term length: (in years " +
                YEARS_STEP + " to " + YEARS_MAX + ")", YEARS_STEP, YEARS_MAX,
                "That number of years is not avalible.");
        //sets maximum years based off the lower of output or market constraints
        int maximumTerm=minimumTerm+YEARS_STEP_MAX>YEARS_MAX?YEARS_MAX:minimumTerm+YEARS_STEP_MAX;
        //redefines maximum using user input
        maximumTerm=IR.getIntegerBetweenLowAndHigh("Please enter the final term length: (in years " +
                minimumTerm + " to " + maximumTerm + ")", minimumTerm, maximumTerm,
                "That number of years is not avalible.");
        int stepTerm = minimumTerm;//this is the stepping variable tested and modified by the loop
        
        //This first loop prints column headers
        printCell("Interest");
        do {
            printCell(stepTerm + " Years");
            //this pair of if statement assignments allows the loop to run to the maximum without going over
            stepTerm=stepTerm==maximumTerm?0:stepTerm+YEARS_STEP;
            stepTerm=stepTerm>maximumTerm?maximumTerm:stepTerm;
        } while (stepTerm!=0);
        
        System.out.print("\n");//completes line from header loop
        stepTerm = minimumTerm;//resets years for next loop
        
        do {//start of interest rate loop
            printCell(percentFormat.format(stepInterest/100000d));
        
            do {//start of term loop
                //gets annuity factor, multiplies by loan amount, formats it to money string then prints the cell
                printCell(moneyFormat.format(loanAmount.multiply(getAnnuityFactor(stepInterest/1200000d,stepTerm*12))));
                //this pair of if statement assignments allows the loop to run to the maximum without going over
                stepTerm=stepTerm==maximumTerm?0:stepTerm+YEARS_STEP;
                stepTerm=stepTerm>maximumTerm?maximumTerm:stepTerm;
            } while (stepTerm!=0);
            
            System.out.print("\n");//completes line from term loop
            stepTerm = minimumTerm;//resets years for next loop
            //this pair of if statement assignments allows the loop to run to the maximum without going over
            stepInterest=stepInterest==maximumInterest?0:stepInterest+INTEREST_STEP;
            stepInterest=stepInterest>maximumInterest?maximumInterest:stepInterest;
        } while (stepInterest!=0);
    }
    
    //-------Utility Functions--------------------------------------------------------
    //algorithm for calculating annuity factor
    static BigDecimal getAnnuityFactor(double intrestRate,int term) {
        double numerator = 1d + intrestRate;
        numerator = Math.pow(numerator, term);
        numerator = numerator * intrestRate;
        
        double denominator = 1d+intrestRate;
        denominator = Math.pow(denominator, term);
        denominator -= 1d;
        
        return BigDecimal.valueOf(numerator/denominator);
    }
    
    //prints one cell
    static void printCell(String cellText) {
        System.out.format(" %11s", cellText);
    }
}
