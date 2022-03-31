package com.corso.java.db.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties
{
    private LOG L;
    private Properties properties;
    private InputStream inputStream;
    private String resourceName;
    private ClassLoader loader = Thread.currentThread().getContextClassLoader();

    public ReadProperties(){}

    public ReadProperties(Properties properties, InputStream inputStream)
    {
        this.properties=properties;
        this.inputStream=inputStream;
    }

    public void init(){
            this.L=LOG.getInstance();
            this.properties=new Properties();
    }

    public void read() throws IOException {
        this.resourceName="application.properties";
        inputStream=new FileInputStream("src/main/resources"+this.resourceName);
        this.properties.load(inputStream);
    }

    public static void main(String[] args){
        ReadProperties readProperties=new ReadProperties();
        readProperties.init();
        try {
            readProperties.read();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
