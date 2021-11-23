package com.payslip;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormatterUtility {

    static DecimalFormat df = new DecimalFormat("#,###,##0.00");

    public static double stringToDouble(String str) {
        double value = 0;
        try{
            value =  df.parse(str).doubleValue();
        }
        catch(Exception e){
            e.printStackTrace();
            //System.exit(0);
        }
        return value;

    }

    public static String doubleToString(double value) {
        String formattedValue = null;
        try{
            formattedValue =  df.format(value);
        }
        catch(Exception e){
            e.printStackTrace();
            //System.exit(0);
        }
        return formattedValue;

    }
}
