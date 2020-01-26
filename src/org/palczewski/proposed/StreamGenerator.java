package org.palczewski.proposed;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Generates streams from passed in data
 * @author Patrick Palczewski - psykiatris@gmail.com
 * @version .99
 */
public class StreamGenerator {

    /**
     * Creates a stream of dates in a cycle
     * @param date The beginning date
     * @return A List of dates
     */
    private static Stream<LocalDate> generateCycleDays(LocalDate date) {
        List<LocalDate> daysList = new ArrayList<>(date.lengthOfMonth());

        for(int i = 0; i < date.lengthOfMonth(); i++) {
            daysList.add(date.plusDays(i));
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

        Map<LocalDate, Double> resMap = new LinkedHashMap<>(31);
        for(LocalDate i : res)
            resMap.put(i, (double) 800);

        // Displays list
        for (LocalDate localDate : res) System.out.println(localDate);
        System.out.printf("First day of cycle: %s%n", res.get(0));
        System.out.printf("15th day of cycle: %s%n", res.get(14));

        // Printing size of list, which
        // should match days of cycle.
        System.out.println(String.format("Cycle is: %d days",
                res.size()));

        // Print map entries
        System.out.println();
        System.out.println("Printing map entries:");
        for(Map.Entry<LocalDate, Double> m : resMap.entrySet())
            System.out.printf("Key: %s Value: $%,.2f%n", m.getKey(),
                    m.getValue());





    }
}
