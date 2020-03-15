package org.palczewski.process;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Generates the Annual Percentage Yield (the true interest) on the
 * passed in data
 * @author Patrick Palczewski - psykiatris@gmail.com
 *  @version .99
 */
public class APY {

    static final String MONTHS = "months";
    static final String MONTH = "month";

    /**
     * Calculates Annual Percentage Yield (the true APR rate)
     *
     * @param totalInt Total of interest earned
     * @param intRate Annual Percentage Rate
     * @param period Number of months
     */
    private APY(double totalInt, double intRate,
                double period) {
        double apr = intRate / 100;
        // first part of formula
        double months = period * 12;
        double form = 1 + (apr / months);

        // The rest of the formula
        double res = (StrictMath.pow(form, months) - 1);

        System.out.println("\t=== APY ===");
        System.out.printf("Total interest earned: $%,.2f%nInterest rate: %.2f%%%nAnnual interest: $%,.2f%n=  average monthly interest of: $%,.2f%n",
                totalInt,
                intRate,
                (totalInt / period), (totalInt /
                months));
        System.out.printf("True APY is: %,.2f%%%n", res * 100);

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
     * @param invBal Amount of monthly invenstment
     * @param term Term in years
     * @return totalInt Value of tatal interest earned
     */
    private static double growthTable(double startBal, double rate,
                                 LocalDate date
            , double invBal, double term) {

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
            System.out.printf("%1$tb %tY - Bal: $%,.2f Int: $%,.2f%n",
                    localDate, newBal, moInt);
            bal = newBal + invBal;
            localDate = localDate.plusMonths(1);
        }
        System.out.println("\t=== Results ===");
        String textMo = (month <= 1) ? MONTH : MONTHS;
        System.out.printf("After %.0f %s, with an initial balance of " +
                        "%n$%,.2f and a monthly deposit of $%,.2f,%n " +
                        "your final balance would be $%,.2f%n", month,
                textMo,
                startBal, invBal
                , newBal);
        return totalInt;
    }

    /**
     * Use as stand-alone applicaton, will prompt user for details to
     * pass to class constructor
     * @param args Empty argument list
     */
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
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
