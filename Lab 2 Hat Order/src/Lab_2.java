/***************************************************************************************
* Lab_1.java                                                                           *
* Created by: Phillip Benoit 10-07-16                                                  *
* CIS 131 - Programming and Problem Solving II                                         * 
* Pima Community College - Fall 2016                                                   *
**************************************************************************************** 
* Lab 2                                                                                *
* Hat Ordering                                                                         *
****************************************************************************************
* This program generates an order for hats based off of a set schedule                 *
* of prices, discounts and a free shipping condition                                   *
****************************************************************************************/

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Lab_2 {
    //-----Initialize----------------------------------------------------------------------------------
    //formatting for money and percentages
    static DecimalFormat moneyFormat = new DecimalFormat("$#,##0.00");
    static NumberFormat percentFormat = NumberFormat.getPercentInstance(); 
    
    private static final float[] HAT_PRICE={4.5f,7f,9f};//price of each hat
    private static final String[] HAT_NAME={"Small","Medium","Large"};//name of each hat
    private static final float[] DISCOUNT_RATE={0f,0.1f,0.15f,0.2f};//rates of discount for multiple item purchases
    private static final float SHIPPING_MAX = 40f;//Minimum order total to qualify for free shipping
    
    //-------Main--------------------------------------------------------------------------------------
    public static void main(String[] args) {
        displayProgramInformation();
        Integer order[]=generateOrder();
        placeOrder(order);
    }
    
    //generates the integer array used to place the orders
    static Integer[] generateOrder() {
        Integer order[]={0,0,0};
        do {
            do {
                displayProducts(order);
                changeOrder(order);
            //loops while the user would like to change their order
            } while (IR4.getYorN("Would you like to change your order?"));
            //loops while the order array is empty
            if (order[0]==0 && order[1]==0 && order[2]==0) {System.out.println("Please order Something.");}
        } while (order[0]==0 && order[1]==0 && order[2]==0);
        return order;
    }
    
    //inputs used to change order values
    static void changeOrder(Integer[] order) {
        int productID = IR4.getIntegerBetweenLowAndHigh("Please enter a product ID:", 0, 2, "That is not a valid product ID.");
        int quantityToOrder = IR4.getIntegerBetweenLowAndHigh("How many would you like to buy?", 0, 99, "Invalid number of items.  Please contact us for bulk orders over 100.");
        order[productID]=quantityToOrder;
        displayProducts(order);
    }
    
    //-------Display Functions---------------------------------------------------------------------------------
    //displays product list and current order with subtotal
    static void displayProducts(Integer[] order) {
        float subtotal = 0.0f;
        int hatsOrdered=0;
        System.out.print("Our products come in sizes:");
        for (int index = 0;index<HAT_NAME.length;index++){
            printField(HAT_NAME[index]);
        }
        System.out.print("\n                Product ID:");
        for (Integer index = 0;index<HAT_NAME.length;index++){
            printField(" " + index.toString());
        }
        System.out.print("\n             Price per hat:");
        for (int index = 0;index<HAT_PRICE.length;index++){
            printField(moneyFormat.format(HAT_PRICE[index]));
        }
        System.out.print("\n          You have ordered:");
        for (int index = 0;index<HAT_NAME.length;index++){
            hatsOrdered+=order[index];
            printField(" " + order[index].toString());
        }
        System.out.print("  " + hatsOrdered);
        System.out.print("\n           Each hat totals:");
        for (int index = 0;index<HAT_PRICE.length;index++){
            printField(moneyFormat.format(HAT_PRICE[index]*order[index]));
            subtotal+=HAT_PRICE[index]*order[index];
        }
        System.out.print(" " + moneyFormat.format(subtotal) + "\n");
    }
    
    //displays and calculates final totals
    static void placeOrder(Integer[] order) {
        float subtotal = 0.0f;
        int hatsOrdered = 0;
        System.out.print("Our products come in sizes:");
        for (int index = 0;index<HAT_NAME.length;index++){
            printField(HAT_NAME[index]);
        }
        System.out.print("\n          You have ordered:");
        for (int index = 0;index<HAT_NAME.length;index++){
            printField(order[index].toString());
        }
        System.out.print("\n           Each hat totals:");
        for (int index = 0;index<HAT_PRICE.length;index++){
            printField(moneyFormat.format(HAT_PRICE[index]*order[index]));
            subtotal+=HAT_PRICE[index]*order[index];
            hatsOrdered+=order[index];
        }
        float discount = DISCOUNT_RATE[discountIndex(hatsOrdered)]*subtotal,
                netPurchase = subtotal - discount,
                shipping = netPurchase < SHIPPING_MAX ? 5f : 0f,
                total = netPurchase + shipping;
        System.out.print("\n              Hats ordered:");
        printField(Integer.toString(hatsOrdered));
        System.out.print("\n             Discount rate:");
        printField(percentFormat.format(DISCOUNT_RATE[discountIndex(hatsOrdered)]));
        System.out.print("\n                  Subtotal:");
        printField(moneyFormat.format(subtotal));
        System.out.print("\n                  Discount:");
        printField("(" + moneyFormat.format(discount) + ")");
        System.out.print("\n              Net Purchase:");
        printField(moneyFormat.format(netPurchase));
        System.out.print("\n                  Shipping:");
        printField(moneyFormat.format(shipping));
        System.out.print("\n                     Total:");
        printField(moneyFormat.format(total));
    }
    
    //formats one field for output
    static void printField(String s) {
        System.out.format(" %9s", s);
    }
    
    //returns index used for the static discount rate array
    static int discountIndex(int hats) {
        if (hats >= 10) {return 3;}
        if (hats >= 7) {return 2;}
        if (hats >= 4) {return 1;}
        return 0;
    }
    
    private static void displayProgramInformation() {
        System.out.println("****************************************************************************************");
        System.out.println("* Lab_2.java                                                                           *");
        System.out.println("* Created by: Phillip Benoit 10-07-16                                                  *");
        System.out.println("* CIS 131 - Programming and Problem Solving II                                         *"); 
        System.out.println("* Pima Community College - Fall 2016                                                   *");
        System.out.println("****************************************************************************************"); 
        System.out.println("* Lab 2                                                                                *");
        System.out.println("* Hat Ordering                                                                         *");
        System.out.println("****************************************************************************************"); 
        System.out.println("* This program generates an order for hats based off of a set schedule                 *");
        System.out.println("* of prices, discounts and a free shipping condition                                   *");
        System.out.println("****************************************************************************************");
        System.out.println("");
     }
}
