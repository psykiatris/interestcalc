package org.palczewski;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {

            System.out.println("Nifty interest calculator");
            System.out.printf("See the interest you could earn in one month.%n");
            System.out.print("Enter month:  ");
            int month = in.nextInt();
            System.out.print("Enter year: ");
            int year = in.nextInt();
            System.out.print("Enter balance: ");
            double balance = in.nextDouble();
            System.out.print("Enter interest rate: ");
            double intRate = in.nextDouble();

            new CompoundInterestCalculator(balance, intRate, year, month);



        }

    }
}
