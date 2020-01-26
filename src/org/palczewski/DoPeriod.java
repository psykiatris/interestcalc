package org.palczewski;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Calculates days or weeks between dates provided by user.
 * @author Patrick Palczewski - psykiatris@gmail.com
 * @version .99
 */
public class DoPeriod {

    /**
     * Calculates days between period of dates
     */
    DoPeriod() {
        try(Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {
            LocalDate startDate;
            System.out.print("Enter begining date: ");
            startDate = LocalDate.parse(in.next());
            System.out.print("Enter days in period: ");
            int cycle = in.nextInt();
            LocalDate endDate = startDate.plus(cycle,
                    ChronoUnit.DAYS);
            System.out.printf("Period is from %1$tm-%1$td-%1$tY to %2$tm-%2$td-%2$tY%n",
                    startDate, endDate);
            System.out.printf("Period is %s days.%n",
                    daysInPeriod(startDate, endDate));
        }
    }

    /**
     * Calculates days in period
     * @param start Start date
     * @param end End date
     * @return Number of days
     */
    private int daysInPeriod(LocalDate start, LocalDate end) {

        return Period.between(start, end).getDays();

    }

    /**
     * Returns number of weeks between dates
     * @param start Start date
     * @param end End date
     * @return Number of weeks
     */
    private int weeksInPeriod(LocalDate start, LocalDate end) {
        // empty for now
        return 0;
    }

    // Self-test
    public static void main(String[] args) {
        new DoPeriod();
    }
}
