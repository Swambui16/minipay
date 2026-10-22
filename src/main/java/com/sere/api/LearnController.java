package com.sere.api;

import java.util.Arrays;
import java.util.Scanner;

public class LearnController {
    public static void main(String[] args) {
        // typing
        String message = "Hello world";
        System.out.println(message);

        // five slots, all start as 0
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        System.out.println(Arrays.toString(numbers));

        // casting
        double x = 1.1;
        int y = (int) x + 2;
        System.out.println(y);

        //reading input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("You are " + name);

//

        //conditions
        int temperature = 23;
        boolean isWarm = temperature > 20 && temperature < 30;
        System.out.println(true);

        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean isEligible = hasHighIncome || hasGoodCredit;
        System.out.println(true);

        //Mortgage calculator
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Principal: ");
        int Principle = scanner.nextInt();

        System.out.println("Annual Interest Rate: ");
        float Annual_Interest_Rate = scanner.nextFloat();
        if (Annual_Interest_Rate >= 1 && Annual_Interest_Rate <= 30) {
            float monthlyInterest = Annual_Interest_Rate / PERCENT / MONTHS_IN_YEAR;
            System.out.println("Enter a number between 1 and 30:");
        }

        while (true) {
            System.out.println("Periods:");
            byte Periods = scanner.nextByte();
            if (Periods >= 1 && Periods <= 30) ;
            {

            }

            System.out.println("Mortgage:");

        }
    }
}