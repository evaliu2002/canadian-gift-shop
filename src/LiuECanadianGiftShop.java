//
// On time
// Name: LIU EVA   date: Saturday, February 15, 2020 at 7:24:07 pm   Receipt: 1581
// Email: liuxiner02@gmail.com

// you did well: 10/10

import uwcse.io.Input; // use the MyInput class

import java.text.DecimalFormat; // to format the output

/**
 * Homework 3 <br>
 * Simulating a purchase in Canada paid in US dollars
 *
 * @author Eva Liu
 */

public class LiuECanadianGiftShop {

    // Constants
    /** Exchange rate 1 US dollar = RATE Canadian dollar */
    public final double RATE = 1.16;

    /** Price of a jar of maple syrup in Canadian dollars before taxes */
    public final double JAR_PRICE = 5.95;

    /**
     * Price of photograph of the city of Victoria in Canadian dollars before
     * taxes
     */
    public final double PHOTO_PRICE = 7.65;

    /** Price of a beaver hat in Canadian dollars before taxes */
    public final double HAT_PRICE = 16.35;

    /** Maximum allowed number of purchased items for each item */
    public final int MAX_ITEM = 100;

    /** Tax rate */
    public final double TAX_RATE = 0.093;

    // instance variables
    // number of purchased jars of maple syrup
    private int jarNumber;

    // number of purchased photographs of the city of Victoria
    private int photoNumber;

    // number of purchased beaver hats
    private int hatNumber;

    // 2 digits after the decimal point for doubles
    private DecimalFormat twoDigits = new DecimalFormat("0.00");

    // the price of items in US dollars
    private double x;
    private double y;
    private double z;

    // payUSD payCAD and costCAD
    private double payUSD;
    private double costCAD;
    private double payCAD;

    // change given after payment
    private double change;


    /**
     * Takes and processes the order from the customer
     */
    public void takeAndProcessOrder() {
        // Here is a possible series of steps: call some other (private)
        // methods to do each step.
        // Display the items and their prices
        itemList();
        // Get the Customer's order
        MyInput();
        // Get the user's USD payment
        changeinCAD(payUSD, costCAD);
        breakUpChange();
        // Give the change back in Canadian dollars

    }

    // Some ideas for some private methods
    // You don't have to use exactly these same methods.

    /**
     * Displays the items for sale and their prices in Canadian dollars
     */
    private void itemList() {
        // print welcome quote and displays items
        System.out.println("Welcome to Eva's Canadian Goods! \n");
        System.out.println("A Jar of Maple Syrup: " + JAR_PRICE + " CAD \n");
        System.out.println("Photograph of the City of Victoria: " + PHOTO_PRICE + " CAD \n");
        System.out.println("A Beaver Hat: " + HAT_PRICE + " CAD \n");
        System.out.println("The above prices don't include taxes. The tax rate is 9.30%. \n"
                + "Our exchange rate is 1 US dollar = 1.16 Canadian dollars \n");
    }

    /**
     * Gets the customer's order Precondition: none Postcondition: jarNumber,
     * photoNumber and hatNumber are initialized to a value between 0 and
     * MAX_ITEM
     */
    private void MyInput() {
        // user MyInput for buying items
        Input in = new Input();

        // read an integer from the keyboard and gives results based on MyInput
        this.jarNumber = in.readInt("How many jars of maple syrup? ");
        if (this.jarNumber > 100 || this.jarNumber < 0){
            System.out.println("You cannot buy this amount.\n");
            this.jarNumber = 0;
        } else if (this.jarNumber == 1) {
            System.out.println("You just bought " + this.jarNumber + " jar of maple syrup.\n");
        } else {
            System.out.println("You just bought " + this.jarNumber + " jars of maple syrup.\n");
        }

        // read an integer from the keyboard and gives results based on MyInput
        this.photoNumber = in.readInt("How many photos? ");
        if (this.photoNumber > 100 || this.photoNumber < 0) {
            System.out.println("You cannot buy this amount.\n");
            this.photoNumber = 0;
        } else if (this.photoNumber == 1) {
            System.out.println("You just bought " + this.photoNumber + " photo.\n");
        } else {
            System.out.println("You just bought " + this.photoNumber + " photos.\n");
        }

        // read an integer from the keyboard and gives results based on MyInput
        this.hatNumber = in.readInt("How many hats? ");
        if (this.hatNumber > 100 || this.hatNumber < 0) {
            System.out.println("You cannot buy this amount.\n");
            this.hatNumber = 0;
        } else if (this.hatNumber == 1) {
            System.out.println("You just bought " + this.hatNumber + " hat.\n");
        } else {
            System.out.println("You just bought " + this.hatNumber + " hats.\n");
        }
    }

    /**
     * Given a purchase in canadian dollars and a payment in US dollars,
     * displays the change amount in canadian dollars and cents
     *
     * @param payUSD
     *            payment in US dollars
     * @param costCAD
     *            purchase amount in Canadia dollars
     */
    private void changeinCAD(double payUSD, double costCAD) {
        // user MyInput
        Input in = new Input();

        // paid money in USD and cost of items in CAD
        this.payUSD = payUSD;
        this.costCAD = costCAD;

        // calculating total cost of items bought
        this.x = (this.jarNumber*JAR_PRICE);
        this.y = (this.photoNumber*PHOTO_PRICE);
        this.z = (this.hatNumber*HAT_PRICE);
        this.costCAD = (this.x + this.y + this.z)+((this.x + this.y + this.z)*TAX_RATE);
        System.out.println("Your purchase total is $" + twoDigits.format(this.costCAD)
                + " CAD (tax included).");

        // MyInput USD to pay for items and give change if valid
        this.payUSD = in.readDouble("Please, enter the US dollar amount to pay for it:  ");
        this.payCAD = (this.payUSD*RATE);
        System.out.println("You gave $" + twoDigits.format(this.payUSD) + " USD, which is $"
                + twoDigits.format(this.payCAD) + " CAD.");
        if (this.payCAD >= this.costCAD) {
            System.out.println("\nHere is your change: $"
                    + twoDigits.format((this.payCAD - this.costCAD)) + " CAD.");
            twoDigits.format(this.change = (this.payCAD - this.costCAD));
        } else {
            System.out.println("Sorry, this is not enough.");
            System.exit(0);
        }
    }

    /**
     * Break up change
     */
    private void breakUpChange() {
        // dollars, cents and how many of each bill/cents
        int dollars = 0;
        int cents = 0;
        int counts = 0;

        // spliting the change into dollar and cent amount
        dollars = (int) change;
        cents = (int) Math.round(((change-dollars)*100));

        /**
         * break up dollars to paper bills
         */
        //$20s
        counts = dollars/20;
        if (counts == 0 || counts > 1) {
            System.out.println(counts + " $20 bills");
            dollars = dollars - counts*20;
        } else if (counts == 1) {
            System.out.println(counts + " $20 bill");
            dollars = dollars - counts*20;
        }
        //$10s
        counts = dollars/10;
        if (counts > 1) {
            System.out.println(counts + " $10 bills");
            dollars = dollars - counts*10;
        } else if (counts == 1) {
            System.out.println(counts + " $10 bill");
            dollars = dollars - counts*10;
        }
        //$5s
        counts = dollars/5;
        if (counts > 1) {
            System.out.println(counts + " $5 bills");
            dollars = dollars - counts*5;
        } else if (counts == 1) {
            System.out.println(counts + " $5 bill");
            dollars = dollars - counts*5;
        }
        //$1s
        counts = dollars/1;
        if (counts > 1) {
            System.out.println(counts + " $1 bills");
            dollars = dollars - counts*1;
        } else if (counts == 1) {
            System.out.println(counts + " $1 bill");
            dollars = dollars - counts*1;
        }

        /**
         * break up cents to coins
         */
        //quarter
        counts = cents/25;
        if (counts > 1) {
            System.out.println(counts + " 25c coins");
            cents = cents - counts*25;
        } else if (counts == 1) {
            System.out.println(counts + " 25c coin");
            cents = cents - counts*25;
        }
        //dime
        counts = cents/10;
        if (counts > 1) {
            System.out.println(counts + " 10c coins");
            cents = cents - counts*10;
        } else if (counts == 1) {
            System.out.println(counts + " 10c coin");
            cents = cents - counts*10;
        }
        //nickel
        counts = cents/5;
        if (counts > 1) {
            System.out.println(counts + " 5c coins");
            cents = cents - counts*5;
        } else if (counts == 1) {
            System.out.println(counts + " 5c coin");
            cents = cents - counts*5;
        }
        //penny
        counts = cents/1;
        if (cents > 1) {
            System.out.println(cents + " 1c coins");
        } else if (cents == 1) {
            System.out.println(cents + " 1c coin");
        }

    }

    /**
     * Entry point of the program
     */
    public static void main(String[] args) {
        new LiuECanadianGiftShop().takeAndProcessOrder();
    }

}