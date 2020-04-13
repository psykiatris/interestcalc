package org.palczewski.proposed;

import java.util.Currency;
import java.util.Locale;
import java.util.Set;

/**
 * This class will work with currency.
 */
public class LocalCurrency {


    public static void main(String[] args) {
        Set<Currency> curList = Currency.getAvailableCurrencies();

        for (Currency currency : curList) {
            System.out.println("Country: " + currency + ": " + currency.getSymbol());
        }


    }
}
