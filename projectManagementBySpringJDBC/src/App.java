import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dbConfig.xml");
        ProductDAO dao = (ProductDAO) context.getBean("productDAO");
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Product Management ===");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Product by ID");
            System.out.println("5. View All Products");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product Name: ");
                    String name = sc.next();
                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();
                    Product newProduct = new Product(0, name, price);
                    dao.save(newProduct);
                    System.out.println("✅ Product Added Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter New Name: ");
                    String uname = sc.next();
                    System.out.print("Enter New Price: ");
                    double uprice = sc.nextDouble();
                    dao.update(new Product(uid, uname, uprice));
                    System.out.println("✅ Product Updated!");
                    break;

                case 3:
                    System.out.print("Enter Product ID to Delete: ");
                    int did = sc.nextInt();
                    dao.delete(did);
                    System.out.println("🗑️ Product Deleted!");
                    break;

                case 4:
                    System.out.print("Enter Product ID: ");
                    int gid = sc.nextInt();
                    Product p = dao.getProductById(gid);
                    System.out.println("Product: " + p);
                    break;

                case 5:
                    List<Product> list = dao.getAllProducts();
                    System.out.println("=== All Products ===");
                    for (Product prod : list) {
                        System.out.println(prod);
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Option!");
            }
        } while (choice != 0);

        sc.close();
    }
}

