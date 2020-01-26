package org.palczewski;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ConsoleLoop {


    public static void main(String[] args) {
        /*
        Building a loop to take in daily balances, summing them up and
        returning an avg.
         */
        // try block
        try (Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {
            System.out.println("\t=== Daily Balances entry ===");
            System.out.println("Enter each day's balance for the billing period:");
            System.out.println();
            System.out.print("Enter begin date: ");

            LocalDate beginDate = LocalDate.parse(in.nextLine());
            int cycle = beginDate.lengthOfMonth();

            LocalDate endDate = beginDate.plus(cycle, ChronoUnit.DAYS);
            System.out.print("Enter APR: ");
            double apr = in.nextDouble();

            System.out.printf("Period is from: %s to %s%n",
                    beginDate, (endDate.minus(1, ChronoUnit.DAYS)));
            // TODO: 1/26/20 Change code to not use Period, simplify this like APY or Amortized classes.
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
            double avgBal = sum / cycle;
            double intRate = apr / 100;
            double dailyRate = intRate / 365;
            System.out.printf("Average balance: %.2f%n", avgBal);
            System.out.printf("Expected interest: %.2f%n",
                    (avgBal * dailyRate) * cycle);




        }
    }
}
