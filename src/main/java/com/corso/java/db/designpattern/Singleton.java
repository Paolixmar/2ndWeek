package com.corso.java.db.designpattern;

public class Singleton
{
    public static Singleton instance=null;

    private Singleton(){}//costruttore sempre privato

    public static Singleton getInstance()
    {
        if(instance==null)
        {
            instance=new Singleton();
        }
        return instance;
    }
}
