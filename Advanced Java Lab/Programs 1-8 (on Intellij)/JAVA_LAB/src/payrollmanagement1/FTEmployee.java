package payrollmanagement1;


public class FTEmployee extends Employee {
    public double basic, hra, da;

    public FTEmployee(double basic, double hra, double da) {
        super("Divya", 30, "Programmer");
        this.basic = basic;
        this.hra = hra;
        this.da = da;
    }

    public void calculate() {
        salary = basic + (hra * basic) + (da * basic);
        System.out.println("Salary of Full Time Employee: " + salary);
    }
}