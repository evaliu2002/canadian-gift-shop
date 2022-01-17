# http://flepeint.ccfaculty.org/java142/hw3.html
# Homework 3
In this assignment, you practice using methods and doing arithmetic in java.

You are planning a trip to Canada. Of course, you will stop by a gift shop to bring back some souvenirs to your family and friends. Canadian gift shops gladly accept US currency. However, they give you back your change in Canadian dollars. Curious about the transaction, you want to try different scenarios. Given an amount of US money, what can you buy? How much canadian money are you left with? A java program would be the perfect tool to answer all of your questions.

 

To make it simple, we will assume that the user only wants to buy any of the following items:

jar of maple syrup at $5.95 canadian dollars.
photograph of Victoria at  $7.65 canadian dollars.
beaver hat at  $16.35 canadian dollars.
These prices don't include taxes. The tax rate is 9.3%.

The customer can buy at the most 100 items of each.

To store all of these numbers use constants (see the sample file).

Your program should:

display a price list of the items for sale in canadian dollars (in the terminal window).
ask the user how many of each item he or she wants.
control the user input (it should be an integer between 0 and 100). If a number of items is not between 0 and 100, set it to 0.
ask the user to input the amount in US currency to pay for the purchase.
check that the user gave enough money. If not, say so to the user and end the program (to end a program use System.exit(0)).
display a receipt and the change amount in Canadian dollars and cents. Break up the change amount in 20, 10, 5 and 1 CA dollar bills and CA 25c, 10c, 5c and 1c coins (e.g. a change amount of $26.56 CA should be listed as one $20, one $5, one $1 bills and two 25c, one 5c and one 1c coins). Use proper spelling (1 10$ bill and not 1 10$ bills).
 

Try to break up the problem into simple tasks using methods. If you find yourself writing the same piece of code several times, put that piece of code in a method and call that method several times. If you find yourself writing a lot of code within one method, break up that code into several methods. It would be a mistake to write all of the code in takeAndProcessOrder. The sample file lists other methods that you might find helpful. You don't have to use exactly the same approach.

If any of your currency computation comes up with tenths of cents, round to the nearest cent, e.g. 100.242 becomes 100.24, 100.249 becomes 100.25, and 100.245 becomes 100.25.

Display all of the money amounts with 2 digits after the decimal point (use the class java.text.DecimalFormat).

Here is a code snippet that should help you:

/* don't forget the statement import java.text.DecimalFormat at the beginning of your code */

DecimalFormat twoDigits = new DecimalFormat("0.00");

double number=3.256;

System.out.println("number="+twoDigits.format(number)); /* displays number=3.26 */

Make sure that your program is readable by someone else than you. Style counts!!!

Write your program within the sample file provided, which gives a basic structure for your program. To run the code, just click the Run button within Eclipse.

Check this text file to compare your computations with some sample runs. Good luck!