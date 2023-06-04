package object;

import java.text.NumberFormat;

public class Mortgage {
    private int principal;
    private float annualInterestRate;
    private int years;

    final static byte PERCENT = 100;
    final static byte MONTHS_IN_YEAR = 12;

    public Mortgage(int principal , float annualInterestRate , int years){
        setPrincipal(principal);
        setAnnualInterestRate(annualInterestRate);
        setYears(years);
    }
    private void setPrincipal(int principal){
        if(principal >= 1000 && principal <= 1_000_000)
            this.principal = principal;
        else
             throw new IllegalArgumentException("enter a number between 1000 and 1M");
    }
    private void setAnnualInterestRate(float annualInterestRate) {
        if(annualInterestRate >= 1 && annualInterestRate <= 30)
            this.annualInterestRate = annualInterestRate;
        else
            throw new IllegalArgumentException("enter a number between 1 and 30");
    }

    private void setYears(int years) {
        if(years >= 1 && years <= 30)
            this.years = years;
        else
            throw new IllegalArgumentException("enter a number between 1 and 30");
    }
    public double calculateMortgage(){
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int months = years * MONTHS_IN_YEAR ;

        return principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months))
                / (Math.pow(1 + monthlyInterestRate, months) - 1);
    }
    private double calculateLoanBalance(int paymentMade){
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int months = years * MONTHS_IN_YEAR ;

        return principal
                * (Math.pow(1+monthlyInterestRate , months) - Math.pow(1+monthlyInterestRate , paymentMade))
                / (Math.pow(1+monthlyInterestRate , months ) - 1) ;
    }
    public void printMortgage(String mortgageFormatted) {
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("________");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
    public void printPaymentSchedule(){
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");
        for(short month = 1; month <= years * MONTHS_IN_YEAR ; month++){
            double loanBalance = calculateLoanBalance(month);
            String loan = NumberFormat.getCurrencyInstance().format(loanBalance);
            System.out.println(loan);
        }
    }
}
