package catalog;

public class Furniture extends Product {
    private String material;

    public Furniture(String id, String name, double price, String material) {
        super(id, name, price);
        this.material = material;
    }

    // Getter and setter for material
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}

