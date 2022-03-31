package com.corso.java.db.injection;

import java.sql.*;

public class SQLInj
{
    static String DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_USERNAME = "root";
    static String DB_PASSWOR = "KunAguero#16";
    static String DB_URL = "jdbc:mysql://localhost/jdbc";
    public static void sqlInjection() {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWOR);
            Statement statement = connection.createStatement();
            String username = "admin";
            String password = "admin";
            String query = "SELECT * FROM jdbc.users where username = '"
                    + username + "' and password = '" + password + "'";
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                System.out.println("id = " + result.getInt("id") + " | username = "
                        + result.getString("username") + " | password = " +
                        result.getString("password"));
            }else{
                System.out.println("Login not correct");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
