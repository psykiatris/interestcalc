package org.palczewski;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DoPeriod {

    DoPeriod() {
        try(Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {
            LocalDate startDate;
            System.out.print("Enter begining date: ");
            startDate = LocalDate.parse(in.next());
            System.out.print("Enter days in period: ");
            int cycle = in.nextInt();
            LocalDate endDate = startDate.plus(cycle - 1,
                    ChronoUnit.DAYS);
            System.out.printf("Period is from %1$tm-%1$td-%1$tY to %2$tm-%2$td-%2$tY%n",
                    startDate, endDate);
            System.out.printf("Period is %d days.%n", cycle);
        }
    }

    public static void main(String[] args) {
        new DoPeriod();
    }
}
