package com.corso.java.db.creaconn;

import java.sql.*;

public class MakeConnection
{
    private static MakeConnection mC=null;
    private Connection connection=null;

    private MakeConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/jdbc", "root", "KunAguero#16");
    }

    public MakeConnection getInstance() throws SQLException, ClassNotFoundException
    {
        if(connection==null)mC = new MakeConnection();
        return mC;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {return connection;}

    public PreparedStatement getPreparedStatement(String query) throws SQLException
    {
        Statement s = null;
        return connection.prepareStatement(query);
    }

    public void close() throws SQLException {connection.close();}
}
