package org.palczewski.process;

import java.time.YearMonth;


/**
Calculate and disply interest gained in a
particular month. (Will be deprecated in a future release)
 @author Patrick Palczewski - psykiatris@gmail.com
 @version .99
 */
class CompoundInterestCalculator {

    // Fields
    private int inputMonth;
    private int inputYear;
    private double intRate;
    private double balance;

    /**
     * Consructor
     * @param balance Balance being calculated
     * @param intRate Annual Percentage Rate (APR)
     * @param year Year of cycle period
     * @param month Month of cycle period
     */
    CompoundInterestCalculator(double balance, double intRate, int year,
                               int month) {
        // Display information
        System.out.println("Day  Balance\tInterest\tDaily Interest");
        double sum = 0;
        for(int i = 1; i < (getDays(year, month) + 1); i++) {
            System.out.printf("%d $%,7.2f\t%.2f%%\t%.9f%n", i, balance,
                    intRate,
                    getDailyInt(balance, intRate));
            sum += getDailyInt(balance, intRate);
        }
        System.out.printf("Total interest earned: %.2f%n", sum);

    }

    /**
     * Returns calculated daily interest for each day in cycle
     *
     * @param balance Daily balance
     * @param intRate Annual Percentage Rate
     * @return Value of daily interest in dollars
     */
    private static double getDailyInt(double balance, double intRate) {

        double resInt = intRate / 100;
        double dailyInterrest = resInt / 365;
        return balance * dailyInterrest;

    }


    /**
     * Calculates days in cycle period
     *
     * @param year Year of cycle period
     * @param month Month of cycle period
     * @return Value of days in cycle
     */
    private int getDays(int year, int month) {
        // TODO: 1/26/20 Should rewrite as this complicates function.
        YearMonth ym = YearMonth.of(year, month);
        return ym.lengthOfMonth();
    }


}
