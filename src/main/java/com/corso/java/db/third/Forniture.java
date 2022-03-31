package com.corso.java.db.third;

import java.sql.*;

public class Forniture
{
    private PreparedStatement preparedStatement;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    public void readDatabase(String codeFornitore, String name, String address, String city) throws SQLException {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "KunAguero#16");

            String sql = "CREATE TABLE `JDBC`.`fornitori` (\n" +
                    "  `codefornitore` VARCHAR(20) NOT NULL,\n" +
                    "  `name` VARCHAR(25) NOT NULL,\n" +
                    "  `address` VARCHAR(30) NOT NULL,\n" +
                    "  `città` VARCHAR(20) NOT NULL,\n" +
                    "  PRIMARY KEY (`codefornitore`));";

            //statement = connection.createStatement();
            //int a = statement.executeUpdate(sql);
            statement.executeUpdate("INSERT INTO fornitori " + "VALUES (codeFornitore, name, address, city)");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void close() throws SQLException {
        if (resultSet != null)
            resultSet.close();

        if (statement != null)
            statement.close();

        if (preparedStatement != null)
            preparedStatement.close();

        if (connection != null)
            connection.close();
    }

    public static void main(String[] args) throws SQLException
    {
        Forniture f = new Forniture();
        f.readDatabase("001", "Ladroni", "Via Ostense", "Roma");
    }
}
