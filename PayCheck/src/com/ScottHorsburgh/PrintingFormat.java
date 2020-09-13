package com.ScottHorsburgh;

import java.text.NumberFormat;
import java.util.Locale;

public class PrintingFormat {

    /** Default Constructor with no parameters.
     */
    public PrintingFormat(){ }

    /**Method to take in values and print a formatted paycheck for employee.
     * Uses conditionals to format paycheck based on the amounts of regular pay, over time pay & gross pay.
     * @param name arg for employee name
     * @param hours arg for total hours worked
     * @param overTimeHours arg for total hours minus 40
     * @param regularPaid arg for total pay without overtime
     * @param overTimePay arg for just over time pay - regular pay not included
     * @param totalPay arg for regular pay and over time pay combined
     */
    public void printPayCheck(String name , double hours, double overTimeHours, double regularPaid, double overTimePay , double totalPay){
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("\nEmployee name: \t" + name);
        System.out.println("---------------------------------");
        System.out.format("Total hours worked: %13.2f %n", hours);
        System.out.format("Overtime hours worked: %10.2f %n", overTimeHours);

        //------- Condition to format regular pay based on amount -------
        if(totalPay < 100){
            System.out.format("Gross pay: %17s", "");
            System.out.println(currency.format(regularPaid));
        }
        else if(regularPaid >= 100 && regularPaid < 1000){
            System.out.format("Regular pay: %13s", "");
            System.out.println(currency.format(regularPaid));
        }
        else{
            System.out.format("Regular pay: %11s", "");
            System.out.println(currency.format(regularPaid));
        }

        //------- Condition to format over time pay based on amount -------
        if(overTimePay < 100) {
            System.out.format("Overtime pay: %14s", "");
            System.out.println(currency.format(overTimePay));
            System.out.println("---------------------------------");
        }
        else if (overTimePay >= 100 && overTimePay < 1000){
            System.out.format("Overtime pay: %12s", "");
            System.out.println(currency.format(overTimePay));
            System.out.println("---------------------------------");
        }
        else {
            System.out.format("Overtime pay: %10s", "");
            System.out.println(currency.format(overTimePay));
            System.out.println("---------------------------------");
        }

        //------- Condition to format the gross pay based on amount -------
        if(totalPay < 100){
            System.out.format("Gross pay: %17s", "");
            System.out.println(currency.format(totalPay));
        }
        else if(totalPay >= 100 && totalPay < 1000) {
            System.out.format("Gross pay: %15s", "");
            System.out.println(currency.format(totalPay));
        }
        else{
            System.out.format("Gross pay: %12s", "");
            System.out.println(currency.format(totalPay));
        }
    }
}


