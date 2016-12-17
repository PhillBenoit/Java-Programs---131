/***************************************************************************************
* Lab_1.java                                                                           *
* Created by: Phillip Benoit 9-23-16                                                   *
* CIS 131 - Programming and Problem Solving II                                         * 
* Pima Community College - Fall 2016                                                   *
**************************************************************************************** 
* Lab 1                                                                                *
* Parking Garage                                                                       *
****************************************************************************************
* This program generates a receipt for parking fees based off of                        *
* inputs for parking times and a preset fee schedule                                   *
****************************************************************************************/

import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab_1 {
    //-----Initialize----------------------------------------------------------------------------------
    //leading 0 format to check time
    static DecimalFormat timeFormatter = new DecimalFormat("0000");
    //money formatting for printing rate charged and total
    static DecimalFormat moneyFormatter = new DecimalFormat("$##.00");

    private static Scanner input = new Scanner(System.in);

    //Stated constants for calculating totals
    public static final float[] RATE={.5f,1.25f,1.25f,1.25f,1.25f,1.25f,.5f};
    public static final float[] MAXIMUM_FEE={15,20,20,20,20,20,15};
    public static final float[] MINIMUM_FEE={2,3,3,3,3,3,2};
    
    //-------Main--------------------------------------------------------------------------------------
    public static void main(String[] args) {
        displayProgramInformation();
        ChargesData customer = new ChargesData();
        printReceipt(customer);
        System.out.println("\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'END OF PROGRAM\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'");
    }

    static void printReceipt(ChargesData customer) {
        System.out.println("            Day of the week: " + customer.dayFromInput);
        System.out.println("Parking duration in minutes: " + customer.duration);
        System.out.println("               Rate charged: " + customer.rateCharged);
        System.out.println("       Total amount charged: " + customer.total);
    }

    //-----Charges Data Class--------------------------------------------------------------------------
    public static class ChargesData {
        //class stores string data used for printing a receipt
        String dayFromInput, duration, rateCharged, total;

        public ChargesData() {
            //set local variables for calculating
            int duration, dayIndex=-1;
            float total;

            //loop gets input until a valid day is found
            do {
                System.out.println("(sun, mon, tue, wed, thu, fri, sat) (su, m, t, w, th, f, sa)");
                System.out.print("Please enter a day of the week: ");
                dayFromInput=input.nextLine();
                switch (dayFromInput.toLowerCase()) {
                case "sunday":
                case "sun": 
                case "su":  dayIndex=0;
                            System.out.println("You entered Sunday.");
                            break;
                case "monday":
                case "mon": 
                case "m":   dayIndex=1;
                            System.out.println("You entered Monday.");
                            break;
                case "tuesday":
                case "tue": 
                case "t":   dayIndex=2;
                            System.out.println("You entered Tuesday.");
                            break;
                case "wednesday":
                case "wed": 
                case "w":   dayIndex=3;
                            System.out.println("You entered Wednesday.");
                            break;
                case "thursday":
                case "thu": 
                case "th":  dayIndex=4;
                            System.out.println("You entered Thursday.");
                            break;
                case "friday":
                case "fri": 
                case "f":   dayIndex=5;
                            System.out.println("You entered Friday.");
                            break;
                case "saturday":
                case "sat": 
                case "sa":  dayIndex=6;
                            System.out.println("You entered Saturday.");
                            break;
                default:    System.out.println("You did not enter a valid day.");
                            break;
                }
            } while (dayIndex==-1);
            //rate charged assigned using money formatter, constant RATE and dayIndex
            rateCharged = moneyFormatter.format(RATE[dayIndex]);

            int startTime = getTime("Please enter the vehicle\u0027s arrival time(HHMM): ");
            int endTime = getTime("Please enter the vehicle\u0027s departure time(HHMM): ");

            if (startTime<endTime){
                duration=endTime-startTime;
            } else {
                //inverted time calculation for start times that occur after end times
                duration=1440-(startTime-endTime);
            }
            this.duration = Integer.toString(duration);

            total = RATE[dayIndex] * round(duration);
            //sets total to minimum or maximum
            if (total > MAXIMUM_FEE[dayIndex]) {
                total = MAXIMUM_FEE[dayIndex];
            } else if (total < MINIMUM_FEE[dayIndex]) {
                total = MINIMUM_FEE[dayIndex];
            }
            this.total = moneyFormatter.format(total);
        }
    }
    
    //--------Utility Methods-------------------------------------------------------------------------
    static int getTime(String request) {
        String inputString;
        do {
            do {
                System.out.print(request);
                inputString=input.nextLine();
                //tests for integer value
            } while (intTry(inputString));
            //use time format to separate hours from minutes
            inputString = timeFormatter.format(Integer.parseInt(inputString));
            if (Integer.parseInt(inputString)<0|Integer.parseInt(inputString)>2359|Integer.parseInt(inputString.substring(2))>59) {System.out.println("Not a valid time.");}
        //execute loop until valid time constraints are found 
        } while (Integer.parseInt(inputString)<0|Integer.parseInt(inputString)>2359|Integer.parseInt(inputString.substring(2))>59);
        //return time in minutes after midnight
        return (Integer.parseInt(inputString.substring(0, 2))*60)+Integer.parseInt(inputString.substring(2));
    }

    //checks string for integer value
    static boolean intTry(String test){
        try{
            Integer.parseInt(test);
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Not a valid Number");
            return true;
        }
    }

    //rounds up time to fill 15 minute increments
    static int round(int time) {
        if (time % 15 == 0) {
            return time / 15;
        } else {
            return (time / 15) + 1;
        }
    }
    
    private static void displayProgramInformation() {
        System.out.println("****************************************************************************************");
        System.out.println("* Lab_1.java                                                                           *");
        System.out.println("* Created by: Phillip Benoit 9-23-16                                                   *");
        System.out.println("* CIS 131 - Programming and Problem Solving II                                         *"); 
        System.out.println("* Pima Community College - Fall 2016                                                   *");
        System.out.println("****************************************************************************************"); 
        System.out.println("* Lab 1                                                                                *");
        System.out.println("* Parking Garage                                                                       *");
        System.out.println("****************************************************************************************"); 
        System.out.println("* This program generates a receipt for parking fees based off of                       *");
        System.out.println("* inputs for parking times and a preset fee schedule                                   *");
        System.out.println("****************************************************************************************");
        System.out.println("");
     }

}