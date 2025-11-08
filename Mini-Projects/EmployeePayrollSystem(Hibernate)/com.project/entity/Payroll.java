package com.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double basicPay;
    private double hra;
    private double deductions;
    private double netSalary;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Payroll() {}

    public Payroll(double basicPay, double hra, double deductions, Employee employee) {
        this.basicPay = basicPay;
        this.hra = hra;
        this.deductions = deductions;
        this.employee = employee;
        this.netSalary = (basicPay + hra) - deductions;
    }

    // Getters and Setters
    public int getId() { return id; }
    public double getBasicPay() { return basicPay; }
    public double getHra() { return hra; }
    public double getDeductions() { return deductions; }
    public double getNetSalary() { return netSalary; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    @Override
    public String toString() {
        return "Payroll [ID=" + id + ", BasicPay=" + basicPay + ", HRA=" + hra +
               ", Deductions=" + deductions + ", NetSalary=" + netSalary + "]";
    }
}
