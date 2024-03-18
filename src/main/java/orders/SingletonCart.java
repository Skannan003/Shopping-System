package orders;

import catalog.Product;
import java.util.ArrayList;
import java.util.List;

public class SingletonCart {
    private static SingletonCart instance;
    private List<Product> products = new ArrayList<>();

    private SingletonCart() {}

    public static SingletonCart getInstance() {
        if (instance == null) {
            instance = new SingletonCart();
        }
        return instance;
    }

    // Add a product to the cart
    public void addProduct(Product product) {
        products.add(product);
    }

    // Remove a product from the cart based on product ID
    public boolean removeProduct(String productId) {
        return products.removeIf(product -> product.getId().equals(productId));
    }

    // Calculate the total cost of all products in the cart
    public double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    // Get all products in the cart
    public List<Product> getProducts() {
        return new ArrayList<>(products); // Return a copy of the products list
    }

    // List (print) all products in the cart
    public void listCartContents() {
        if (products.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Products in your cart:");
            for (Product product : products) {
                System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
            }
        }
    }

    // Clear the cart
    public void clear() {
        products.clear();
    }
}
