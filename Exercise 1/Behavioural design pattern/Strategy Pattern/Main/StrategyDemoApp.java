package Main;

import Context.PaymentContext;
import Strategy.CreditCardPayment;
import Strategy.PayPalPayment;
import Strategy.UpiPayment;

import java.util.Scanner;
import java.util.logging.Logger;

public class StrategyDemoApp {
    private static final Logger logger = Logger.getLogger(StrategyDemoApp.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext context = new PaymentContext();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== Payment Menu =====");
            System.out.println("1. Pay with Credit Card");
            System.out.println("2. Pay with PayPal");
            System.out.println("3. Pay with UPI");
            System.out.println("4. Exit");
            System.out.print("Choose a payment method: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter card number: ");
                        String card = scanner.nextLine();
                        context.setPaymentStrategy(new CreditCardPayment(card));
                        break;
                    case "2":
                        System.out.print("Enter PayPal email: ");
                        String email = scanner.nextLine();
                        context.setPaymentStrategy(new PayPalPayment(email));
                        break;
                    case "3":
                        System.out.print("Enter UPI ID: ");
                        String upi = scanner.nextLine();
                        context.setPaymentStrategy(new UpiPayment(upi));
                        break;
                    case "4":
                        exit = true;
                        logger.info("Exiting Payment System. Goodbye!");
                        continue;
                    default:
                        System.out.println("Invalid option. Try again.");
                        continue;
                }

                System.out.print("Enter amount to pay: ");
                double amount = Double.parseDouble(scanner.nextLine());
                context.checkout(amount);

            } catch (Exception e) {
                logger.severe("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
