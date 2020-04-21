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

        
        String usDollar = Currency.getInstance(Locale.getDefault()).getSymbol();

        String pound = Currency.getInstance(Locale.UK).getSymbol();

        System.out.printf("US Dollar: %s\nBritish Pound: %s", usDollar,
                pound);

    }
}
