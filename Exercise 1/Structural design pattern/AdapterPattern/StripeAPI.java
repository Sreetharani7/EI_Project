package AdapterPattern;

public class StripeAPI {
    public void processCharge(String customer, double amount) {
        System.out.println("[Stripe] Charged ₹" + amount + " from " + customer);
    }
}
