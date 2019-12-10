package org.palczewski.proposed;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamGenerator {

    public Stream<List<LocalDate>> generateCycleDays(LocalDate date) {
        List<LocalDate> daysList = new ArrayList<>(1);
        int cycle = date.lengthOfMonth();
        LocalDate endDate = date.plusDays(cycle);

        return Stream.of(daysList);

    }

    // Self-test method
    public static void main(String[] args) {

    }
}
