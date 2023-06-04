package wage;

public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("principal($1K - $1M): " , 1000 , 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate: " , 1 , 30);
        byte years = (byte) Console.readNumber("period(years): " , 1 , 30);

        MortgageCalculator calculator = new MortgageCalculator(principal,annualInterestRate,years);
        MortgageReport report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }

}
