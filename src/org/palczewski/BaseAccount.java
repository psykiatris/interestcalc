package org.palczewski;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

/**
Creates a base account with balance, apr and period (term in months)
 @author Patrick Palczewski - psykiatris@gmail.com
 @version .99
 */
public class BaseAccount {

    private final double balance;
    private final double apr;
    private static double period = 0.0;
    private final LocalDate date;

    /**
     * Creates base account object for use with other classes.
     *
     * @param balance Amount being calculated
     * @param apr Annual Interest Rate (APR)
     * @param date Start date of cycle period
     */
    private BaseAccount(double balance, double apr, @NotNull LocalDate date) {
        this.balance = balance;
        this.apr = apr;
        this.date = date;
        period = daysInPeriod(date);

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
    private int daysInPeriod(@NotNull LocalDate date) {
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
        String m = "2020-11-10";
        BaseAccount acct = new BaseAccount(1000, 1.88, LocalDate.parse(m));
        System.out.println(acct);
        System.out.printf("Days in period: %.0f%n", period);
    }
}
