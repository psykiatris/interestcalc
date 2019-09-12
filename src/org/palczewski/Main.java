package org.palczewski;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        Why I use the Scanner object: it allows you to process console
        functions within the IDE. If you use java.console, the IDE can't
         run it properly. You have to build the JAR and run it from the
         terminal.
         */
        try (Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {

            System.out.println("\tNifty interest calculator");
            System.out.printf("Calculates interest earned or charged%non a bank savings or credit card account.%n");
            System.out.printf("\tEnter an option:%n\t%2d - %-11s%n\t%2d - %-11s%n\t%2d - %-11s%n", 1, "Savings", 2, "Credit Card", 9, "Quit");

            int choice = 0;
            boolean flag = true;
            // Process the choice
            do {
                System.out.print("Make a choice: ");
                choice = in.nextInt();
                if(choice == 1) {
                    System.out.println("You chose Savings");
                    flag = false;

                } else if (choice == 2) {
                    System.out.println("You chose Credit Card");
                    flag = false;
                } else if (choice == 9) {
                    System.out.println("Exiting");
                    System.exit(0);
                } else {
                    System.out.println("You did not make a valid choice");
                }
            } while (flag);
            System.out.print("Enter month:  ");
            int month = in.nextInt();
            System.out.print("Enter year: ");
            int year = in.nextInt();
            System.out.print("Enter balance: ");
            double balance = in.nextDouble();
            System.out.print("Enter interest rate: ");
            double intRate = in.nextDouble();

            // TODO: 9/8/19 Change Scanner to a multiple choice for different functions.
            new CompoundInterestCalculator(balance, intRate, year, month);



        }

    }
}
