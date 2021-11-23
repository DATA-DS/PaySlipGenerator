package com.payslip;

import java.util.Scanner;

public class MonthlyPaySlipGenerator
{
    private MonthlyPaySlipCalculator paySlip ;
    private String userName;
    private double grossAnnualSalary;

    public static void main(String[] args){
        MonthlyPaySlipGenerator obj = new MonthlyPaySlipGenerator();
        obj.initializeInputParameters();
        obj.generatePayslip();

    }

    public void initializeInputParameters(){
        //Input
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter User Name : ");
        //Set User Name
        setUserName(scanner.nextLine());

        System.out.println("Enter User Annual Salary $: ");
        //Set Gross Annual Salary
        setGrossAnnualSalary(FormatterUtility.stringToDouble(scanner.nextLine()));

    }

    public void generatePayslip(){
        paySlip = new MonthlyPaySlipCalculator(userName , grossAnnualSalary );
        paySlip.calculate();
        paySlip.generate();
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getGrossAnnualSalary() {
        return grossAnnualSalary;
    }

    public void setGrossAnnualSalary(double grossAnnualSalary) {
        this.grossAnnualSalary = grossAnnualSalary;
    }
}
