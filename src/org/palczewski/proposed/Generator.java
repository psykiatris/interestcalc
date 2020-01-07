package org.palczewski.proposed;

import org.jetbrains.annotations.Contract;

/**
 * This class will combine the main functions. The grow() method will
 * increase (earning). The shrink() method will decrese (charge). This will
 *  help facilitate growing/shrinking accounts over time.
 *
 *  It will pass results to a Report class to display information to the
 *  user in a human-friendly format.
 */
public class Generator {

    @Contract(pure = true)
    private Generator() {}

    /**
     * Add interest to balances (i.e. add interest to a
     * savings account or CD)
     */
    public void grow() {

    }


    /**
     * Decreases balances such as principal and interest payments.
     */
    public void shrink() {


    }
}
