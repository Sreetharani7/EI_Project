package Strategy;

import java.util.logging.Logger;

public class UpiPayment implements PaymentStrategy {
    private static final Logger logger = Logger.getLogger(UpiPayment.class.getName());
    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        logger.info("Paid " + amount + " using UPI ID: " + upiId);
    }
}
