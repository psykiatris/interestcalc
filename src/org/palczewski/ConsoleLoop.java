package org.palczewski;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleLoop {
    private final Map<String, Double> dailyBalance = new HashMap<>(30);

    public static void main(String[] args) {
        /*
        Building a loop to take in daily balances, summing them up and
        returning an avg.
         */
        // try block
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("\tGet daily balances for month.");
            System.out.println("Enter each day's balance for the billing period:");
            System.out.println();
            System.out.print("Enter begin date:");
            LocalDate beginDate = LocalDate.parse(in.nextLine());
            LocalDate cyclePeriod = beginDate.plus(30, ChronoUnit.DAYS);
            System.out.printf("Statment cycle is: %s thru %s%n",
                    beginDate, cyclePeriod);

        }
    }
}
