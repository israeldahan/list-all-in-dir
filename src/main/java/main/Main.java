package main;

import Connector.ConnectionDetails;
import Connector.Connector;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main (String[] args){

        Properties prop = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ConnectionDetails details  = new ConnectionDetails( prop.getProperty("userName"),
                                                            prop.getProperty("hostName"),
                                                            Integer.parseInt(prop.getProperty("port", "22")) ,
                                                            prop.getProperty("password"),
                                                            prop.getProperty("key"),
                                                            prop.getProperty("directory")
        );

        new Connector( details ) ;
    }
}
