package org.palczewski;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

/*
Defines an account type with similar fields.
 */
public class BaseAccount {

    private final double balance;
    private final double apr;
    private static double period = 0.0;
    private final LocalDate date;
    
    BaseAccount(double balance, double apr, @NotNull LocalDate date) {
        this.balance = balance;
        this.apr = apr;
        this.date = date;
        period = daysInPeriod(date);

    }

    @Contract(pure = true)
    public final double getBalance() {
        return balance;
    }

    @Contract(pure = true)
    public final double getApr() {
        return apr;
    }

    @Contract(pure = true)
    public final double getPeriod() {
        return period;
    }

    @Contract(pure = true)
    public final LocalDate getDate() {
        return date;
    }

    @Contract(pure = true)
    private int daysInPeriod(@NotNull LocalDate date) {
        // Gets days in period
        return date.lengthOfMonth();
    }


    @Override
    public final String toString() {
        return String.format("Balance: $%,.2f%nAPR: %.2f%%%nDate: %3$tB " +
                        "%3$tY",
                balance,
                apr, date);
    }

    // Self-test
    public static void main(String[] args) {
        String m = "2020-02-15";
        BaseAccount acct = new BaseAccount(1000, 1.88, LocalDate.parse(m));
        System.out.println(acct);
        System.out.printf("Days in period: %.0f%n", period);
    }
}
