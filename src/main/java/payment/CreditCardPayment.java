package payment;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        // Simulate credit card payment processing
        System.out.println("Processing credit card payment for amount: $" + amount);
        return true; // Simulate successful payment
    }
}
