package com.yourname.shoppingsystem.auth;

import orders.Order;
import orders.OrderService;
import logging.Logger; // Ensure correct import
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import catalog.Electronics; // Adjust import based on your structure

class OrderServiceTest {

    private OrderService orderService;
    private Order order;
    private Logger logger;

    @BeforeEach
    void setUp() {
        // Provide a log file path when getting the Logger instance
        logger = Logger.getInstance("testLog.log");

        orderService = new OrderService(logger);

        order = new Order();
        order.addItem(new Electronics("1", "Laptop", 1200.00, "1 Year Warranty"));
        order.addItem(new Electronics("2", "Mouse", 25.00, "2 Year Warranty"));
    }

    @Test
    void testPlaceOrder() {
        orderService.placeOrder(order);
        assertEquals(1225.00, order.getTotalAmount(), "The total amount should match the sum of the product prices.");
    }
}
