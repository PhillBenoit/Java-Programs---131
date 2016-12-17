import java.math.BigInteger;

public class Drawing {
    
    public static final int TICKET_PRICE = 2;
    
    //This array is indexed by [powerball matches][number matches]
    public static final BigInteger[][] PRIZES = {
            {BigInteger.valueOf(0),BigInteger.valueOf(0),BigInteger.valueOf(0),BigInteger.valueOf(7),BigInteger.valueOf(100),BigInteger.valueOf(1000000)},
            {BigInteger.valueOf(4),BigInteger.valueOf(4),BigInteger.valueOf(7),BigInteger.valueOf(100),BigInteger.valueOf(50000),BigInteger.valueOf(100000000)}};
    
    //this formats the final column of the winnings display table based on the string size of the max value
    public static final String LINE = String.format(" %%d %%s correct%%s powerball = %%%ds",
            PRIZES[PRIZES.length-1][PRIZES[PRIZES.length-1].length-1].toString().length() + 1);
    
    //attempt at ANSI color codes
    public static final String ANSI_RESET = "\u001b[m0";
    public static final String ANSI_RED = "\u001b[m31";
    
    //draw number limits
    public static final int NUMBERS = 5;
    public final static int N_MIN = 1;
    public final static int N_MAX = 69;
    public final static int P_MIN = 1;
    public final static int P_MAX = 26;
    
    public final static String ARE = " numbers, followed by the Powerball Number, are:";
    public final static String WIN = "The winning lottery";
    public final static String TKT = "Your lottery ticket";
    
    static BigInteger runDrawing(int tickets){
        DrawSet winningNumbers = new DrawSet();
        printWinningNumbers(winningNumbers);
        BigInteger winnings = BigInteger.valueOf(0);
        System.out.println(TKT + ARE);
        for (int t = 0; t < tickets; t++) {
            DrawSet ticket = new DrawSet();
            winnings = winnings.add(printTicket(winningNumbers, ticket));
        }
        return winnings;
    }
    
    static void printWinningNumbers(DrawSet w){
        System.out.println("\n" + WIN + ARE);
        for (int step = 0; step < w.getNumbers().length; step++){
            printCell(Integer.toString(w.getNumbers()[step]));
        }
        System.out.print(" ");
        printRedCell(Integer.toString(w.getPowerball()));
        System.out.print("\n\n");
    }
    
    static void printCell(String s){
        System.out.format("%3s", s);
    }
    
    static void printRedCell(String s){
        System.out.format("%3s", s);
        //System.err.format("%3s", s);
    }
    
    //prints ticket and returns winnings based on matches found while printing
    static BigInteger printTicket(DrawSet w, DrawSet t){
        int[] matches = new int[2];
        
        for (int step = 0; step < w.getNumbers().length; step++) {
            if (w.ifExist(t.getNumbers()[step])) {
                matches[1]++;
                printRedCell(Integer.toString(t.getNumbers()[step]));
            } else {
                printCell(Integer.toString(t.getNumbers()[step]));
            }
        }
        System.out.print(" ");
        
        if (w.getPowerball() == t.getPowerball()) {
            printRedCell(Integer.toString(t.getPowerball()));
            matches[0] = 1;
        } else {
            printCell(Integer.toString(t.getPowerball()));
            matches[0] = 0;
        }
        
        if (PRIZES[matches[0]][matches[1]].intValue() != 0) {
            System.out.print(" You won $" + PRIZES[matches[0]][matches[1]].toString());
        }
        
        System.out.print("\n");
        return PRIZES[matches[0]][matches[1]];
    }
    
    //prize table
    static void displayPrizes() {
        String separator = "***********************************************";
        String[] num = {"numbers", "number "};
        String[] plus = {",  no", " plus"};
        System.out.println(separator);
        System.out.print("             Let's play Powerball!\n");
        //System.err.print("             Let's play Powerball!\n");
        System.out.println(separator);
        for (int n = PRIZES[0].length - 1; n >= 0; n--) {
            int numIndex = n == 1 ? 1 : 0;
            for (int p = PRIZES.length - 1; p >= 0; p--) {
                if (PRIZES[p][n].intValue() != 0) {
                    int plusIndex = p == 1 ? 1 : 0;
                    String line = String.format(LINE, n, num[numIndex], plus[plusIndex], "$" + PRIZES[p][n].toString());
                    System.out.println(line);
                }
            }
        }
        System.out.println(separator);
    }
        
}
