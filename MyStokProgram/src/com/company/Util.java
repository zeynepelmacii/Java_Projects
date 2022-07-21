package com.company;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;

public class Util {
    //shortcut message for errors or informations
    public static void showMessage(String message) {
        JOptionPane optionPane;
        optionPane = new JOptionPane();
        optionPane.setMessage(message);
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(null, "info");
        dialog.setVisible(true);
    }


    //opens and closes connection for database
    public static Connection getConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            Properties props = new Properties();
            props.setProperty("user","postgres");
            props.setProperty("password","zeynep123");
            Connection conn = DriverManager.getConnection(url, props);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public  static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {

        }
    }



    //table did not accapted vector for parameter, converting vector to array
    public static Vector<Vector<String>> arrToVector(ArrayList<Stock> arrFound) {
        Vector <Vector<String>> data = new Vector <Vector<String>>();
        for(Stock stock:arrFound) {
            Vector<String> row = new Vector<String>();
            row.add(stock.getCode());
            row.add(stock.getCategory());
            row.add(stock.getDescription());
            row.add(String.valueOf(stock.getPrice()));
            row.add(String.valueOf(stock.getAmount()));

            data.add(row);
        }
        return data;
    }


    //control the price and amount for transactionsPanel's text fields because their data types are different
    public static boolean isValidPrice(String text) {
        try{
            double price = Double.valueOf(text);
            return price>0;
        } catch (Exception e) {
            return false;
        }

    }
    public static boolean isValidAmount(String text) {
        try{
            int amount = Integer.valueOf(text);
            return amount>=0;

        } catch (Exception e) {
            return false;
        }
    }
}
