package object;

public class Employee {
    private int baseSalary;
    private int hourlyRate;
    private static int numberOfEmployees;


    public Employee(int baseSalary , int hourlyRate){
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees ++ ;
    }
    public Employee(int baseSalary){
        this(baseSalary,0);
    }
    public static void printNumberOfEmployees(){
        System.out.println(numberOfEmployees);
    }

    public int calculateWage(int extraHours){
        return baseSalary + (hourlyRate * extraHours);
    }
    public int calculateWage(){
        return calculateWage(0) ;
    }
    private void setBaseSalary(int baseSalary){
        if(baseSalary < 0)
            throw new IllegalArgumentException("base salary must be greater than 0");
        this.baseSalary = baseSalary;
    }
    private void setHourlyRate(int hourlyRate){
        if(hourlyRate < 0 )
            throw new IllegalArgumentException("hourly rate should be greater than 0");
        this.hourlyRate = hourlyRate;
    }

    private int getHourlyRate() {
        return hourlyRate;
    }

    private int getBaseSalary() {
        return baseSalary;
    }
}
