package com.reflection.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ObjectFactory {

    public static Object createObject(String path){
        Object object = null;
        try {
            Class clazz = Class.forName(path);
            try {
                Constructor constructor = clazz.getConstructor(null);
                 object = constructor.newInstance();
                MyAnnotation annotation = (MyAnnotation)constructor.getAnnotation(MyAnnotation.class);
                Field[] declaredFields = clazz.getDeclaredFields();
                for (int i = 0; i <declaredFields.length ; i++) {
                    //使private成员可以被修改
                    declaredFields[i].setAccessible(true);
                    String filedName = declaredFields[i].getName();
                    switch (filedName){
                        case "name":
                            declaredFields[i].set(object,annotation.name());
                            break;
                        case "age":
                            declaredFields[i].set(object,annotation.age());
                            break;
                        case "hobbies":
                            declaredFields[i].set(object,annotation.hobbies());
                            break;
                        default:
                            break;

                    }

                }

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) {
        Student student = (Student) ObjectFactory.createObject("com.reflection.annotation.Student");
        System.out.println(student);
    }
}
