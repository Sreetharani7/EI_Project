package Strategy;

import java.util.logging.Logger;

public class PayPalPayment implements PaymentStrategy {
    private static final Logger logger = Logger.getLogger(PayPalPayment.class.getName());
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        logger.info("Paid " + amount + " using PayPal account: " + email);
    }
}
