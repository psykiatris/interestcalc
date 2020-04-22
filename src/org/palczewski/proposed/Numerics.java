package org.palczewski.proposed;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;


public class Numerics {

    public static void main(String[] args) throws Exception {
        double amt = 10500.75;
        double intRate = 2.6125 / 100;

        NumberFormat format =
                NumberFormat.getCurrencyInstance(Locale.getDefault());
        NumberFormat prct =
                NumberFormat.getPercentInstance(Locale.getDefault());
        // Set grouping
        prct.setMaximumFractionDigits(3);



        System.out.printf("Amount: %s%nInterest Rate: %s",
                format.format(amt), prct.format(intRate));

    }
}

