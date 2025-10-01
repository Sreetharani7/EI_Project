package AdapterPattern;

public class PayPalAdapter implements PaymentGateway {
    private final PayPalAPI payPalAPI;
    private final String customerName;

    public PayPalAdapter(String customerName) {
        this.customerName = customerName;
        this.payPalAPI = new PayPalAPI();
    }

    @Override
    public void pay(double amount) {
        payPalAPI.makePayment(customerName, amount);
    }
}
