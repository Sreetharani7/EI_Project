package Strategy;

import java.util.logging.Logger;

public class CreditCardPayment implements PaymentStrategy {
    private static final Logger logger = Logger.getLogger(CreditCardPayment.class.getName());
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        logger.info("Paid " + amount + " using Credit Card (ending with " + cardNumber.substring(cardNumber.length() - 4) + ")");
    }
}
