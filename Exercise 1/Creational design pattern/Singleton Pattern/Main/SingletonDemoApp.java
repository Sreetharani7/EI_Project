package Main;

import Singleton.DatabaseConnection;

import java.util.Scanner;
import java.util.logging.Logger;

public class SingletonDemoApp {
    private static final Logger logger = Logger.getLogger(SingletonDemoApp.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        DatabaseConnection db = null;

        while (!exit) {
            System.out.println("\n===== Database Connection Menu =====");
            System.out.println("1. Create/Get Connection");
            System.out.println("2. Execute Query");
            System.out.println("3. Show Connection URL");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter database URL: ");
                        String url = scanner.nextLine();
                        if (url.trim().isEmpty()) {
                            System.out.println("URL cannot be empty.");
                            break;
                        }
                        db = DatabaseConnection.getInstance(url);
                        System.out.println("Connected to DB: " + db.getConnectionUrl());
                        break;

                    case "2":
                        if (db == null) {
                            System.out.println("No active connection. Please create one first.");
                        } else {
                            System.out.print("Enter SQL query: ");
                            String query = scanner.nextLine();
                            db.executeQuery(query);
                        }
                        break;

                    case "3":
                        if (db == null) {
                            System.out.println("No active connection.");
                        } else {
                            System.out.println("Current DB URL: " + db.getConnectionUrl());
                        }
                        break;

                    case "4":
                        exit = true;
                        logger.info("Exiting Database Connection Manager. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                logger.severe("Error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
