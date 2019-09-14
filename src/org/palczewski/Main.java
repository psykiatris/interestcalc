package org.palczewski;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
/*
This is the main entry for the program, which calculates interest based
on the cycle period, APR and daly balance. Credit card and savings work
the same way. The only difference is the length of the cycle period.
    Credit cards have 30 day cycles that begin on a particular day.
    Savings accounts have differnet days (28, 29, 30 or 31 days in their
     cycle).
So, the user choosed an option, which will determine the cycle and pass
the information to the actual function, which is very simple.
 */
public class Main {

    public static void main(String[] args) {

        /*
        Why I use the Scanner object: it allows you to process console
        functions within the IDE. If you use java.console, the IDE can't
         run it properly. You have to build the JAR and run it from the
         terminal.
         */
        try (Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {

            System.out.println("\tBoyd Interest Calculator");
            System.out.printf("Calculates interest earned or charged%non a bank savings or credit card account.%n");
            System.out.printf("\tEnter an option:%n\t%2d - %-11s%n\t%2d - %-11s%n\t%2d - %-11s%n", 1, "Savings", 2, "Credit Card", 9, "Quit");

            int choice = 0;
            // Params o pass to function
            LocalDate startDate;
            int cycle = 0;
            double apr = 0;
            boolean flag = true;
            // Process the choice
            do {
                System.out.print("Make a choice: ");
                choice = in.nextInt();
                if(choice == 1) {
                    System.out.print("You chose Savings\r");

                    System.out.println();
                    // Get more info from user
                    System.out.print("Enter start of month: ");
                    startDate = LocalDate.parse(in.next());
                    int year = startDate.getYear();
                    int month = startDate.getMonthValue();
                    YearMonth ym = YearMonth.of(year, month);
                    cycle = ym.lengthOfMonth();
                    LocalDate endDate = startDate.plus(cycle -1,
                            ChronoUnit.DAYS);
                    System.out.printf("Statement period: %1$tm-%1$td-%1$tY to %2$tm-%2$td-%2$tY%n",
                            startDate, endDate);
                    System.out.printf("Cycle is %d days.%n", cycle);
                    System.out.print("Now enter the APR: ");
                    apr = in.nextDouble();
                    System.out.printf("Using an APR of %2.2f%%%n", apr);
                    // Now the info is collected, pass to function



                    flag = false;

                } else if (choice == 2) {
                    System.out.println("You chose Credit Card");
                    System.out.println();
                    // Get more info from user
                    System.out.print("Enter statement start date: ");
                    startDate = LocalDate.parse(in.next());
                    cycle = 30;
                    LocalDate endDate = startDate.plus(cycle -1,
                            ChronoUnit.DAYS);
                    System.out.printf("Cycle period: %1$tm-%1$td-%1$tY " +
                                    "to " +
                                    "%2$tm-%2$td-%2$tY%n",
                            startDate, endDate);
                    System.out.printf("Cycle: %d days.%n", cycle);
                    System.out.print("Enter the APR: ");
                    apr = in.nextDouble();
                    System.out.printf("Using APR of %2.2f%%%n", apr);
                    flag = false;
                } else if (choice == 9) {
                    System.out.println("Exiting chice menu.");
                    System.exit(0);
                } else {
                    System.out.println("You did not make a valid choice");
                }
            } while (flag);

            // Finsihing up.
            System.out.println();
            System.out.println("Thank you for using Boyd Calculator!");

        }

    }
}
