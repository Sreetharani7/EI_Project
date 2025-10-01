package Main;

import Factory.Service;
import Factory.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class FactoryDemoApp {
    private static final Logger logger = Logger.getLogger(FactoryDemoApp.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        List<String> serviceHistory = new ArrayList<>();
        double totalBill = 0.0;

        while (!exit) {
            System.out.println("\n===== Beauty Parlour Menu =====");
            System.out.println("1. Haircut (Rs.300)");
            System.out.println("2. Facial (Rs.800)");
            System.out.println("3. Manicure (Rs.500)");
            System.out.println("4. Pedicure (Rs.600)");
            System.out.println("5. Exit & Generate Bill");
            System.out.print("Choose a service: ");

            String choice = scanner.nextLine();
            String serviceName = null;

            switch (choice) {
                case "1": serviceName = "haircut"; break;
                case "2": serviceName = "facial"; break;
                case "3": serviceName = "manicure"; break;
                case "4": serviceName = "pedicure"; break;
                case "5": exit = true;
                          logger.info("Generating final bill...");
                          continue;
                default:
                    System.out.println("Invalid option. Try again.");
                    continue;
            }

            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            Service service = ServiceFactory.getService(serviceName);
            if (service != null) {
                service.performService(customerName);
                double cost = service.getCost();
                totalBill += cost;
                String record = "Service: " + serviceName.toUpperCase() +
                                " | Customer: " + customerName +
                                " | Cost: Rs. " + cost;
                serviceHistory.add(record);

                System.out.println(record);
            } else {
                logger.warning("Service not available.");
            }
        }

        // 🧾 Final Bill Summary
        System.out.println("\n===== FINAL BILL RECEIPT =====");
        if (serviceHistory.isEmpty()) {
            System.out.println("No services availed.");
        } else {
            for (String record : serviceHistory) {
                System.out.println(record);
            }
            System.out.println("---------------------------------");
            System.out.println("TOTAL AMOUNT: Rs. " + totalBill);
            System.out.println("Thank you for visiting Beauty Bliss Parlour!");
        }

        scanner.close();
    }
}
