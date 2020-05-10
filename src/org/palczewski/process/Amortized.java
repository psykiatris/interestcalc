package org.palczewski.process;

import javax.swing.text.NumberFormatter;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
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

    // Set number formats
    private static final NumberFormat num =
            NumberFormat.getInstance(Locale.getDefault());
    private static final NumberFormat usd =
            NumberFormat.getCurrencyInstance(Locale.getDefault());
    private static final NumberFormat prct =
            NumberFormat.getPercentInstance(Locale.getDefault());
    

    /**
     * Creates an object of princi]al, rate &amp; period
     * @param p Principal balance
     * @param rate Annual Percentage Rate
     * @param periods Months in period
     *
     */
    private Amortized(double p, double rate, double periods) {

        // Set percentage fraction
        prct.setMaximumFractionDigits(3);
        num.setMaximumFractionDigits(0);
        double moInt;
        moInt = (rate == 0) ? 0.0 : (rate / (12 * 100));
        double payment;

        payment = (moInt == 0) ? (p / periods) : (p * (moInt / (1 - (StrictMath.pow(1 / (1 + moInt), periods)))));

        // displays payment table
        viewAmortizationSchedule(p, rate, LocalDate.now(),

                toMonths(periods), payment);
        System.out.println("\t=== Payment Summary ===");
        String text = (periods <= 1) ? APY.MONTH : APY.MONTHS;
        System.out.printf("Based on principal of %s for %s %s,%nat %s, your montly payments would be  %s.%n",
                usd.format(p), num.format(periods), text,
                prct.format(rate / 100)
                ,
                usd.format(payment));
        System.out.printf("Interest paid for this period: %s%n", usd.format(accumInt));


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
        // Set fractional digits
        prct.setMaximumFractionDigits(3);

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
            System.out.printf("%1$tb %tY Bal: %s P: %s I: %s%n",
                    date,  usd.format(v), usd.format(newPrin), usd.format(moInterest));
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
            System.out.println("Loan Calculator - version 1.0");
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
