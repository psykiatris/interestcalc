package org.palczewski.process;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;


/**
Calculates amoritzed payments for loans, mortgages and credit cards
 @author Patrick Palczewski - psykiatris@gmail.com
 @version .99
 */
class Amortized {

    /**
     * Holds the accumulated interest.
     */
    private double accumInt = 0.0;
    private static final String usd =
            Currency.getInstance(Locale.getDefault()).getSymbol();

    /**
     * Creates an object of princi]al, rate &amp; period
     * @param p Principal balance
     * @param rate Annual Percentage Rate
     * @param periods Months in period
     *
     */
    private Amortized(double p, double rate, double periods) {

        double moInt;
        moInt = (rate == 0) ? 0.0 : (rate / (12 * 100));
        double payment;

        payment = (moInt == 0) ? (p / periods) : (p * (moInt / (1 - (StrictMath.pow(1 / (1 + moInt), periods)))));

        // print table
        viewAmortizationSchedule(p, rate, LocalDate.now(),

                toMonths(periods), payment);
        System.out.println("\t=== Payment Summary ===");
        String text = (periods <= 1) ? APY.MONTH : APY.MONTHS;
        System.out.printf("Based on principal of %s%,.2f for %.0f %s,%nat %.3f%%, your montly payments would be  %s%,.2f.%n", usd,
                p, periods, text, rate, usd, payment);
        System.out.printf("Interest paid for this period: %s%,.2f%n", usd,
                accumInt);


    }

    /**
     * Converts years to months
     * @param period Number of years
     * @return Number of months
     */
    private double toMonths(double period) {
        return period / 12;
    }

    /**
     * Displays amortization schedule in a readable table
     * @param prin principal balance
     * @param rate interest rate
     * @param startDate start date of period
     * @param years term in years
     * @param pmt calculated principal and interest payment
     */
    private void viewAmortizationSchedule(double prin, double rate,
                                      LocalDate startDate, double years,
                                      double pmt) {
        // Change interest to decimal format
        LocalDate date = startDate;
        double v = prin;
        double moRate = rate / (12 * 100);
        double period = years * 12;

        System.out.println("\t=== Amortization Table ===");
        // Loop to display table
        for(int i = 0; i < period; i++) {
            double moInterest = v * moRate;
            double newPrin = pmt - moInterest;

            accumInt += moInterest;
            double newBal = v - newPrin;
            System.out.printf("%1$tb %tY Bal: %s%,.2f P: %s%,.2f I: %s%,.2f%n",
                    date, usd, v, usd, newPrin, usd, moInterest);
            v = newBal;
            date = date.plusMonths(1);

        }
    }

    /**
     *  Can be used as a stand-alone app
     * @param args Argument list
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {
            System.out.println("Calculated payments on mortgage");
            System.out.print("Enter principal amount: ");
            double prin = in.nextDouble();
            System.out.print("Enter interest rate: ");
            double rate = in.nextDouble();
            System.out.print("How many years? ");
            double periods = in.nextDouble() * 12;
            new Amortized(prin, rate, periods);
        }

    }
}
