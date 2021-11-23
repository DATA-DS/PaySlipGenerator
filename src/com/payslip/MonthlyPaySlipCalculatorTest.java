package com.payslip;

import java.util.HashMap;

public class MonthlyPaySlipCalculatorTest {
    private MonthlyPaySlipCalculator test = null;

    public static void main(String args[]) {
        MonthlyPaySlipCalculatorTest obj = new MonthlyPaySlipCalculatorTest();
        obj.testRange1(); //0-20000
        obj.testRange2(); //20001-40000
        obj.testRange3(); //40001 - 80000
        obj.testRange4(); //80001 - 180000
        obj.testRange5(); // > 180000
        System.out.println("All test cases passed");
    }

    public String getErrorMessage(String expectedValue, String calculatedValue, String grossAnnualSalary, String field) {
        return field + " Monthly Salary Calc failed for gross annual salary $" + grossAnnualSalary
                + " expected $" + expectedValue + " : calc value $" + calculatedValue;
    }

    //Test the tax values for range 0-20000
    public void testRange1() {

        //min value 0
        double grossAnnualSalary = 0;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        String expVal = "0.00";
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expVal) == 0) : getErrorMessage(expVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expVal) == 0) : getErrorMessage(expVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");
        //max value 20000
        grossAnnualSalary = 20000;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expVal = "1,666.67";
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expVal) == 0) : getErrorMessage(expVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expVal) == 0) : getErrorMessage(expVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //salary with decimal points
        grossAnnualSalary = 12500.75;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expVal = "1,041.73";
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expVal) == 0) : getErrorMessage(expVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expVal) == 0) : getErrorMessage(expVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //salary with decimal points and rounds the decimal value.
        grossAnnualSalary = 9878.34;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expVal = "823.20";
        // round the decimail value
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expVal) == 0) : getErrorMessage(expVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expVal) == 0) : getErrorMessage(expVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");


    }

    //Test the tax values for range 20001-40000
    public void testRange2() {

        //min value 20001
        double grossAnnualSalary = 20001;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        String expGrossVal = "1,666.75";
        String expNetVal = "1,666.74";

        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //max value 40000
        grossAnnualSalary = 40000;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expGrossVal = "3,333.33";
        expNetVal = "3,166.67";
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //salary with decimal points
        grossAnnualSalary = 26789.95;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expGrossVal = "2,232.50";
        expNetVal = "2,175.91";
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //salary with decimal points
        grossAnnualSalary = 39009.68;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expGrossVal = "3,250.81";
        expNetVal = "3,092.39";
        // round the decimail value
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

    }

    //Test the tax values for range 40001-80000
    public void testRange3() {

        //min value 40001
        double grossAnnualSalary = 40001;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        String expGrossVal = "3,333.42";
        String expNetVal = "3,166.73";

        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //max value 40000
        grossAnnualSalary = 80000;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expGrossVal = "6,666.67";
        expNetVal = "5,833.33";
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //salary with decimal points
        grossAnnualSalary = 75134.39;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expGrossVal = "6,261.20";
        expNetVal = "5,508.96";
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //salary with decimal points
        grossAnnualSalary = 64999.60;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expGrossVal = "5,416.63";
        expNetVal = "4,833.31";
        // round the decimail value
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //salary with decimal points
        grossAnnualSalary = 60000.00;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expGrossVal = "5,000.00";
        expNetVal = "4,500.00";
        // round the decimail value
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");




    }

    //Test the tax values for range 80001-180000
    public void testRange4() {

        //min value 80001
        double grossAnnualSalary = 80001;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        String expGrossVal = "6,666.75";
        String expNetVal = "5,833.39";

        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //max value 40000
        grossAnnualSalary = 180000;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expGrossVal = "15,000.00";
        expNetVal = "11,666.67";
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //salary with decimal points
        grossAnnualSalary = 125000.39;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expGrossVal = "10,416.70";
        expNetVal = "8,458.36";
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //salary with decimal points
        grossAnnualSalary = 99999.99;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expGrossVal = "8,333.33";
        expNetVal = "7,000.00";
        // round the decimail value
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

    }

    //Test the tax values for range >180000
    public void testRange5() {

        //min value 80001
        double grossAnnualSalary = 180001;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        String expGrossVal = "15,000.08";
        String expNetVal = "11,666.72";

        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //higher salary 780,000
        grossAnnualSalary = 780000;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expGrossVal = "65,000.00";
        expNetVal = "41,666.67";
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //1.34m salary with decimal points
        grossAnnualSalary = 1340078.12;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expGrossVal = "111,673.18";
        expNetVal = "69,670.57";
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

        //25m salary with decimal points
        grossAnnualSalary = 25341234.50;
        test = new MonthlyPaySlipCalculator("ABC DEF", grossAnnualSalary);
        test.calculate();
        expGrossVal = "2,111,769.54";
        expNetVal = "1,269,728.39";
        // round the decimail value
        assert (test.getFormattedGrossMonthlySalary().compareToIgnoreCase(expGrossVal) == 0) : getErrorMessage(expGrossVal, test.getFormattedGrossMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Gross");
        assert (test.getFormattedNetMonthlySalary().compareToIgnoreCase(expNetVal) == 0) : getErrorMessage(expNetVal, test.getFormattedNetMonthlySalary(), test.getFormattedGrossAnnualSalary(), "Net");

    }
}
