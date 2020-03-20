package org.palczewski.proposed;

import java.time.LocalDate;
import java.time.Period;

/**
 * This class will handle month calculations, such as partial months, e
 * .g. a CD account starting on a day in the middle of the month and
 * ending in the middle of the month.
 */
public class MonthCalculation {

    // Private construcotr. Cannot instantiate
    private MonthCalculation() {}

    static int toEndOfMonth(LocalDate date) {
        // Get days in month based on beginning date
        int curDaysInMonth = date.lengthOfMonth();
        int curDay = date.getDayOfMonth();
        System.out.printf("Month: %tB%n", date);
        System.out.printf("Current day: %s%nDaysin month: %s%n", curDay,
                curDaysInMonth);

        return curDaysInMonth - curDay;


        }

        static int fromBeginningOfMonth(LocalDate date) {

        int firstDayOfMonth = 1;

            System.out.printf("Day: %s%nFirst day of month: %s%n",
                    date.getDayOfMonth(),
                    firstDayOfMonth);

        return date.getDayOfMonth() - firstDayOfMonth;
        }

        private static LocalDate newDateUsingDays(LocalDate date, int period) {

            System.out.printf("After %s days, new date is: %n", period);

        return date.plusDays(period);

        }

        private static LocalDate newDateUsingMonths(LocalDate date, double year) {

        double months = year * 12;
            System.out.printf("Using %s months: %n", months);

        return date.plusMonths((long) months);


        }

        //Test
        public static void main(String[] args) {

            System.out.printf("New date: %s%n",
                    newDateUsingMonths(LocalDate.parse("2020-03-10"), 30));
            System.out.printf("%s%n",
                    newDateUsingDays(LocalDate.now(), 90));

        }






}

