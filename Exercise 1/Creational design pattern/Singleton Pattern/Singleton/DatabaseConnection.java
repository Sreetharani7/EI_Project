package Singleton;

import java.util.logging.Logger;

public class DatabaseConnection {
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    // volatile ensures visibility in multi-threaded environments
    private static volatile DatabaseConnection instance;

    private String connectionUrl;

    // private constructor to prevent direct instantiation
    private DatabaseConnection(String url) {
        this.connectionUrl = url;
        logger.info("Database connection created with URL: " + url);
    }

    // Double-checked locking for thread-safe singleton
    public static DatabaseConnection getInstance(String url) {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection(url);
                }
            }
        }
        return instance;
    }

    public void executeQuery(String query) {
        if (query == null || query.trim().isEmpty()) {
            logger.warning("Invalid query provided.");
            return;
        }
        logger.info("Executing query on " + connectionUrl + ": " + query);
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }
}
