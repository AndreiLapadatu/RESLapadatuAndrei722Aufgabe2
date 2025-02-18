package View;

import Controller.CharakterenController;
import Controller.ProduktenController;
import Model.Charakteren;
import Model.Produkten;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {


    private Scanner scanner;
    private CharakterenController charakterenController;
    private ProduktenController produktenController;

    public ConsoleView( CharakterenController charakterenController, ProduktenController produktenController) {
        this.scanner = new Scanner(System.in);
        this.charakterenController = charakterenController;
        this.produktenController = produktenController;
    }

    public void start(){
        boolean running = true;
        while(running){
            System.out.println("\n--- Shinobi ---");
            System.out.println("1. Manage Produkt");
            System.out.println("2. Manage Charakter");
            System.out.println("3. Filter Charakter by Dorf");
            //System.out.println("4. Sort Patient Medicament");
            System.out.println("4. View Produkt and Charakter by Region");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    manageProducts();
                    break;
                case 2:
                    manageCustomers();
                    break;
                case 3:
                    filter1();
                    break;
                case 4:
                    filter2();
                    break;

                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }


        }
    }

    private void addProduct() {
        System.out.print("Enter Produkt name: ");
        String name = scanner.nextLine();
        System.out.print("Enter produkt price: ");
        double price = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter region: ");
        String region = scanner.nextLine();

        produktenController.addProdukt(name, price, region);
        System.out.println("Product added successfully.");
    }

    private void addCustomer() {
        System.out.print("Enter Charakter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Charakter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Dorf: ");
        String dorf = scanner.nextLine();

        charakterenController.addCharakter(id, name, dorf);
        System.out.println("Charakter added successfully.");
    }

    private void updateProduct() {
        System.out.print("Enter Produkt name to update: ");
        String name = scanner.nextLine();
        System.out.print("Enter  price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter region: ");
        String season = scanner.nextLine();

        produktenController.updateProdukt(name, price, season);
        System.out.println("Product updated successfully.");
    }

    private void deleteProduct() {
        System.out.print("Enter produkt name to delete: ");
        String name = scanner.nextLine();

        produktenController.deleteProdukt(name);
        System.out.println("Product deleted successfully.");
    }

    private void viewProduct() {
        System.out.print("Enter product name to view: ");
        String name = scanner.nextLine();

        Produkten produkt = produktenController.getProdukt(name);
        if (produkt != null) {
            System.out.println(produkt);
        } else {
            System.out.println("Product not found.");
        }
    }

    private void viewAllProducts() {
        List<Produkten> produkten = produktenController.getAllProdukten();
        if (produkten.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Produkten produkt : produkten) {
                System.out.println(produkt);
            }
        }
    }


    private void manageProducts() {
        boolean managing = true;
        while (managing) {
            System.out.println("\n--- Manage Products ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Product");
            System.out.println("5. View All Products");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    viewProduct();
                    break;
                case 5:
                    viewAllProducts();
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }



    private void updateCustomer() {
        System.out.print("Enter charakter ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new dorf: ");
        String diagnose = scanner.nextLine();

        charakterenController.updateCharakter(id, name, diagnose);
        System.out.println("Customer updated successfully.");
    }

    private void deleteCustomer() {
        System.out.print("Enter charakter ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        charakterenController.deleteCharakter(id);
        System.out.println("charakter deleted successfully.");
    }

    private void viewCustomer() {
        System.out.print("Enter charakter ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Charakteren charakteren = charakterenController.getCharakter(id);
        if (charakteren != null) {
            System.out.println(charakteren);
        } else {
            System.out.println("charkater not found.");
        }
    }

    private void viewAllCustomers() {
        List<Charakteren> charakteren = charakterenController.getAllCharakteren();
        if (charakteren.isEmpty()) {
            System.out.println("No charakter found.");
        } else {
            for (Charakteren customer : charakteren) {
                System.out.println(customer);
            }
        }
    }

    private void addProductToCustomer() {
        System.out.print("Enter charakter ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter produkt name: ");
        String productName = scanner.nextLine();

        Produkten produkt = produktenController.getProdukt(productName);
        if (produkt != null) {
            charakterenController.addProduktToCharakter(customerId, produkt);
            System.out.println("Product added to Charakter successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private void manageCustomers() {
        boolean managing = true;
        while (managing) {
            System.out.println("\n--- Manage Customers ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. View Customer");
            System.out.println("5. View All Customers");
            System.out.println("6. Add Product to Customer");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    updateCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    viewCustomer();
                    break;
                case 5:
                    viewAllCustomers();
                    break;
                case 6:
                    addProductToCustomer();
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void filter1() {
        System.out.print("Enter dorf to filter charakter: ");
        String dorf = scanner.nextLine();

        List<Charakteren> filteredCustomers = charakterenController.filterCharakterNachDorf(dorf);
        if (filteredCustomers.isEmpty()) {
            System.out.println("No customers found in the specified location.");
        } else {
            for (Charakteren customer : filteredCustomers) {
                System.out.println(customer);
            }
        }
    }

    private void filter2(){
        System.out.println("Enter charakter ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter region name: ");
        String region = scanner.nextLine();

        List<Charakteren> filteredPatiens = charakterenController.filterCharakterbyDorf(customerId, region);
        if(filteredPatiens.isEmpty()) {
            System.out.println("No patients found for the specified customer.");
        }else{
            for(Charakteren charakteren : filteredPatiens) {
                System.out.println(charakteren);
            }
        }
    }
}
