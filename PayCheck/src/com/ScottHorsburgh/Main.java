package com.ScottHorsburgh;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PayCheck paycheck = new PayCheck();
        paycheck.employeeName();
        boolean hoursEmpty = true;
        while (hoursEmpty) {
            try {
                System.out.print("Enter amount of hours worked: ");
                String hours = "";
                hours = input.nextLine();
                //Checks if user input is empty
                if(hours.isEmpty()) {
                    System.out.println("** Hours must be greater than 0 **");
                }
                //If hours greater then 0 then store hours and sets hoursEmpty to false to leave while loop
                //Changes user input from a string to a double and if hours is 0 then give error message
                else{
                    double newHours = Double.parseDouble(hours);
                    if (newHours > 0) {
                        paycheck.payCheckHours(newHours);
                        hoursEmpty = false;
                    }
                    else{
                        System.out.println("** Hours must be greater than 0 **");
                    }
                }
             //Checks if there is a string instead of number e.g ( thirty and not 30 )
            } catch (Exception e) {
                System.out.println("** Make sure hours worked is a number greater than 0 **");
                input.nextLine();
            }
        }
        paycheck.getPayCheckValues();
    }
}
