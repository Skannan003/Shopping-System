package payment;

//import payment.CreditCardPayment;

public class PaymentService {
    
	public boolean processPayment(PaymentMethod paymentMethod, String orderId, double amount) {
	    System.out.println("Processing payment for order: " + orderId + " Amount: $" + amount);
	    return paymentMethod.processPayment(amount);
	}


    public static PaymentMethod getPaymentStrategy(PaymentTypeEnum type) {
        switch (type) {
            case CREDIT_CARD:
                return new CreditCardPayment();
            case PAYPAL:
                return new PayPalPayment(); // Assuming you have a PayPalPayment class implemented
            default:
                throw new IllegalArgumentException("Unknown payment method");
        }
    }

      public enum PaymentTypeEnum {
        CREDIT_CARD,
        PAYPAL
    }
}
//    private boolean processCreditCardPayment(double amount) {
//        // Simulate credit card payment processing
//        System.out.println("Processing credit card payment for amount: $" + amount);
//        // Simulate processing delay
//        simulateProcessingDelay();
//        return true;
//    }
//
//    private boolean processPayPalPayment(double amount) {
//        // Simulate PayPal payment processing
//        System.out.println("Processing PayPal payment for amount: $" + amount);
//        // Simulate processing delay
//        simulateProcessingDelay();
//        return true;
////    }
//
//    private void simulateProcessingDelay() {
//        try {
//            Thread.sleep(2000); // Simulate network delay in processing payment
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            // Handle interruption during payment processing
//        }
//    }
//
//    // Checks the payment status for an order
//    public boolean isPaymentSuccessful(String orderId) {
//        System.out.println("Checking payment status for order: " + orderId);
//        return true; // Assuming payment was successful
//    }
//}
