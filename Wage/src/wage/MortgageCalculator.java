package wage;

public class MortgageCalculator {

    private final static byte PERCENT = 100;
    private final static byte MONTHS_IN_YEAR = 12;
    private  int principal;
    private  float annualInterestRate;
    private  byte years;

    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }
    public  double calculateMortgage() {
        float monthlyInterestRate = getMonthlyInterestRate();
        int months = getMonths();

        return principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months))
                / (Math.pow(1 + monthlyInterestRate, months) - 1);
    }
    public  double calculateLoanBalance(int paymentMade){
        float monthlyInterestRate = getMonthlyInterestRate();
        int months = getMonths();

        return principal
                * (Math.pow(1 + monthlyInterestRate, months) - Math.pow(1 + monthlyInterestRate, paymentMade))
                / (Math.pow(1 + monthlyInterestRate, months) - 1);
    }
    public double[] getRemainingBalances() {
        double[] balance = new double[getMonths()];
        for (int month = 1; month <= getMonths(); month++) {
             balance[month - 1] = calculateLoanBalance(month);
        }
        return balance;
    }
    private int getMonths() {
        return  years * MONTHS_IN_YEAR;
    }
    private float getMonthlyInterestRate() {
        return annualInterestRate / PERCENT / MONTHS_IN_YEAR;
    }
}
