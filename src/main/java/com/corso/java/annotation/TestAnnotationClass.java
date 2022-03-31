package com.corso.java.annotation;


import com.corso.java.db.utils.LOG;

@TestAnnotation
@SingleTestAnnotation(
        item="Ciao",
        value = TestAnnotationEnum.SUCCESS)
public class TestAnnotationClass
{
    private String annotation;

    public static boolean isAnnotationPresent(){
        Class test= TestAnnotationClass.class;
        if(test.isAnnotationPresent(TestAnnotationClass.class)) LOG.getInstance().debug("There is annotation!");
        else LOG.getInstance().debug("There is not annotation!");
        return false;
    }


    public static void main(String[] args) {

    }
}
