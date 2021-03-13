package org.palczewski.proposed;

import java.sql.SQLInput;
import java.util.Currency;
import java.util.Locale;
import java.util.spi.CurrencyNameProvider;


/**
 * This class will work with currency.
 */
public class LocalCurrency {


    public static void main(String[] args) {

        // Gets currency from system
        String sysCurrency = Currency.getInstance(Locale.getDefault()).getSymbol();

        // Hard coded currency
        String pound = Currency.getInstance(Locale.UK).getSymbol();
        String yen = Currency.getInstance(Locale.JAPAN).getSymbol();

        System.out.printf("US Dollar: %s\nBritish Pound: %s\nJapanese Yen: %s", sysCurrency,
                pound, yen);

    }
}
