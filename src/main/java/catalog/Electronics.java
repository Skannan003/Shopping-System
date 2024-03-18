package catalog;

public class Electronics extends Product {
    private String warrantyPeriod; // Example specific property

    public Electronics(String id, String name, double price, String warrantyPeriod) {
        super(id, name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    // Getter and setter for warrantyPeriod
    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
}
