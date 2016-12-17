import java.text.DecimalFormat;

public class PayrollEntry {
    private int empNo;
    private double payRate, hoursWorked, regularPay, overtimePay, totalPay;
    private String firstName, lastName;

    static final int MINIMUM_ID = 1000;
    static final int MAXIMUM_ID = 9999;

    static final int MINIMUM_PAY_RATE = 14;
    static final int MAXIMUM_PAY_RATE = 40;
    static final double PAY_RATE_OFFSET=.5;

    static final int MINIMUM_HOURS_WORKED = 120;
    static final int MAXIMUM_HOURS_WORKED = 200;
    static final double HOURS_OFFSET=.25;

    static final double OVERTIME_LIMIT = 40;
    static final double OVERTIME_RATE=1.5;
    
    static final DecimalFormat moneyFormat = new DecimalFormat("$#0.00");
    static final DecimalFormat hoursFormat = new DecimalFormat("#0.00");

    public PayrollEntry() {
        empNo = generateEmpNo();
        payRate = generatePayRate();
        hoursWorked = generateHoursWorked();
        regularPay = getRegularPay(payRate, hoursWorked);
        overtimePay = getOvertimePay(payRate, hoursWorked);
        totalPay = getTotalPay(regularPay, overtimePay);
    }

    public PayrollEntry(String[] a) {
        empNo = Integer.parseInt(a[0]);
        firstName = a[1];
        lastName = a[2];
        hoursWorked = Double.parseDouble(a[3]);
        payRate = Double.parseDouble(a[3]);
        regularPay = getRegularPay(payRate, hoursWorked);
        overtimePay = getOvertimePay(payRate, hoursWorked);
        totalPay = getTotalPay(regularPay, overtimePay);
    }

    public PayrollEntry(int id, String last, String first, double hours, double wage) {
        empNo = id;
        firstName = first;
        lastName = last;
        hoursWorked = hours;
        payRate = wage;
        regularPay = getRegularPay(payRate, hoursWorked);
        overtimePay = getOvertimePay(payRate, hoursWorked);
        totalPay = getTotalPay(regularPay, overtimePay);
    }

    public static int generateEmpNo() {
        return IR.getRandomNumber(MINIMUM_ID, MAXIMUM_ID);
    }

    public static double generatePayRate() {
        return IR.getRandomNumber(MINIMUM_PAY_RATE, MAXIMUM_PAY_RATE) * PAY_RATE_OFFSET;
    }

    public static double generateHoursWorked() {
        return IR.getRandomNumber(MINIMUM_HOURS_WORKED, MAXIMUM_HOURS_WORKED) * HOURS_OFFSET;
    }

    public static double getRegularPay(double payRate, double hoursWorked) {
        hoursWorked = hoursWorked > OVERTIME_LIMIT ? OVERTIME_LIMIT : hoursWorked;
        return hoursWorked * payRate;
    }

    public static double getOvertimePay(double payRate, double hoursWorked) {
        hoursWorked = hoursWorked < OVERTIME_LIMIT ? 0 : hoursWorked - OVERTIME_LIMIT;
        return hoursWorked * payRate * OVERTIME_RATE;
    }

    public static double getTotalPay(double regularPay, double overtimePay) {
        return regularPay + overtimePay;
    }
    
    public String toString(int width){
        String returnString = "";
        returnString += returnCell(width, Integer.toString(empNo));
        int strLen = firstName.length() > width-1 ? width-1 : firstName.length();
        returnString += returnCell(width, firstName.substring(0, strLen));
        strLen = lastName.length() > width-1 ? width-1 : lastName.length();
        returnString += returnCell(width, lastName.substring(0, strLen));
        returnString += returnCell(width, moneyFormat.format(payRate));
        returnString += returnCell(width, hoursFormat.format(hoursWorked));
        returnString += returnCell(width, moneyFormat.format(regularPay));
        returnString += returnCell(width, moneyFormat.format(overtimePay));
        returnString += returnCell(width, moneyFormat.format(totalPay));
        return returnString;
    }
    
    static String returnCell(int cellWidth, String text) {
        return String.format("%" + cellWidth + "s", text);
    }

}
