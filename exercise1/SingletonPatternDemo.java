// Singleton class
class DatabaseConnectionPool {
    // Static variable to hold the single instance of the pool
    private static DatabaseConnectionPool instance;

    // Private constructor to prevent instantiation
    private DatabaseConnectionPool() {
        System.out.println("Initializing connection pool...");
    }

    // Public method to provide the single instance
    public static synchronized DatabaseConnectionPool getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionPool();
        }
        return instance;
    }

    public void getConnection() {
        System.out.println("Providing a database connection from the pool.");
    }
}

// Demonstration of Singleton Pattern
public class SingletonPatternDemo {
    public static void main(String[] args) {
        // Attempt to get the singleton instance
        DatabaseConnectionPool pool1 = DatabaseConnectionPool.getInstance();
        pool1.getConnection();

        // Trying to get another instance
        DatabaseConnectionPool pool2 = DatabaseConnectionPool.getInstance();
        pool2.getConnection();

        // Verifying both instances are the same
        System.out.println("Both instances are the same: " + (pool1 == pool2));
    }
}
