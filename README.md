# PaySlip Generator
Program will prompt to enter the user name and the gross annual salary.
Program then calculates the monthly tax and net monthly income based on the configurable tax rates and will print the output.

### Prerequisites
- JSE11.0.13 
- Check out code from code repository https://github.com/DATA-DS/PaySlipGenerator

### Compile Java Classes
- open cmd
- navigate to git repo folder\src.
 If code repo is cloned from github onto your local machine at C:\test\PayslipGenerator then change the directory to C:\test\PayslipGenerator\src and run the following commands
```
javac com\payslip\FormatterUtility.java
javac com\payslip\TaxRate.java
javac com\payslip\MonthlyPaySlipCalculator.java
javac com\payslip\MonthlyPaySlipGenerator.java
javac com\payslip\MonthlyPaySlipCalculatorTest.java
```

### Test run the program
```
java com.payslip.MonthlyPaySlipCalculatorTest
```
Should return all test cases are passed.

### Run the program
```
java com.payslip.MonthlyPaySlipGenerator
```


