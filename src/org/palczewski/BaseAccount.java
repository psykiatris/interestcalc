package org.palczewski;

import java.time.LocalDate;

/*
Defines an account type with similar fields.
 */
public class BaseAccount {

    private final double balance;
    private final double apr;
    private final double period;
    
    BaseAccount(double balance, double apr, LocalDate date) {
        this.balance = balance;
        this.apr = apr;
        LocalDate d = date;
        period = d.lengthOfMonth();

    }

    public static void main(String[] args) {

    }


}
