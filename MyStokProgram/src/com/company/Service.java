package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Service {

    //display transactionsPanel according to code or checks if item already exist when updating or adding
    public static Stock getStokByCode(String code) {
        ArrayList<Stock> arr = getStocksAll();
        for(Stock stock:arr) {
            if(stock.getCode().equals(code)) {
                return stock;
            }
        }
        return null;
    }

    //checking if there are any common characters in database
    private static boolean matched(Stock stock, String keyword) {
        if(stock.getCode().toUpperCase().contains(keyword.toUpperCase())) {
            return true;
        }
        if(stock.getCategory().toUpperCase().contains(keyword.toUpperCase())) {
            return true;
        }
        if(stock.getDescription().toUpperCase().contains(keyword.toUpperCase())) {
            return true;
        }
        return false;
    }

    //after matched() function display the common datas at table
    public static ArrayList<Stock> getStocksByKeyword(String keyword) {
        ArrayList<Stock> arr = new ArrayList<Stock>();
        ArrayList<Stock> all = getStocksAll();
        for(Stock stock:all) {
            if(matched(stock,keyword)) {
                arr.add(stock);
            }
        }
        return arr;
    }

    //gets datas from database
    public static ArrayList<Stock> getStocksAll() {
        ArrayList<Stock> arr = new ArrayList<Stock>();
        String sql = "select code,category,description,price,amount from stocks";
        try {
            Connection conn = Util.getConnection();
            if(conn == null) {
                System.err.println("connection not established !!");
                return arr;
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                String code = rs.getString("code");
                String category = rs.getString("category");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int amount = rs.getInt("amount");

                Stock stock = new Stock();
                stock.setCode(code);
                stock.setCategory(category);
                stock.setDescription(description);
                stock.setPrice(price);
                stock.setAmount(amount);

                arr.add(stock);
            }
            stmt.close();
            rs.close();
            Util.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
            return arr;
        }
        return arr;
    }

    //the insert command for insert button
    public static boolean insert(Stock stock) {
        Connection conn = Util.getConnection();
        if(conn == null) {
            return false;
        }
        String sql = "insert into stocks (code,category,description,price,amount) values(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,stock.getCode());
            stmt.setString(2,stock.getCategory());
            stmt.setString(3,stock.getDescription());
            stmt.setDouble(4,stock.getPrice());
            stmt.setInt(5,stock.getAmount());

            stmt.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //the update command for update button
    public static boolean update(Stock stock) {
        Connection conn = Util.getConnection();
        if(conn == null) {
            return false;
        }
        String sql = "update stocks set category=?,description=?,price=?,amount=? where code=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);  //sql injection
            stmt.setString(1,stock.getCategory());
            stmt.setString(2,stock.getDescription());
            stmt.setDouble(3,stock.getPrice());
            stmt.setInt(4,stock.getAmount());
            stmt.setString(5,stock.getCode());
            stmt.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //the delete command for delete button
    public static boolean delete(Stock stock) {
        Connection conn = Util.getConnection();
        if(conn == null) {
            return false;
        }
        String sql = "delete from stocks where code=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);  //sql injection
            stmt.setString(1,stock.getCode());
            stmt.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
