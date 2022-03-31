package com.corso.java.db.utils;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LOG {
    public static final Logger l = Logger.getLogger(LOG.class);
    public static LOG instance = null;

    {
        BasicConfigurator.configure();
    }

    private LOG() {
    }

    public static LOG getInstance() {
        if (instance == null) synchronized (LOG.class) {
            instance = new LOG();
        }
        return instance;
    }

    public void info(String parameter) {
        l.info(parameter);
    }

    public void debug(String parameter) {
        l.debug(parameter);
    }

    public void warn(String parameter) {
        l.warn(parameter);
    }

    public void error(String parameter) {
        l.error(parameter);
    }
}
