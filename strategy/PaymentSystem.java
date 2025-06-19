
/*When to use the Strategy Pattern:

When you have multiple ways to do something, and you want to choose the right one dynamically.
When you want to avoid long if-else or switch statements for different behaviors.
When you want to separate different behaviors and make them easily extendable without changing existing code.

*/



// Strategy interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card ending with " + cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account: " + email);
    }
}

class BitcoinPayment implements PaymentStrategy {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Bitcoin wallet: " + walletAddress);
    }
}

// Context class
class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment method selected!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

// Driver class
public class PaymentSystem {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        System.out.println("Paying with Credit Card...");
        paymentProcessor.setPaymentStrategy(new CreditCardPayment("1234567812345678"));
        paymentProcessor.checkout(100.50);

        System.out.println("\nPaying with PayPal...");
        paymentProcessor.setPaymentStrategy(new PayPalPayment("user@example.com"));
        paymentProcessor.checkout(200.75);

        System.out.println("\nPaying with Bitcoin...");
        paymentProcessor.setPaymentStrategy(new BitcoinPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"));
        paymentProcessor.checkout(300.00);
    }
}
