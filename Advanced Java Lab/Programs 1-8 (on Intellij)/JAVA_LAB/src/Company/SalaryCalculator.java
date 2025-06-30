//package Company;
//
//
//import payrollmanagement1.*;
//
//public class SalaryCalculator {
//    public static void main(String[] args) {
//        Employee[] e = new Employee[3];
//
//        e[0] = new FTEmployee(25000, 0.3, 1.75);
//        e[0].calculate();
//
//        e[1] = new PTEmployee(3, 4000);
//        e[1].calculate();
//
//        e[2] = new Intern(30000);
//        e[2].calculate();
//    }
//}

package Company;

import payrollmanagement1.*;
import java.util.*;

public class SalaryCalculator {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();

        employeeList.add(new FTEmployee(25000, 0.3, 1.75));
        employeeList.add(new PTEmployee(3, 4000));
        employeeList.add(new Intern(30000));

        for (Employee e : employeeList) {
            e.calculate();
        }
    }
}
