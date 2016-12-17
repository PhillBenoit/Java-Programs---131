public class MyInteger {
        
    private int value;

    public MyInteger() {
        value = 0;
    }

    public MyInteger(int i) {
        value = i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public boolean isEven() {
        return isEven(value);
    }
    
    public boolean isOdd() {
        return isOdd(value);
    }
    
    public static boolean isEven(int i) {
        boolean returnBoolean = false;
        if (i % 2 == 0) {returnBoolean = true;}
        return returnBoolean;
    }
    
    public static boolean isOdd(int i) {
        boolean returnBoolean = false;
        if (i % 2 == 1) {returnBoolean = true;}
        return returnBoolean;
    }
    
    public boolean equals(int i) {
        boolean returnBoolean = false;
        if (value == i) {returnBoolean = true;}
        return returnBoolean;
    }
    
    public boolean equals(MyInteger i) {
        return equals(i.getValue());
    }
    
    public static int parseInt(char[] c) {
        return parseInt(String.valueOf(c));
    }
    
    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }
    
    public boolean isPrime() {
        return isPrime(value);
    }
    
    public static boolean isPrime(int i) {
        boolean returnBoolean = i < 2 ? false : true;
        for (int step = 2; (step * 2) < (i+1); step++) {
            if (i % step == 0) {return false;}
        }
        return returnBoolean;
    }

}
