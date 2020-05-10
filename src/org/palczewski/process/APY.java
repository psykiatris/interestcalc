package org.palczewski.process;

import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

/**
 * Generates the Annual Percentage Yield (the true interest) on the
 * passed in data
 * @author Patrick Palczewski - psykiatris@gmail.com
 *  @version .99
 */
class APY {

    /**
     * The text 'months'.
     */
    static final String MONTHS = "months";
    /**
     * The text 'month'.
     */
    static final String MONTH = "month";

    /*
    Set currency and percentage formats to display
     */
    private static final NumberFormat usd =
            NumberFormat.getCurrencyInstance(Locale.getDefault());
    private static final NumberFormat prct =
            NumberFormat.getPercentInstance(Locale.getDefault());
    private static final NumberFormat num =
            NumberFormat.getInstance(Locale.getDefault());






    /**
     * Calculates Annual Percentage Yield (the true APR rate)
     *
     * @param totalInt Total of interest earned
     * @param intRate Annual Percentage Rate
     * @param period Number of years
     */
    private APY(double totalInt, double intRate,
                double period) {

        //Set percentage fraction
        prct.setMaximumFractionDigits(2);
        double apr = intRate / 100;
        // first part of formula
        double months = period * 12;
        double form = 1 + (apr / months);

        // The rest of the formula
        double res = (StrictMath.pow(form, months) - 1);

        System.out.println("\t=== APY ===");
        System.out.printf("Total interest earned: %s%nInterest rate: " +
                        "%s%nAnnual interest: %s%n=  average monthly interest of: %s%n",
                usd.format(totalInt),
                prct.format(apr),
                usd.format((totalInt / period)), usd.format((totalInt /
                        months)));
        System.out.printf("True APY is: %s%n",
                prct.format((res * 100) / 100));

    }

    /**
     * Returns total interest for period. Creates a table of the balance
     * including
     * the interest for the
     * given period
     *
     * @param startBal Beginning balance
     * @param rate Annual Percentage Rate
     * @param date Date of period
     * @param invAmt Amount of monthly investment
     * @param term Term in years
     * @return totalInt Value of tatal interest earned
     */
    private static double growthTable(double startBal, double rate,
                                 LocalDate date
            , double invAmt, double term) {

        num.setMaximumFractionDigits(0);
        LocalDate localDate = date;
        double bal = startBal;
        double moRate = rate / (12 * 100);
        double month = term * 12;
        double newBal = 0;
        double totalInt = 0;
        System.out.println("\t=== Monthly Details ===");

        for(int i = 0; i < month; i++) {
            double moInt = bal * moRate;
            totalInt += moInt;
            newBal = bal + moInt;
            System.out.printf("%1$tb %tY - Bal: %s Int: %s%n",
                    localDate, usd.format(newBal), usd.format(moInt));
            bal = newBal + invAmt;
            localDate = localDate.plusMonths(1);
        }
        System.out.println("\t=== Results ===");
        String textMo = (month <= 1) ? MONTH : MONTHS;
        System.out.printf("After %s %s, with an initial balance of " +
                        "%n%s and a monthly deposit of %s,%n " +
                        "your final balance would be %s%n", num.format(month),
                textMo,
                usd.format(startBal),  usd.format(invAmt)
                ,  usd.format(newBal));
        return totalInt;
    }

    /**
     * Use as stand-alone applicaton, will prompt user for details to
     * pass to class constructor
     * @param args Empty argument list
     */
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {
            System.out.println("Savings Calculatgor - version 1.0");
            // Get figures
            System.out.print("Enter a balance: ");
            double bal = in.nextDouble();
            System.out.print("Enter Annual Percent Rate: ");
            double interest = in.nextDouble();
            System.out.print("Enter amount to invest monthly: ");
            double invBal = in.nextDouble();
            System.out.print("Enter term in years: ");
            double term = in.nextDouble();

            double resBal = growthTable(bal, interest,LocalDate.now(),
                    invBal, term);

            // Pass along
            new APY(resBal, interest, term);
        }

    }
}
