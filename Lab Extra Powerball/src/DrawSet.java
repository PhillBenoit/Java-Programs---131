import java.util.Arrays;

public class DrawSet {
    
    private int[] number = new int[Drawing.NUMBERS];
    
    //boolean array keeps track of what numbers have been drawn to avoid duplicates
    //used for generating numbers and comparing winning numbers
    private boolean[] exist = new boolean[Drawing.N_MAX+1];
    
    private int powerball;
    
    public DrawSet() {
        for (int n = 0; n < number.length; n++) {
            int random = IR.getRandomNumber(Drawing.N_MIN, Drawing.N_MAX);
            while (exist[random]) {random = IR.getRandomNumber(Drawing.N_MIN, Drawing.N_MAX);}
            exist[random] = true;
            number[n] = random;
        }
        Arrays.sort(number);
        powerball = IR.getRandomNumber(Drawing.P_MIN, Drawing.P_MAX);
    }
    
    public boolean ifExist(int index){
        return exist[index];
    }
    
    public int[] getNumbers(){
        return number;
    }
    
    public int getPowerball(){
        return powerball;
    }
    
}
