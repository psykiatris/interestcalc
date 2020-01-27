package org.palczewski.time;

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
    // TODO: 1/27/20 Rewrite this class for simplicity and clarity.
    /**
     * Empty constructor
     */
    private DoPeriod() {

    }

    /**
     * Displays period in days
     * @param start Start date
     * @param cycle Number of days
     */
    private void daysInPeriod(LocalDate start, int cycle) {

        LocalDate endDate = start.plus(cycle,
                ChronoUnit.DAYS);
        System.out.printf("Period is from %1$tm-%1$td-%1$tY to %2$tm-%2$td-%2$tY%n",
                start, endDate);
        System.out.printf("Period is %s days.%n", cycle);



    }

    /**
     * Displays period in weeks
     * @param start Start date
     * @param cycle Number of days
     */
    private void weeksInPeriod(LocalDate start, int cycle) {
        LocalDate endDate = start.plus(cycle,
                ChronoUnit.DAYS);
        System.out.printf("Period is from %1$tm-%1$td-%1$tY to %2$tm-%2$td-%2$tY%n",
                start, endDate);
        System.out.printf("Period is %s weeks.%n", cycle / 7);

    }

    /**
     * Collects info from user
     */
    public final void collect() {
        LocalDate start;
        LocalDate end;
        try(Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {
            LocalDate startDate;
            System.out.print("Enter begining date: ");
            startDate = LocalDate.parse(in.next());
            System.out.print("Enter days in period: ");
            int cycle = in.nextInt();

            start = startDate;
            daysInPeriod(start, cycle);
            weeksInPeriod(start, cycle);

        }

    }

    // Self-test
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {
            System.out.print("Enter date: ");
            LocalDate start = LocalDate.parse(in.next());
            System.out.print("Number of weeks: ");
            int weeks = in.nextInt();

            LocalDate end = start.plusWeeks(weeks);
            System.out.printf("Dates from: %s to %s,%n for a total of %s" +
                            " weeks.%n",
                    start,
                    end,
                    weeks);

        }
    }
}
