package com.example.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class SQL{

    private String username = "root";
    private String password = "root";

    public HashMap<String, String> getPlayerData(String playername){
        HashMap<String,String> ret = new HashMap<String,String>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cookie-clicker", username, password
                    );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from data where playername=" + "'" + playername + "'");
            
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                int cookiecount = resultSet.getInt(3);
                int friendcount = resultSet.getInt(4);
                int employeecount = resultSet.getInt(5);
                int machinecount = resultSet.getInt(6);
                int factorycount = resultSet.getInt(7);
                double persecond = resultSet.getDouble(8);

                ret.put("playername", name);
                ret.put("cookiecount", Integer.toString(cookiecount));
                ret.put("friendcount", Integer.toString(friendcount));
                ret.put("employeecount", Integer.toString(employeecount));
                ret.put("machinecount", Integer.toString(machinecount));
                ret.put("factorycount", Integer.toString(factorycount));
                ret.put("persecond", String.valueOf(persecond));
                
            }
            connection.close();
            System.out.println(ret);
        } catch (Exception e) {
            System.out.println(e);
        }
        return ret;
    }

    public void savePlayerData(String playername, int cookiecount, int friendcount, int employeecount, int machinecount, int factorycount, double persecond){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cookie-clicker", username, password
                    );
            Statement statement = connection.createStatement();
            int updatedRows = statement.executeUpdate("update data set cookiecount=" + cookiecount + ", friendcount=" + friendcount + ", employeecount=" + employeecount + ", machinecount=" + machinecount + ", factorycount=" + factorycount + ", persecond=" + persecond + " where playername='" + playername + "'");
            System.out.println(updatedRows);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addNewPlayer(String playername, int cookiecount, int friendcount, int employeecount, int machinecount, int factorycount, double persecond){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cookie-clicker", username, password
                    );
            Statement statement = connection.createStatement();
            int insertedRows = statement.executeUpdate("insert into data values(default,'" + playername + "'," + cookiecount + "," + friendcount + "," + employeecount + "," + machinecount + "," + factorycount + "," + persecond + ")");
            System.out.println(insertedRows);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}