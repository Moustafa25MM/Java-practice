package object;


public class Main {

    public static void main(String[] args){

        int principal = (int) console.readNumber("principal($1K - $1M): " , 1000 , 1_000_000);
        float annualInterestRate = (float) console.readNumber("Annual Interest Rate: " , 1 , 30);
        byte years = (byte) console.readNumber("period(years): " , 1 , 30);

        MortgageCalculator calculator = new MortgageCalculator(principal,annualInterestRate,years);
        MortgageReport report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }

}
