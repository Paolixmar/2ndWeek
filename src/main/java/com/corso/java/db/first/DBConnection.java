package com.corso.java.db.first;

import com.corso.java.db.utils.LOG;

import java.sql.*;

public class DBConnection {
    
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {

            LOG L = LOG.getInstance();
            Class.forName(DBConstant.DB_MYSQL_URL).newInstance(); // registra il driver
            connection = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.DB_USER, DBConstant.DB_PASSWORD);//
            // crea una connessione a db
            statement = connection.createStatement();// crea uno statement a partire dalla connessione
            resultSet = statement.executeQuery("SELECT * FROM JDBC.STUDENTE");//si crea un result set a partire dallo
            // statement
            ResultSetMetaData md = resultSet.getMetaData();

            while (resultSet.next()) {
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    md.getColumnName(i);
                    L.debug(resultSet.getString(i));
                }
                System.out.println();
            }

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } finally {
            close(resultSet, statement, connection);
        }

    }

    private static void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {

        if (resultSet != null)
            resultSet.close();

        if (statement != null)
            statement.close();

        if (connection != null)
            connection.close();
    }
}
/**
 * connessione a db -> registrazione del driver (mysql come db)
 * creare una connessione al db attraverso il DriverManager -> ritorna
 * una oggetto della class Connection
 * <p>
 * Operazioni CRUD sono le seguenti
 * C => create
 * R => read
 * U => update
 * D => delete
 */

