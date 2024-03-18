package com.yourname.shoppingsystem.auth;

import catalog.CatalogService;
import catalog.Electronics;
import catalog.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CatalogServiceTest {

    private CatalogService catalogService;

    @BeforeEach
    void setUp() {
        catalogService = new CatalogService();
        // Initialize with some products
        catalogService.addProduct(new Electronics("E1", "Laptop", 1200.00, "1 Year Warranty"));
        catalogService.addProduct(new Electronics("E2", "Smartphone", 700.00, "2 Years Warranty"));
    }

    @Test
    void testAddProductAndListProducts() {
        assertEquals(2, catalogService.listProducts().size());

        // Test adding another product
        catalogService.addProduct(new Electronics("E3", "Tablet", 400.00, "1 Year Warranty"));
        assertEquals(3, catalogService.listProducts().size());
    }

    @Test
    void testGetProduct() {
        Product product = catalogService.getProduct("E1");
        assertNotNull(product);
        assertEquals("Laptop", product.getName());

        // Test getting a non-existent product
        assertNull(catalogService.getProduct("NonExistentID"));
    }
}
