package com.corso.java.db.second;

import java.sql.SQLException;

/**
 * @author: Christian Chiama (c.chiama@silensec.com)
 * @project-Name: second-week
 * @date: 28-03-2022
 * @time: 15:02 min
 * @file: com.corso.java.Db.second.Db
 */

public interface Db<K> {

    void readDatabase() throws SQLException;

    void close() throws SQLException;
    //void writeResult(K result);
}