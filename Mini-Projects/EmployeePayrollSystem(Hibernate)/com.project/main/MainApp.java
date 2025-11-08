package com.project.main;

import com.project.dao.EmployeeDAO;
import com.project.entity.Employee;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Employee Payroll System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter department: ");
                    String dept = sc.next();
                    System.out.print("Enter salary: ");
                    double sal = sc.nextDouble();

                    dao.saveEmployee(new Employee(name, dept, sal));
                    System.out.println("✅ Employee Added Successfully!");
                }
                case 2 -> dao.getAllEmployees().forEach(System.out::println);
                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();
                    Employee e = dao.getEmployeeById(id);
                    if (e != null) {
                        System.out.print("Enter new salary: ");
                        e.setSalary(sc.nextDouble());
                        dao.updateEmployee(e);
                        System.out.println("✅ Updated Successfully!");
                    } else System.out.println("❌ Employee not found!");
                }
                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    dao.deleteEmployee(sc.nextInt());
                    System.out.println("🗑️ Deleted Successfully!");
                }
            }
        } while (choice != 5);

        sc.close();
        System.out.println("👋 Exiting Payroll System...");
    }
}
