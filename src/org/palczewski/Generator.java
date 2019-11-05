package org.palczewski;

/*
This class will combine the main functions. The grow() method will
increase (earning). The shrink() method will decrese (charge). This will
 help facilitate growing/shrinking accounts over time.

 It will pass results to a Report class to display information to the
 user in a human-friendly format.
 */

import org.jetbrains.annotations.Contract;

public class Generator {

    // Do not allow this class to be instantiated
    @Contract(pure = true)
    private Generator() {}

    public void grow() {
        // Increase account (i.e. savings, CDs, etc.)
    }

    public void shrink() {
        // Will decrease (i.e. paying off debt such as mortgage and
        // credit cards)

    }
}
