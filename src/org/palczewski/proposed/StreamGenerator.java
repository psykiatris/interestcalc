package org.palczewski.proposed;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamGenerator {

    /**
     * Creates a stream of dates in a cycle
     * @param date The beginning date
     * @return A List of dates
     */
    public static Stream<List<LocalDate>> generateCycleDays(LocalDate date) {
        List<LocalDate> daysList = new ArrayList<>(1);
        int cycle = date.lengthOfMonth();
        LocalDate endDate = date.plusDays(cycle);
        for(int i = 0; i < cycle; i++) {
            daysList.add(date);
            date = date.plusDays(1);
        }

        return Stream.of(daysList);

    }

    // Self-test method
    public static void main(String[] args) {
        // Create a date
        LocalDate date = LocalDate.now();
        // Print results of returned stream
        Object[] res = generateCycleDays(date).toArray();

        for (Object o : res) {
            System.out.println(o);
        }




    }
}