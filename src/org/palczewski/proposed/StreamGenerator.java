package org.palczewski.proposed;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Generates streams from passed in data
 */
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

    /**
     * Self-test
     * @param args List of arguments
     */
    public static void main(String[] args) {
        // Using today's date
        LocalDate date = LocalDate.now();

        // Create list from Stream
        List<LocalDate> res =
                generateCycleDays(date)
                        .collect(Collectors.toList());

        // Print results of returned stream
        System.out.println(res);
        System.out.printf("First day of cycle: %s%n", res.get(0));
        System.out.printf("15th day of cycle: %s%n", res.get(14));

        // Printing size of list, which
        // should match days of cycle.
        System.out.println(String.format("Cycle is: %d days",
                res.size()));





    }
}
