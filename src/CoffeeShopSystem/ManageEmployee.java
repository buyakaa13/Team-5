package CoffeeShopSystem;

import java.util.ArrayList;
import java.util.List;
public class ManageEmployee {
    private List<Employee> employeeList;

    public ManageEmployee() {
        employeeList = new ArrayList<>();
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println("Employee added: " + employee);
    }

    // Update employee (not covered in our use case but we can add if we have time)
    public void updateEmployee(String employeeId, String firstName, String lastName, String username) {
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId().equals(employeeId)) {
                emp.setFirstName(firstName);
                emp.setLastName(lastName);
                emp.setUsername(username);
                System.out.println("Employee updated: " + emp);
                return;
            }
        }
        System.out.println("Employee not found with ID: " + employeeId);
    }

    // remove employee (not covered in our use case but we can add if we have time)
    public void removeEmployee(String employeeId) {
        employeeList.removeIf(emp -> emp.getEmployeeId().equals(employeeId));
        System.out.println("Employee removed with ID: " + employeeId);
    }

    // view all employees
    public void listEmployees() {
        System.out.println("Listing all employees:");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }

}
