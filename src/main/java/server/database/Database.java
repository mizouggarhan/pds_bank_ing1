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

    
    public static String composant = "mysql";
    public static String nameDB = "pds_ing1";
    public static String driver = "com.mysql.jdbc.Driver";
    public static String host = "localhost";
    public static int port = 3306;

    private static String url = "jdbc:"+composant+"://" + host + ":" + port + "/" + nameDB;
    public static String login = "root";
    public static String password = "";
    
    private static BlockingQueue<Connection> queue;
    private static int LENGTH_QUEUE = 20;

    public static void initPool(){
        try {
            url = "jdbc:"+composant+"://" + host + ":" + port + "/" + nameDB+"/useSSL=false";
            Class.forName(driver);
            queue = new ArrayBlockingQueue(LENGTH_QUEUE);
            System.out.println(url);
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
