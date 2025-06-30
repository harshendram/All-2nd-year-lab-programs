package payrollmanagement1;


public class PTEmployee extends Employee {
    public int hours;
    public double hr_wage;

    public PTEmployee(int hours, double hr_wage) {
        super("Kapil", 50, "Team Lead");
        this.hours = hours;
        this.hr_wage = hr_wage;
    }

    public void calculate() {
        salary = hours * hr_wage;
        System.out.println("Salary of Part Time Employee: " + salary);
    }
}
