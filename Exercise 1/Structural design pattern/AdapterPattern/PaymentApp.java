package AdapterPattern;

import java.util.Scanner;
import java.util.logging.Logger;

public class PaymentApp {
    private static final Logger logger = Logger.getLogger(PaymentApp.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== SKIN CARE SHOP PAYMENT =====");
            System.out.println("1. Pay with PayPal");
            System.out.println("2. Pay with Stripe");
            System.out.println("3. Exit");
            System.out.print("Choose payment method: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter customer name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amt1 = Double.parseDouble(scanner.nextLine());
                    PaymentGateway paypal = new PayPalAdapter(name1);
                    paypal.pay(amt1);
                    logger.info("Payment via PayPal completed.");
                    break;

                case "2":
                    System.out.print("Enter customer name: ");
                    String name2 = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amt2 = Double.parseDouble(scanner.nextLine());
                    PaymentGateway stripe = new StripeAdapter(name2);
                    stripe.pay(amt2);
                    logger.info("Payment via Stripe completed.");
                    break;

                case "3":
                    exit = true;
                    logger.info("Exiting payment app.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
