package AdapterPattern;

public class PayPalAPI {
    public void makePayment(String customer, double amount) {
        System.out.println("[PayPal] Payment of ₹" + amount + " made by " + customer);
    }
}
