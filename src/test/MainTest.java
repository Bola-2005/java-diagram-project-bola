package test;

import model.*;

import java.time.LocalDate;

public class MainTest {
    public static void main(String[] args) {

        // 1) Create employees of each type
        HourlyEmployee hourly = new HourlyEmployee(
                1, "Ahmed Ali", Gender.MALE, LocalDate.of(2022, 3, 15),
                50.0, 45.0, 75.0);

        MonthlyEmployee monthly = new MonthlyEmployee(
                2, "Sara Hassan", Gender.FEMALE, LocalDate.of(2019, 6, 1),
                8000.0, 21, 10.0, true);

        CommissionEmployee commission = new CommissionEmployee(
                3, "Omar Khaled", Gender.MALE, LocalDate.of(2021, 1, 10),
                3000.0, 0.05, 40000.0);

        MonthlyEmployee manager = new MonthlyEmployee(
                4, "Mona Adel", Gender.FEMALE, LocalDate.of(2015, 9, 20),
                15000.0, 30, 20.0, true);

        // 2) Create a department with a manager
        Department department = new Department(100, "Sales", manager, null);

        // 3) Add employees to the department
        department.addEmployee(manager);
        department.addEmployee(hourly);
        department.addEmployee(monthly);
        department.addEmployee(commission);

        // 4) Print department info and all employees
        System.out.println(department);
        System.out.println();
        department.printAllEmployees();

        // 5) Total payroll (polymorphism)
        System.out.println();
        System.out.println("Total payroll: " + department.calculateTotalPayroll());

        // 6) Demonstrate other methods
        System.out.println();
        System.out.println("Additional vacation for Sara: "
                + monthly.calculateAdditionalVacation() + " days");
        System.out.println("Omar's commission: " + commission.calculateCommission());

        // 7) Find an employee
        Employee found = department.findEmployee(3);
        System.out.println("Found employee with id 3: "
                + (found != null ? found.getName() : "not found"));

        // 8) Remove an employee and print again
        department.removeEmployee(3);
        System.out.println();
        System.out.println("After removing employee 3:");
        department.printAllEmployees();
        System.out.println("Total payroll: " + department.calculateTotalPayroll());
    }
}