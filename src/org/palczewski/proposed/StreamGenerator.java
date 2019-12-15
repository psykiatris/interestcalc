package org.palczewski.proposed;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGenerator {

    /**
     * Creates a stream of dates in a cycle
     * @param date The beginning date
     * @return A List of dates
     */
    private static Stream<LocalDate> generateCycleDays(LocalDate date) {
        LocalDate local = date;
        List<LocalDate> daysList = new ArrayList<>(1);
        int cycle = local.lengthOfMonth();
        for(int i = 0; i < cycle; i++) {
            daysList.add(local);
            local = local.plusDays(1);
        }

        return daysList.stream();

    }

    // Self-test method
    public static void main(String[] args) {
        // Create a date
        LocalDate date = LocalDate.now();
        // Print results of returned stream

        List<LocalDate> res =
                generateCycleDays(date)
                        .collect(Collectors.toList());


        System.out.println(res);
        System.out.printf("First day of cycle: %s%n", res.get(0));


        // Length
        System.out.println(String.format("Cycle is: %d days",
                res.size()));





    }
}
