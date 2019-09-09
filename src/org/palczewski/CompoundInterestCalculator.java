package org.palczewski;

import java.nio.charset.StandardCharsets;
import java.time.Period;
import java.time.YearMonth;
import java.util.Scanner;

/*
For now, this class will calculate and disply interest gained in a
particular month.
 */
public class CompoundInterestCalculator {

    // Fields
    private int inputMonth;
    private int inputYear;
    private double intRate;
    private static double dailyInterrest;
    private double balance;

    CompoundInterestCalculator(double balance, double intRate, int year,
                               int month) {
        // Display information
        System.out.println("Day  Balance\tInterest\tDaily Interest");
        double sum = 0;
        for(int i = 1; i < (getDays(year, month) + 1); i++) {
            System.out.printf("%d $%.2f\t%.2f%%\t%.9f%n", i, balance,
                    intRate,
                    getDailyInt(balance, intRate));
            sum += getDailyInt(balance, intRate);
        }
        System.out.printf("Total interest earned: %.2f%n", sum);

    }

    private static double getDailyInt(double balance, double intRate) {

        double resInt = intRate / 100;
        dailyInterrest = resInt / 365;
        return balance * dailyInterrest;

    }

    private int getDays(int year, int month) {
        YearMonth ym = YearMonth.of(year, month);
        return ym.lengthOfMonth();
    }


}
