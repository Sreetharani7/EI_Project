package Main;

import Observer.*;

import java.util.*;
import java.util.logging.*;

/**
 * Interactive menu-driven Observer Pattern Demo
 */
public class ObserverDemoApp {
    private static final Logger LOGGER = Logger.getLogger(ObserverDemoApp.class.getName());

    public static void main(String[] args) {
        setupLogger();

        Scanner scanner = new Scanner(System.in);
        YouTubeChannel channel = new YouTubeChannel("SreeTech Tutorials");

        Map<String, Subscriber> allUsers = new HashMap<>();

        boolean exitRequested = false;

        while (!exitRequested) {
            printMenu();
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter subscriber name: ");
                        String name = scanner.nextLine().trim();
                        if (name.isEmpty()) {
                            LOGGER.warning("Name cannot be empty.");
                            break;
                        }
                        Subscriber user = allUsers.computeIfAbsent(name, User::new);
                        channel.subscribe(user);
                        break;

                    case "2":
                        System.out.print("Enter subscriber name to unsubscribe: ");
                        String unsubName = scanner.nextLine().trim();
                        Subscriber unsubUser = allUsers.get(unsubName);
                        if (unsubUser == null) {
                            LOGGER.warning("Subscriber not found.");
                        } else {
                            channel.unsubscribe(unsubUser);
                        }
                        break;

                    case "3":
                        System.out.print("Enter video title: ");
                        String video = scanner.nextLine().trim();
                        channel.uploadVideo(video);
                        break;

                    case "4":
                        exitRequested = true;
                        LOGGER.info("Exiting program... Goodbye!");
                        break;

                    default:
                        LOGGER.warning("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                LOGGER.severe("Unexpected error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n===== YouTube Channel Menu =====");
        System.out.println("1. Subscribe User");
        System.out.println("2. Unsubscribe User");
        System.out.println("3. Upload Video");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

  private static void setupLogger() {
    Logger rootLogger = Logger.getLogger("");
    Handler[] handlers = rootLogger.getHandlers();
    for (Handler h : handlers) {
        if (h instanceof ConsoleHandler) {
            h.setLevel(Level.ALL); // reuse the existing console handler
        }
    }
    rootLogger.setLevel(Level.ALL);
}

}
