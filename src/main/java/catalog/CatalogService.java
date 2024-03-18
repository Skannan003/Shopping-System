package catalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CatalogService {
    private Map<String, Product> products = new HashMap<>();

    // Adds a product to the catalog
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    // Returns a list of all products in the catalog
    public List<Product> listProducts() {
        return new ArrayList<>(products.values());
    }

    // Gets a specific product by ID
    public Product getProduct(String id) {
        return products.get(id);
    }

    // Method to list products by category
    public List<Product> listProductsByCategory(Class<?> categoryClass) {
        return products.values().stream()
                .filter(product -> categoryClass.isInstance(product))
                .collect(Collectors.toList());
    }
}
