package org.palczewski.account;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

/**
Creates a base account with balance, apr and period (term in months)
 @author Patrick Palczewski - psykiatris@gmail.com
 @version 1.0
 */
class BaseAccount {

    private final double balance;
    private final double apr;
    private static double period = 0.0;
    private final LocalDate date;

    /**
     * Default constructor with 0 bakabc and today's date.
     */
    private BaseAccount() {
        balance = 0;
        // Recent change in Java library. Now must have params. Parameters
        // are 7/3/2023 - day 183
        // date = LocalDate.ofYearDay(2023, 183);
        date = LocalDate.now();
        apr = 0;

    }

    /**
     * Creates base account object for use with other classes.
     *
     * @param bal Amount being calculated
     * @param a Annual Interest Rate (APR)
     * @param d Start date of cycle period
     */
    private BaseAccount(double bal, double a, @NotNull LocalDate d) {
        balance = bal;
        apr = a;
        date = d;
        period = toDaysInPeriod(d);

    }

    /**
     * Returns balance
     * @return Value of balance
     */
    @Contract(pure = true)
    public final double getBalance() {
        return balance;
    }

    /**
     * Returns APR (Annual Percentage Rate)
     * @return Value of apr
     */
    @Contract(pure = true)
    public final double getApr() {
        return apr;
    }

    /**
     * Retruns period
     * @return Value of period (in months)
     */
    @Contract(pure = true)
    public final double getPeriod() {
        return period;
    }

    /**
     * Returns beginning date of cycle
     * @return Value of cycle start date
     */
    @Contract(pure = true)
    public final LocalDate getDate() {
        return date;
    }

    /**
     * Returns number of days in cycle period (28. 29, 30 or 31)
     * depending on month cycle ends in
     * @param date Start date of cycle
     * @return Length of cycle's period
     */
    @Contract(pure = true)
    private int toDaysInPeriod(@NotNull LocalDate date) {
        // Gets days in period
        return date.lengthOfMonth();
    }


    @Override
    public final String toString() {
        return String.format("Balance: $%,.2f%nAPR: %.2f%%%nDate: %3$tB %3$tY",
                balance,
                apr, date);
    }

    // Self-test
    public static void main(String[] args) {
        String m = "2022-08-12";
        BaseAccount acct = new BaseAccount(114000, 5.0, LocalDate.parse(m));
        System.out.println(acct);
        System.out.printf("Days in period: %.0f%n", period);
    }
}
