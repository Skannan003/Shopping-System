package catalog;

public class Clothes extends Product {
    private String size; // Example specific property
    private String material; // Another example specific property

    public Clothes(String id, String name, double price, String size, String material) {
        super(id, name, price);
        this.size = size;
        this.material = material;
    }

    // Getters and setters for size and material
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
