package com.yourname.shoppingsystem;

import auth.AuthService;
import catalog.*;
import orders.*;
import payment.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        AuthService authService = new AuthService();
        CatalogService catalogService = new CatalogService();
        PaymentService paymentService = new PaymentService(); // Make sure this constructor aligns with your implementation
        SingletonCart cart = SingletonCart.getInstance();

        Scanner scanner = new Scanner(System.in);

        // User registration and login
        userRegistrationAndLogin(authService, scanner);

        // Populate the catalog with some products
        populateCatalog(catalogService);

        boolean shopping = true;
        while (shopping) {
            System.out.println("\nSelect a category to browse:");
            System.out.println("1: Electronics\n2: Clothes\n3: Furniture\n4: Review Cart & Checkout\n5: Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    browseAndAddToCart(catalogService, cart, scanner, Electronics.class);
                    break;
                case 2:
                    browseAndAddToCart(catalogService, cart, scanner, Clothes.class);
                    break;
                case 3:
                    browseAndAddToCart(catalogService, cart, scanner, Furniture.class);
                    break;
                case 4:
                    shopping = false;
                    cart.listCartContents(); // Let users review their cart
                    checkout(cart, paymentService, scanner); // Proceed to checkout
                    break;
                case 5:
                    System.out.println("Exiting...");
                    shopping = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid category, review cart & checkout, or exit.");
            }
        }
        scanner.close();
    }

    private static void userRegistrationAndLogin(AuthService authService, Scanner scanner) {
        System.out.println("Welcome to the Shopping System!");
        System.out.println("Please register.");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        authService.registerUser(username, password);

        System.out.println("Now, please login.");
        System.out.print("Username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Password: ");
        String loginPassword = scanner.nextLine();

        if (authService.login(loginUsername, loginPassword)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
            System.exit(0); // Exit or handle accordingly
        }
    }

    private static void populateCatalog(CatalogService catalogService) {
        // Assuming these constructors and method exist. Adjust according to your actual classes.
        catalogService.addProduct(new Electronics("E1", "TV", 399.99, "1 year warranty"));
        catalogService.addProduct(new Electronics("E2", "Watch", 399.99, "2 year warranty"));
        catalogService.addProduct(new Clothes("C1", "T-Shirt", 19.99, "M", "Cotton"));
        catalogService.addProduct(new Clothes("C2", "Jeans", 19.99, "L", "Cotton"));
        catalogService.addProduct(new Furniture("F1", "Chair", 99.99, "Wood"));
        catalogService.addProduct(new Furniture("F2", "Table", 99.99, "Wood"));
        
        
    }

    private static void browseAndAddToCart(CatalogService catalogService, SingletonCart cart, Scanner scanner, Class<?> category) {
        List<Product> products = catalogService.listProductsByCategory(category);
        if (products.isEmpty()) {
            System.out.println("No products found in this category.");
            return;
        }

        products.forEach(product -> System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice()));
        System.out.println("Enter the ID of the product you want to add to your cart (or type 'back' to return):");
        String input = scanner.nextLine();

        if (!"back".equalsIgnoreCase(input)) {
            Product productToAdd = catalogService.getProduct(input);
            if (productToAdd != null) {
                cart.addProduct(productToAdd);
                System.out.println(productToAdd.getName() + " added to cart.");
            } else {
                System.out.println("Product with ID " + input + " not found.");
            }
        }
    }

    private static void checkout(SingletonCart cart, PaymentService paymentService, Scanner scanner) {
        System.out.println("Proceeding to checkout...");
        double totalAmount = cart.calculateTotal();
        System.out.println("Total amount: $" + totalAmount);

        System.out.println("Choose payment method: 1 for CREDIT_CARD, 2 for PAYPAL");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        boolean paymentResult = false;
        if (paymentChoice == 1) {
            paymentResult = paymentService.processPayment(new CreditCardPayment(), "ORD12345", totalAmount);
        } else if (paymentChoice == 2) {
            paymentResult = paymentService.processPayment(new PayPalPayment(), "ORD12345", totalAmount);
        }

        if (paymentResult) {
            System.out.println("Order placed and payment processed successfully!");
        } else {
            System.out.println("There was a problem processing your payment.");
        }

        scanner.close();
    }
}
