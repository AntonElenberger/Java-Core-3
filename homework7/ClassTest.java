package ru.geekbrains.antonelenberger.homework7;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException{
        start(TestsOfClass.class);
    }

    static void start(Class c) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = c.getDeclaredMethods();
        int beforeSuitCounter = 0;
        int afterSuitCounter = 0;

        for(Method m : methods) {
            if(m.isAnnotationPresent(BeforeSuit.class)) {
                beforeSuitCounter++;
                if(beforeSuitCounter == 2) { throw new RuntimeException("@BeforeSuit is running more than one time");}
                System.out.println(m.getName());
                m.invoke(null);
            }
        }

        for(int i = 10; i >= 1; i--) {
            for(Method m : methods) {
                if(m.isAnnotationPresent(Test.class)) {
                    if(m.getAnnotation(Test.class).priority() == i) {
                       m.invoke(null);
                    }
                }
            }
        }

        for(Method m : methods) {
            if(m.isAnnotationPresent(AfterSuit.class)) {
                afterSuitCounter++;
                if(afterSuitCounter == 2) {throw new RuntimeException ("@AfterSuit is running more than one time");}
                System.out.println(m.getName());
                m.invoke(null);
            }
        }

    }

}
