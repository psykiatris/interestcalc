package org.palczewski.proposed;

import java.time.*;
import java.time.temporal.ChronoUnit;

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

        private static LocalDateTime toStartOfDay(LocalDate date) {

        return date.atStartOfDay();

        }

        private static long hoursToEndOfDay(LocalDateTime date) {

        LocalDateTime endOfDay = date.toLocalDate().atTime(23, 59);

            Duration period = Duration.between(date,
                    endOfDay);
            return period.toHours();
        }

        private static int minutesToEndOfDay(LocalDateTime date) {

            LocalDateTime endOfDay = date.toLocalDate().atTime(23, 59);


            Duration period = Duration.between(date,
                    endOfDay);

            return (period.toMinutesPart() + 1);
        }


        //Test
        public static void main(String[] args) {

        LocalDateTime date = LocalDateTime.now();
            System.out.printf("Time now is: %s%n", date);

            System.out.printf("Time to end of day: %s hours %s minutes%n",
                    hoursToEndOfDay(date),
                    (minutesToEndOfDay(date)));





        }






}

