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
    private final Map<LocalDate, Double> dailyBalance = new HashMap<>(31);
    private LocalDate startDate = null;
    private LocalDate endDate = null;
    private int cycle = 0;
    private double apr = 0.0;
    private Scanner in = null;

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
        System.out.printf("Average balance: %,10.2f%n", getAvgBal(dailyBalance));
        }
        
        private double getDailyRate(double apr) {
        // First convert apr to decimal
            double res = apr / 100;
            // Divide res by days of year to 
            // get Daily Rate
            return res / 365;
        }
        
        private double getAvgBal(Map dailyBalance) {
        // Process set to get average balance
            double sum = 0;
            dailyBalance.forEach((k, v) -> sum += (v));
            return sum / cycle;
        }
        
        

}


