package org.palczewski.proposed;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamGenerator {

    /**
     * Creates a stream of dates in a cycle
     * @param date The beginning date
     * @return A List of dates
     */
    private static Stream<List<LocalDate>> generateCycleDays(LocalDate date) {
        LocalDate local = date;
        List<LocalDate> daysList = new ArrayList<>(1);
        int cycle = local.lengthOfMonth();
        LocalDate endDate = local.plusDays(cycle);
        for(int i = 0; i < cycle; i++) {
            daysList.add(local);
            local = local.plusDays(1);
        }

        return Stream.of(daysList);

    }

    // Self-test method
    public static void main(String[] args) {
        // Create a date
        LocalDate date = LocalDate.now();
        // Print results of returned stream
        List<Spliterator<List<LocalDate>>> res = new ArrayList<>(1);
        Stream<List<LocalDate>> resStream = generateCycleDays(date);

        /*
        for(LocalDate d = date; d.equals(date.isBefore(date.plusDays(date.lengthOfMonth()))); d = date.plusDays(1)) {


        }

         */








        // Length
        System.out.println(String.format("Cycle is: %d days",
                res.size()));





    }
}
