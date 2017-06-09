
import client.views.MDIForm;
import server.Server;
import server.database.Database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mouna
 */
public class Application {

    public static void main(String[] args) {

        try {
            switch (args[0]) {
                case "server":
                    Database.composant = args[1];
                    Database.driver = args[2];
                    Database.nameDB = args[3];
                    Database.host = args[4];
                    Database.port = Integer.parseInt(args[5]);
                    Database.login = args[6];
                    Database.password = args[7];
                    Server server = new Server();
                    server.start();
                    break;

                case "client":
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new MDIForm().setVisible(true);
                        }
                    });
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println("AN ERROR WAS OCCURED, EXIT 1");
            System.out.println(e.getMessage());
            System.out.println("server [mysql|postgresql] [DRIVER] [DATABASE] [IP] [PORT] [LOGIN] [PASSWORD] ");
        }

    }
}
