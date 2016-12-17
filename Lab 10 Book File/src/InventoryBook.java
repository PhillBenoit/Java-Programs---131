import java.text.DecimalFormat;

public class InventoryBook {

    private String ISBN, title;             
    private double price;             
    private int yearPublished, quantityOnHand;

    public final static int MAX_TITLE_LENGTH = 30;
    public final static int MAX_ISBN_LENGTH = 13;

    //total byte size of one record
    public final static int RECORD_BYTES = (MAX_ISBN_LENGTH * 2) +
            (MAX_TITLE_LENGTH * 2) +
            (Double.BYTES) + //price
            (Integer.BYTES) + //year
            (Integer.BYTES); //quantity

    static final DecimalFormat moneyFormat = new DecimalFormat("$#0.00");

    public InventoryBook(){
        setISBN("");
        setTitle("");
        setPrice(0.0);
        setYearPublished(0);
        setQuantityOnHand(0);
    }

    public InventoryBook(String ISBN, String title, double price,
            int yearPublished, int quantityOnHand) {
        setISBN(ISBN);
        setTitle(title);
        setPrice(price);
        setYearPublished(yearPublished); 
        setQuantityOnHand(quantityOnHand);
    }

    public int getQuantityOnHand(){
        return quantityOnHand;
    }
    public void setQuantityOnHand(int quantityOnHand){
        this.quantityOnHand = quantityOnHand;
    }

    public int getYearPublished(){
        return yearPublished;
    }
    public void setYearPublished(int yearPublished){
        this.yearPublished = yearPublished;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        StringBuffer sb = new StringBuffer(title);
        if (sb.length() != MAX_TITLE_LENGTH){
            sb = padOrTrim(sb, MAX_TITLE_LENGTH);
        }
        this.title = sb.toString();
    }

    public String getISBN(){
        return ISBN;
    }
    public void setISBN(String ISBN){
        StringBuffer sb = new StringBuffer(ISBN);
        if (sb.length() != MAX_ISBN_LENGTH) {
            sb = padOrTrim(sb, MAX_ISBN_LENGTH);
        }
        this.ISBN = sb.toString() ;
    }

    public StringBuffer padOrTrim(StringBuffer sb, int correctLength){
        if (sb.length() > correctLength) sb.setLength(correctLength);
        if (sb.length() < correctLength) {
            while (sb.length() < correctLength) sb.append(' ');      
        }
        return sb;
    }

    public String toString() {
        return "=================================================\n" +
                "ISBN             : " + this.getISBN()                               + "\n" +
                "Title            : " + this.getTitle()                              + "\n" +
                "Year Published   : " + Integer.toString(this.getYearPublished() )   + "\n" +
                "Price            : " + moneyFormat.format(this.getPrice())          + "\n" +
                "Quantity on-hand : " + Integer.toString(this.getQuantityOnHand() )  + "\n" +
                "-------------------------------------------------";
    }

    public int bytes(){
        return RECORD_BYTES;
    }

}
