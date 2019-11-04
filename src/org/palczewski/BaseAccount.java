package org.palczewski;

import java.time.LocalDate;

/*
Defines an account type with similar fields.
 */
public class BaseAccount {

    private final double balance;
    private final double apr;
    private static double period = 0.0;
    
    BaseAccount(double balance, double apr, LocalDate date) {
        this.balance = balance;
        this.apr = apr;
        LocalDate d = date;
        period = d.lengthOfMonth();

    }

    public final double getBalance() {
        return balance;
    }

    public final double getApr() {
        return apr;
    }

    public final double getPeriod() {
        return period;
    }


    @Override
    public final String toString() {
        return String.format("Balance: %s%nAPR: %s%n", balance, apr);
    }
}
