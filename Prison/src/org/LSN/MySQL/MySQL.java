package org.LSN.MySQL;

import java.sql.*;
import java.text.MessageFormat;

public class MySQL {

    private static boolean isConnected() {
        return (con != null);
    }
    public static Connection con;
    public static String query;


    public static void connect() {
        if (!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://10.0.0.6:3306/MCTesting", "mc", "PXK7kWV54tC5jfc9");
                System.out.println("MySQL Connection Successful!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet update(String query){
        if(isConnected())
            try{
                con.createStatement().executeUpdate(query);
            } catch (SQLException e){
                e.printStackTrace();
            }
        return null;
    }

    public static ResultSet query(String query) {
        ResultSet res = null;
        try {
            Statement state = con.createStatement();
            res = state.executeQuery(query);
        } catch (SQLException e) {
            connect();
            e.printStackTrace();
        }
        return res;
    }


    public static void disconnect(){
        if(isConnected())
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    public static boolean ifPlayerExist(String uuid){
        try{
            String sql = MessageFormat.format("SELECT NAME FROM users WHERE UUID= \"{0}\"", uuid);
            ResultSet r = query(sql);
            return (r.next());
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

}
