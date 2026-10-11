package model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private int id;
    private String name;
    private Employee manager;
    private List<Employee> employees;

    public Department(int id, String name, Employee manager, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.employees = (employees != null) ? employees : new ArrayList<>();
        // Link each employee to this department
        for (Employee e : this.employees) {
            e.setDepartment(this);
        }
    }

    // Adds an employee to the department and links them to it
    public void addEmployee(Employee employee) {
        if (employee != null && !employees.contains(employee)) {
            employees.add(employee);
            employee.setDepartment(this);
        }
    }

    // Removes the employee with the given id from the department
    public void removeEmployee(int employeeId) {
        Employee employee = findEmployee(employeeId);
        if (employee != null) {
            employees.remove(employee);
            employee.setDepartment(null);
        }
    }

    // Returns the employee with the given id, or null if not found
    public Employee findEmployee(int employeeId) {
        for (Employee e : employees) {
            if (e.getId() == employeeId) {
                return e;
            }
        }
        return null;
    }

    // Sums the salaries of all employees (polymorphism: each type calculates its own)
    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary();
        }
        return total;
    }

    // Prints all employees in the department
    public void printAllEmployees() {
        System.out.println("Employees in department " + name + ":");
        if (employees.isEmpty()) {
            System.out.println("  (no employees)");
            return;
        }
        for (Employee e : employees) {
            System.out.println("  " + e);
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employee getManager() {
        return manager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager=" + (manager != null ? manager.getName() : "None") +
                ", employeesCount=" + employees.size() +
                '}';
    }
}