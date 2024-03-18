package orders;

import catalog.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private String orderId;
    private List<Product> items;
    private double totalAmount;

    public Order() {
        this.orderId = UUID.randomUUID().toString();
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addItem(Product product) {
        items.add(product);
        totalAmount += product.getPrice();
    }

    public String getOrderId() {
        return orderId;
    }

    public List<Product> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public enum OrderStatus {
        PENDING, SHIPPED, DELIVERED, CANCELLED
    }
}

