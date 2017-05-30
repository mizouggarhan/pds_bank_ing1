package server.database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mouna
 */
public class Database {

    

    private static String nameDB = "pds_ing1";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String host = "localhost";
    private static int port = 3306;

    private static String url = "jdbc:mysql://" + host + ":" + port + "/" + nameDB;
    private static String login = "root";
    private static String password = "";
    
    private static BlockingQueue<Connection> queue;
    private static int LENGTH_QUEUE = 10;

    static {
        try {
            Class.forName(driver);
            queue = new ArrayBlockingQueue(LENGTH_QUEUE);
            for (int i = 0; i < LENGTH_QUEUE; i++) {
                queue.add(DriverManager.getConnection(url, login, password));
            }
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection pullConnection() throws InterruptedException {
        return queue.take();
    }

    public static void putConnection(Connection connection) throws InterruptedException {
        queue.put(connection);
    }

}
