package model;

import java.time.LocalDate;

public class CommissionEmployee extends Employee {
    private double baseSalary;
    private double commissionRate;
    private double salesAmount;

    public CommissionEmployee(int id, String name, Gender gender, LocalDate hireDate,
                              double baseSalary, double commissionRate, double salesAmount) {
        super(id, name, gender, hireDate);
        this.baseSalary = baseSalary;
        this.commissionRate = commissionRate;
        this.salesAmount = salesAmount;
    }

    // Commission = sales amount * commission rate (e.g. 0.05 = 5%)
    public double calculateCommission() {
        return salesAmount * commissionRate;
    }

    // Salary = base salary + commission
    @Override
    public double calculateSalary() {
        return baseSalary + calculateCommission();
    }

    // Getters
    public double getBaseSalary() {
        return baseSalary;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    // Setters
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", gender=" + getGender() +
                ", hireDate=" + getHireDate() +
                ", baseSalary=" + baseSalary +
                ", commissionRate=" + commissionRate +
                ", salesAmount=" + salesAmount +
                ", commission=" + calculateCommission() +
                ", salary=" + calculateSalary() +
                '}';
    }
}
