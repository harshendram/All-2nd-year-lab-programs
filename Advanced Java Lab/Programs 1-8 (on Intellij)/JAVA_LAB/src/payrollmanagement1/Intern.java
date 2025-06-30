package payrollmanagement1;


public class Intern extends Employee {
    public double stipend;

    public Intern(double stipend) {
        super("Vanitha", 38, "Assistant");
        this.stipend = stipend;
    }

    public void calculate() {
        salary = stipend;
        System.out.println("Salary of Intern is: " + salary);
    }
}
