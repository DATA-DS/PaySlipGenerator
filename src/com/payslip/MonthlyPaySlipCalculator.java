package com.payslip;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MonthlyPaySlipCalculator {
    ArrayList<TaxRate> rates = new ArrayList<TaxRate>();
    String userName = null;
    double grossAnnualSalary;
    double grossMonthlySalary;
    double monthlyTax;
    double netMonthlySalary;

    public MonthlyPaySlipCalculator() {
        // Initialize rates by reading Tax rates csv file.(config\TaxRates.csv)

        initializeTaxRates();
    }

    public MonthlyPaySlipCalculator(String userName, double grossAnnualSalary){

        this();
        this.userName = userName;
        this.grossAnnualSalary = grossAnnualSalary;


    }

    public void  initializeTaxRates() {

        try {
            File file = new File("config\\TaxRates.csv");
            //System.out.println(file.getAbsolutePath());
            boolean header = true;
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                if(!header) {
                    rates.add(constructTaxRates(row));
                }
                header = false;
            }
            reader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public TaxRate constructTaxRates(String row){
        //Split the incoming string into two using | as the delimiter.
        String[] tokens = row.split("\\|");
        assert (tokens.length == 2) : "Expected no. of tokens in a row are two but found " + tokens.length;

        //First token should have the taxable range values. Split into two using - as the delimiter.
        String[] taxableIncomeRange = tokens[0].split("-");
        assert (taxableIncomeRange.length == 2) : "Expected no. of values in a taxable income range are two but found " + taxableIncomeRange.length;

        return new TaxRate(FormatterUtility.stringToDouble(taxableIncomeRange[0]) //Income Range Start Value
                , FormatterUtility.stringToDouble(taxableIncomeRange[1]) // Income Range End Value
                , FormatterUtility.stringToDouble(tokens[1])); //Tax Percentage

    }

    public void calculate() {
        double tax = 0;
        for(TaxRate rate :  rates) {

            if(grossAnnualSalary >= rate.getIncomeRangeEndValue()) {
                tax += rate.getIncomeRangeTaxAmount();
            }
            else if (grossAnnualSalary >= rate.getIncomeRangeStartValue() ){
                tax += rate.calculateMaxSlabAmount(rate.incomeRangeStartValue, grossAnnualSalary, rate.getIncomeTaxablePercentage());
            }

        }
        monthlyTax =  tax/12;
        grossMonthlySalary = grossAnnualSalary/12;
        netMonthlySalary = grossMonthlySalary - monthlyTax;
    }

    public void generate(){
        //Output
        System.out.println("\n\n");
        System.out.println("*".repeat(60));
        System.out.print("*".repeat(21));
        System.out.print(" ".repeat(5) + "Payslip" + " ".repeat(5));
        System.out.println("*".repeat(21));
        System.out.println("*".repeat(60));
        System.out.println("Monthly Pay Slip for: " + getUserName());
        System.out.println("Gross Monthly Income: $" + getFormattedGrossMonthlySalary());
        System.out.println("Monthly Income Tax: $" + getFormattedGrossMonthlySalary());
        System.out.println("Net Monthly Income: $" + getFormattedNetMonthlySalary());
        System.out.println("*".repeat(60));
    }

    public ArrayList<TaxRate> getRates() {
        return rates;
    }

    public void setRates(ArrayList<TaxRate> rates) {
        this.rates = rates;
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

    public double getGrossMonthlySalary() {
        return grossMonthlySalary;
    }

    public void setGrossMonthlySalary(double grossMonthlySalary) {
        this.grossMonthlySalary = grossMonthlySalary;
    }

    public double getMonthlyTax() {
        return monthlyTax;
    }

    public void setMonthlyTax(double monthlyTax) {
        this.monthlyTax = monthlyTax;
    }

    public double getNetMonthlySalary() {
        return netMonthlySalary;
    }

    public void setNetMonthlySalary(double netMonthlySalary) {
        this.netMonthlySalary = netMonthlySalary;
    }

    public String getFormattedNetMonthlySalary() {
        return FormatterUtility.doubleToString(getNetMonthlySalary());
    }

    public String getFormattedMonthlyTax() {
        return FormatterUtility.doubleToString(getMonthlyTax());
    }

    public String getFormattedGrossMonthlySalary() {
        return FormatterUtility.doubleToString(getGrossMonthlySalary());
    }

    public String getFormattedGrossAnnualSalary() {
        return FormatterUtility.doubleToString(getGrossAnnualSalary());
    }
}
