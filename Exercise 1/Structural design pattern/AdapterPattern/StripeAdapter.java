package AdapterPattern;

public class StripeAdapter implements PaymentGateway {
    private final StripeAPI stripeAPI;
    private final String customerName;

    public StripeAdapter(String customerName) {
        this.customerName = customerName;
        this.stripeAPI = new StripeAPI();
    }

    @Override
    public void pay(double amount) {
        stripeAPI.processCharge(customerName, amount);
    }
}
