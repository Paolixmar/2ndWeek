package com.corso.java.thread.anagrafe;

import com.corso.java.db.first.DBConstant;

import java.sql.*;

public class Anagrafica {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet = null;

    public Anagrafica() throws SQLException {
        try {
            Class.forName(DBConstant.DB_MYSQL_URL).newInstance();
            connection = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.DB_USER, DBConstant.DB_PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate("CREATE SCHEMA ministero");
            connection.close();
            connection=DriverManager.getConnection((DBConstant.DB_URL+"/ministero"), DBConstant.DB_USER, DBConstant.DB_PASSWORD);
            preparedStatement=connection.prepareStatement("CREATE TABLE ministero.anagrafica (\n" +
                    "    id INT PRIMARY KEY,\n" +
                    "    nome VARCHAR (25)NOT NULL,\n" +
                    "    cognome VARCHAR (25)NOT NULL,\n" +
                    "    età INT NOT NULL,\n" +
                    "    città VARCHAR (25)NOT NULL,\n" +
                    "    provincia VARCHAR (25)NOT NULL,\n" +
                    "    cap VARCHAR (25)NOT NULL\n");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            close(resultSet, statement, connection);
        }
    }

    public void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        if (resultSet != null)
            resultSet.close();
        if (statement != null)
            statement.close();
        if (connection != null)
            connection.close();
    }

    public static void main(String[] args) throws SQLException {
        Anagrafica a = new Anagrafica();
    }
}
