
public class PayrollEntry {
    public int empNo;
    public double payRate, hoursWorked, regularPay, overtimePay, totalPay;
    
    static final int MINIMUM_ID = 1000;
    static final int MAXIMUM_ID = 9999;
    
    static final int MINIMUM_PAY_RATE = 14;
    static final int MAXIMUM_PAY_RATE = 40;
    static final double PAY_RATE_OFFSET=.5;
    
    static final int MINIMUM_HOURS_WORKED = 120;
    static final int MAXIMUM_HOURS_WORKED = 200;
    static final double HOURS_OFFSET=.25;
    static final double OVERTIME_LIMIT = 40;
    static final double OVERTIME_RATE=1.75;
    
    public PayrollEntry() {
        empNo = generateEmpNo();
        payRate = generatePayRate();
        hoursWorked = generateHoursWorked();
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
    
}
