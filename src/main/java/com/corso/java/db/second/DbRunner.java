package com.corso.java.db.second;

import java.sql.SQLException;

/**
 * @author: Christian Chiama (c.chiama@silensec.com)
 * @project-Name: second-week
 * @date: 28-03-2022
 * @time: 15:01 min
 * @file: com.corso.java.Db.second.DbRunner
 */

public class DbRunner
{

    public static void main(String[] args) throws SQLException {

        DbAccess dbAccess = new DbAccess();
        dbAccess.readDatabase();
    }
}