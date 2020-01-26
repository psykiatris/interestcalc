package org.palczewski.proposed;

import org.jetbrains.annotations.Contract;

/**
 * Proposed code to combine the main calculations of the application. The
 * grow() method
 * will
 * increase (earn). The shrink() method will decrese (charge). This will
 *  help facilitate growing/shrinking accounts over time.
 *
 *  Passes results to a Report class to display information to the
 *  user in a human-friendly format.
 *  @author Patrick Palczewski - psykiatris@gmail.com
 * @version .99
 *
 */
public class Generator {

    @Contract(pure = true)
    /**
     * Cannot be instantiated
     */
    private Generator() {}

    /**
     * Adds interest to balances (i.e. add interest to a
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
