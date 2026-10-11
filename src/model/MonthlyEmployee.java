package model;

import java.time.LocalDate;
import java.time.Period;

public class MonthlyEmployee extends Employee {
    private double monthlySalary;
    private int vacationDays;
    private double bonusPercentage;
    private boolean hasHealthInsurance;

    public MonthlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                           double monthlySalary, int vacationDays,
                           double bonusPercentage, boolean hasHealthInsurance) {
        super(id, name, gender, hireDate);
        this.monthlySalary = monthlySalary;
        this.vacationDays = vacationDays;
        this.bonusPercentage = bonusPercentage;
        this.hasHealthInsurance = hasHealthInsurance;
    }

    // Salary = monthly salary + bonus (percentage of the monthly salary)
    @Override
    public double calculateSalary() {
        return monthlySalary + (monthlySalary * bonusPercentage / 100);
    }

    // 1 extra vacation day for every 2 full years of service
    public int calculateAdditionalVacation() {
        int yearsOfService = Period.between(getHireDate(), LocalDate.now()).getYears();
        return yearsOfService / 2;
    }

    // Getters
    public double getMonthlySalary() {
        return monthlySalary;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public boolean isHasHealthInsurance() {
        return hasHealthInsurance;
    }

    // Setters
    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public void setBonusPercentage(double bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }

    public void setHasHealthInsurance(boolean hasHealthInsurance) {
        this.hasHealthInsurance = hasHealthInsurance;
    }

    @Override
    public String toString() {
        return "MonthlyEmployee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", gender=" + getGender() +
                ", hireDate=" + getHireDate() +
                ", monthlySalary=" + monthlySalary +
                ", vacationDays=" + vacationDays +
                ", additionalVacation=" + calculateAdditionalVacation() +
                ", bonusPercentage=" + bonusPercentage +
                ", hasHealthInsurance=" + hasHealthInsurance +
                ", salary=" + calculateSalary() +
                '}';
    }
}