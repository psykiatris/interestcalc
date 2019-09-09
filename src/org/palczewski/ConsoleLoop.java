package org.palczewski;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
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
            System.out.print("Enter begin date: ");
            int cycle = 30;
            LocalDate beginDate = LocalDate.parse(in.nextLine());
            LocalDate endDate = beginDate.plus(cycle, ChronoUnit.DAYS);
            System.out.print("Enter APR: ");
            double apr = in.nextDouble();

            System.out.printf("Period is from: %s to %s%n",
                    beginDate, (endDate.minus(1, ChronoUnit.DAYS)));
            Period cyclePeriod = Period.between(beginDate, endDate);
            System.out.printf("Days in cycle: %s%n",
                    cyclePeriod.getDays());
            // Unexpected behavior forces me to subtract 1 day
            // to get this to display corectly
            // loop works as expected.


            // Begin loop
            // Need to advance days manually
            double sum = 0;
            for(int i = 1; i <= cycle; i++) {
                System.out.printf("%s : ", beginDate);
                sum += in.nextDouble();
                beginDate = beginDate.plus(1, ChronoUnit.DAYS);
            }
            double avgBal = sum / 30;
            double intRate = apr / 100;
            double dailyRate = intRate / 365;
            System.out.printf("Average balance: %.2f%n", avgBal);
            System.out.printf("Expected interest: %.2f%n",
                    (avgBal * dailyRate) * cycle);




        }
    }
}
