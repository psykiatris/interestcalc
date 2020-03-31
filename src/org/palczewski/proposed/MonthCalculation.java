package org.palczewski.proposed;

import java.time.*;

/**
 * Provides methods to manage time in hourly, daily and monthly criteria.
 */
enum MonthCalculation {
    ;

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

        LocalDateTime endOfDay = date.toLocalDate().atTime(23, 59, 59);

            Duration period = Duration.between(date,
                    endOfDay);
            return period.toHours();
        }

        private static int minutesToEndOfDay(LocalDateTime date) {

            LocalDateTime endOfDay = date.toLocalDate().atTime(23, 59, 59);


            Duration period = Duration.between(date,
                    endOfDay);

            return (period.toMinutesPart());
        }


        //Test
        public static void main(String[] args) {

        /*
        Will actually develop a timestamp function that will grab the
        date/time when a transaction is triggered.
         */
        LocalDateTime date = LocalDateTime.parse("2020-02-29T06:08:34");
            System.out.printf("Time now is: %s%n", date);

            System.out.printf("Time to end of day: %s hours %s minutes%n",
                    hoursToEndOfDay(date),
                    (minutesToEndOfDay(date)));





        }






}

