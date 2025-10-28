package com.example.product.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.product.config.AppConfig;
import com.example.product.dao.ProductDAO;
import com.example.product.model.Product;

import java.util.*;

public class ProductApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductDAO dao = ctx.getBean(ProductDAO.class);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== PRODUCT MANAGEMENT ===");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Category: ");
                    String cat = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    dao.addProduct(new Product(name, cat, price));
                    System.out.println("✅ Product Added!");
                    break;

                case 2:
                    dao.getAllProducts().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    System.out.print("New Name: ");
                    String n = sc.nextLine();
                    System.out.print("New Category: ");
                    String c = sc.nextLine();
                    System.out.print("New Price: ");
                    double p = sc.nextDouble();
                    dao.updateProduct(new Product(n, c, p) {{ setId(uid); }});
                    System.out.println("✅ Updated!");
                    break;

                case 4:
                    System.out.print("Enter ID to Delete: ");
                    int id = sc.nextInt();
                    dao.deleteProduct(id);
                    System.out.println("🗑️ Deleted!");
                    break;

                case 5:
                    System.out.println("👋 Exiting...");
                    System.exit(0);
            }
        }
    }
}

