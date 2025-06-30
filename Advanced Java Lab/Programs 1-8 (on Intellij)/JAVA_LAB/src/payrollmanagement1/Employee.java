package payrollmanagement1;

public class Employee implements Payable {
    public String name;
    public int age;
    public String designation;
    public double salary;

    public Employee(String name, int age, String designation) {
        this.name = name;
        this.age = age;
        this.designation = designation;
    }

    public void calculate() {
        salary = 0;
        System.out.println("Salary calculation happens here");
    }
}
