package org.palczewski;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        System.out.print("Enter a daily balance: ");
        dailyBalance.put(startDate, in.nextDouble());
        System.out.printf("The APR is %2.2f%n", apr);
    }

}
