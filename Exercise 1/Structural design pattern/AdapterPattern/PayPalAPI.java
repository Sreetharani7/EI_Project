package AdapterPattern;

public class PayPalAPI {
    public void makePayment(String customer, double amount) {
        System.out.println("[PayPal] Payment of Rs." + amount + " made by " + customer);
    }
}
