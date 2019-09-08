package org.palczewski;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double balance;
        try (Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {

            System.out.println("Nifty interest calculator");
            System.out.printf("See the interest you could earn in one month.%n");
            System.out.print("Enter month:  ");
            int month = Integer.parseInt(in.nextLine());
            System.out.print("Enter year: ");
            int year = Integer.parseInt(in.nextLine());
            System.out.print("Enter balance: ");
            balance = in.nextDouble();
            System.out.print("Enter interest rate: ");
            double intRate = in.nextDouble();

            new CompoundInterestCalculator(balance, intRate, year, month);



        }

    }
}
