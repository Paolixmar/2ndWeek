package com.corso.java.db.second;

import java.sql.*;

/**
 * @author: Christian Chiama (c.chiama@silensec.com)
 * @project-Name: second-week
 * @date: 28-03-2022
 * @time: 15:01 min
 * @file: com.corso.java.Db.second.DbAccess
 */

public class DbAccess implements Db<ResultSet> {


    //private final org.apache.log4j.Logger logger = Logger.getLogger(DbAccess.class);

    private PreparedStatement preparedStatement;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private final String DB_DRIVER_URL = "com.mysql.cj.jdbc.Driver";
    private final String DB_PASSWORD = "KunAguero#16";
    private final String DB_USER = "root";
    private final String DB__URL = "jdbc:mysql://localhost/jdbc";


    @Override
    public void readDatabase() throws SQLException {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "KunAguero#16");

            String sql = "CREATE TABLE `JDBC`.`person` (\n" +
                    "  `idperson` INT NOT NULL,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `lastname` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`idperson`));";

            statement = connection.createStatement();
            int a = statement.executeUpdate(sql);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
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
}