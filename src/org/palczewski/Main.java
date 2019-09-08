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

            System.out.println("Nifty interest calculator");
            System.out.printf("See the interest you could earn in one month.%n");
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
