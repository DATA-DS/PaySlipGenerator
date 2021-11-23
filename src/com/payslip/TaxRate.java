package com.payslip;

public class TaxRate {
    double incomeRangeStartValue;
    double incomeRangeEndValue;
    double incomeTaxablePercentage;
    double incomeRangeTaxAmount;

    public TaxRate(double incomeRangeStartValue , double incomeRangeEndValue, double incomeTaxablePercentage) {
        this.incomeRangeStartValue = incomeRangeStartValue;
        this.incomeRangeEndValue = incomeRangeEndValue;
        this.incomeTaxablePercentage = incomeTaxablePercentage/100;
        this.incomeRangeTaxAmount = calculateMaxSlabAmount(this.incomeRangeStartValue, this.incomeRangeEndValue , this.incomeTaxablePercentage);
    }

    public double calculateMaxSlabAmount(double incomeRangeStartValue , double incomeRangeEndValue, double incomeTaxablePercentage){
        return ( incomeRangeEndValue - (incomeRangeStartValue-1) ) * (incomeTaxablePercentage);
    }



    public double getIncomeRangeStartValue() {
        return incomeRangeStartValue;
    }

    public void setIncomeRangeStartValue(double incomeRangeStartValue) {
        this.incomeRangeStartValue = incomeRangeStartValue;
    }

    public double getIncomeRangeEndValue() {
        return incomeRangeEndValue;
    }

    public void setIncomeRangeEndValue(double incomeRangeEndValue) {
        this.incomeRangeEndValue = incomeRangeEndValue;
    }

    public double getIncomeTaxablePercentage() {
        return incomeTaxablePercentage;
    }

    public void setIncomeTaxablePercentage(double incomeTaxablePercentage) {
        this.incomeTaxablePercentage = incomeTaxablePercentage;
    }

    public double getIncomeRangeTaxAmount() {
        return incomeRangeTaxAmount;
    }

    public void setIncomeRangeTaxAmount(double incomeRangeTaxAmount) {
        this.incomeRangeTaxAmount = incomeRangeTaxAmount;
    }

    @Override
    public String toString() {
        return "TaxRate{" +
                "startVal=" + incomeRangeStartValue +
                ", endVal=" + incomeRangeEndValue +
                ", percentage=" + incomeTaxablePercentage +
                ", maxAmount=" + incomeRangeTaxAmount +
                '}';
    }
}
