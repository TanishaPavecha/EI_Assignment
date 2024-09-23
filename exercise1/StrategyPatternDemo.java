// Strategy interface for payment
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete strategy for Credit Card payment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

// Concrete strategy for PayPal payment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal: " + email);
    }
}

// Context class that accepts the strategy
class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Demonstration
public class StrategyPatternDemo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        // Using Credit Card strategy
        processor.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        processor.processPayment(150.00);

        // Switching to PayPal strategy
        processor.setPaymentStrategy(new PayPalPayment("user@example.com"));
        processor.processPayment(90.50);
    }
}
