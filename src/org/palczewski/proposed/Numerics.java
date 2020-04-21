package org.palczewski.proposed;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;


public class Numerics {

    public static void main(String[] args) throws Exception {
        double amt = 10500.75;
        double intRate = 0.001;

        NumberFormat format =
                NumberFormat.getCurrencyInstance(Locale.getDefault());
        NumberFormat prct =
                NumberFormat.getPercentInstance(Locale.getDefault()).;

        System.out.printf("Amount: %s%nInterest Rate: %s",
                format.format(amt), prct.format(intRate));

    }
}

