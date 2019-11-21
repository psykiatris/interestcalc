package org.palczewski;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/*
Consolicate ConsoleLoop and CompundInterest classes into one for
simplicity.

This will be the main function to be called from Main, passing the
parameters. Will add other methods as needed
 */
public class InterestCalculator {

    // Map to store date and daily balance.
    private final Map<LocalDate, Double> dailyBalance =
            new LinkedHashMap<>(31);
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int cycle;
    private final double apr;
    private final Scanner in;

    InterestCalculator(Scanner in, LocalDate startDate,
                       LocalDate endDate,int cycle,
                       double apr) {

        this.in = in;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cycle = cycle;
        this.apr = apr;

        // input figures
        System.out.printf("Begin entering each day's balance for the period.%n");
        LocalDate start = startDate;
        for(int i = 1; i <= cycle; i++) {
            System.out.printf("%s : ", start);
            dailyBalance.put(start, in.nextDouble());
            start = start.plus(1, ChronoUnit.DAYS);
        }
        System.out.println();
        double avgBalance = getAvgBal(dailyBalance);
        System.out.printf("Average balance: $%,10.2f%n",
                avgBalance);
        System.out.printf("Interest earned/charged: $%,4.2f%n",
                computeInterest(apr, avgBalance));
        System.out.println();
        // Choice to display table
        System.out.print("Display table? [Y|n] ");
        String option = in.next();
        if ("Y".equals(option)) {
            displayTable();
        } else if ("n".equals(option)) {
            System.out.println("Exiting");
        } else {
            throw new IllegalStateException(String.format("Unexpected value: %s", option));
        }


    }

    private void displayTable() {
        // iterate map showing entries
        System.out.println();
        System.out.printf("%-10s %14s%n", "Date", "Balance");
        System.out.println("=".repeat(25));
        for (Map.Entry<LocalDate, Double> entry : dailyBalance.entrySet()) {
            System.out.printf("| %1$tm-%1$td-%tY $%,9.2f |%n",
                    entry.getKey(), entry.getValue());
            System.out.println("-".repeat(25));


        }

    }


        
        private double getDailyRate(double apr) {
        // First convert apr to decimal
            double res = apr / 100;
            // Divide res by days of year to 
            // get Daily Rate
            return res / 365;
        }
        
        private double getAvgBal(Map<LocalDate, Double> dailyBalance) {
        // Iterate map to sum values
            double sum = 0;

            for (Map.Entry<LocalDate, Double> entry : dailyBalance.entrySet()) {
                sum += entry.getValue();

            }
            return sum / cycle;
        }

        private double computeInterest(double apr, double avgBal) {
        double dailyRate = getDailyRate(apr);
        return (avgBal * dailyRate) * cycle;

        }


    @Override
    public final String toString() {
        return String.format("InterestCalculator{dailyBalance=%s, startDate=%s, endDate=%s, cycle=%d, apr=%s, in=%s}", dailyBalance, startDate, endDate, cycle, apr, in);
    }
}


