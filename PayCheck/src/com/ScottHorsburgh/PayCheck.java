package com.ScottHorsburgh;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PayCheck {
    private String name;
    private final double salary = 9.25;
    private final double overTimeRate = 1.5;
    private double hours;
    private double overTimeHours;
    private double regularPaid;
    private double overTimePay;
    private double totalPay;

    //Creating instance object of PrintingFormat class
    PrintingFormat print = new PrintingFormat();

    /**Default Constructor with no parameters.
     */
    public PayCheck(){ }

    /**Method to take values from paycheck and employee name and apply to paycheck format method.
     */
    public void getPayCheckValues(){

        //Using print paycheck method from PrintingFormat Class with print object created in this Class
        print.printPayCheck(name, hours, overTimeHours, regularPaid, overTimePay, totalPay);
    }

    /**Method asking for first and last name of employee.
     * Checks if input is empty and Capitalizing first char of first name / last name
      */
    public void employeeName(){
        Scanner input = new Scanner(System.in);
        String fName = "";
        String lName = "";
        boolean emptyInput = true;
        boolean numeric = false;

        while(emptyInput || numeric) {
            try {
                System.out.print("\nEmployee first name: ");
                fName = input.nextLine();
                System.out.print("Employee Last name: ");
                lName = input.nextLine();

                //Checks if first name or last name input is numeric instead of string
                numeric = fName.matches("-?\\d+(\\.\\d+)?") || lName.matches("-?\\d+(\\.\\d+)?");;

                //If first name or last name is empty then ask user again
                if (fName.isEmpty() || lName.isEmpty()) {
                    System.out.println("** Make sure fields are filled out **");
                } else if (numeric) {
                    System.out.println("** Make sure fields are not numeric **");
                }
                //If first and last name has input then capitalize first char of each and store values in name
                else {
                    fName = fName.substring(0, 1).toUpperCase() + fName.substring(1).toLowerCase();
                    lName = lName.substring(0, 1).toUpperCase() + lName.substring(1).toLowerCase();
                    this.name = fName + " " + lName;
                    numeric = false;
                    emptyInput = false;
                }
            }catch (NumberFormatException nfe) {
                numeric = true;
            }
        }
    }

    /**Method calculates if hours worked has over time and stores regular pay and over time pay.
     * @param newHours arg for total hours from user input.
     */
    public void payCheckHours(double newHours){
        this.hours = newHours;

        //Condition if no over time then calculate regular pay
        if (hours > 0 && hours <= 40) {
            this.regularPaid = (hours * salary);
            this.totalPay = regularPaid;
            this.overTimePay = 0;
            this.overTimeHours = 0;
        }
        //if over time then calculate over time pay
        else {
            this.regularPaid = (hours * salary);
            this.overTimeHours = (hours - 40);
            this.overTimePay = (salary * overTimeRate) * overTimeHours;
            this.totalPay = (regularPaid + overTimePay);
        }
    }
}

