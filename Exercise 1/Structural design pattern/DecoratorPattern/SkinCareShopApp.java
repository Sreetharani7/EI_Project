package DecoratorPattern;
import java.util.Scanner;
import java.util.logging.Logger;

public class SkinCareShopApp {
    private static final Logger LOGGER = LoggerUtil.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Receipt receipt = new Receipt();
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("\n===== SKIN CARE SHOP MENU =====");
                System.out.println("1. Buy Base Product");
                System.out.println("2. Add Aloe Vera");
                System.out.println("3. Add Vitamin C");
                System.out.println("4. Add Anti-Aging Serum");
                System.out.println("5. Show Receipt");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                if (!scanner.hasNextInt()) {
                    LOGGER.warning("Invalid input. Enter a number.");
                    scanner.next();
                    continue;
                }

                int choice = scanner.nextInt();
                scanner.nextLine();

                Product product = null;

                switch (choice) {
                    case 1 -> {
                        System.out.println("Choose base product: ");
                        System.out.println("1. Face Cream");
                        System.out.println("2. Face Wash");
                        System.out.println("3. Sunscreen");
                        int baseChoice = scanner.nextInt();
                        scanner.nextLine();

                        product = switch (baseChoice) {
                            case 1 -> new FaceCream();
                            case 2 -> new FaceWash();
                            case 3 -> new Sunscreen();
                            default -> null;
                        };

                        if (product != null) {
                            receipt.addItem(product);
                            LOGGER.info(product.getDescription() + " added.");
                        } else {
                            LOGGER.warning("Invalid base product choice.");
                        }
                    }
                    case 2 -> {
                        product = new AloeVeraAddon(new FaceCream());
                        receipt.addItem(product);
                        LOGGER.info("Aloe Vera added to Face Cream.");
                    }
                    case 3 -> {
                        product = new VitaminCAddon(new FaceWash());
                        receipt.addItem(product);
                        LOGGER.info("Vitamin C added to Face Wash.");
                    }
                    case 4 -> {
                        product = new AntiAgingAddon(new Sunscreen());
                        receipt.addItem(product);
                        LOGGER.info("Anti-Aging Serum added to Sunscreen.");
                    }
                    case 5 -> receipt.printReceipt();
                    case 6 -> exit = true;
                    default -> LOGGER.warning("Invalid menu choice.");
                }
            } catch (Exception e) {
                LOGGER.severe("Unexpected error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
