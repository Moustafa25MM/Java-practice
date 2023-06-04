package Tax;

public interface TaxCalculator {
    float minimumTax = 100;
    double calculateTax();
    private double getTaxableIncome(double income , double expenses){
        return income - expenses ;
    }
}
