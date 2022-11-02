package com.thinking.generic;

import java.util.Map;

/**
 * @Author 李昭
 * @Date 2020/6/20 16/49
 */
public class Erased<T> {
    private static final int SIZE = 100;

    public static void f(Object arg) {
        //因为泛型类型在编译后会被擦除,所以不能获取到其具体类型信息
//        if (arg instanceof T) {
//            T var = new T();
//            T[] com.thinking.array = (T) new Object[SIZE];
//        }
    }
}

class Building {
}

class House extends Building {
}

class ClassTypeCapture<T> {
    private Class<T> kind;
    private Map<String, Class<?>> map;


    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public ClassTypeCapture(Map<String, Class<?>> map) {
        this.map = map;
    }

    public void addType(String typeName, Class<?> kind) {
        map.put(typeName, kind);
    }

    public void createNew(String typeName) {
        map.put(typeName, kind);
    }


    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }


    public static void main(String[] args) {
        ClassTypeCapture<Building> capture = new ClassTypeCapture<>(Building.class);
        //true
        System.out.println(capture.f(new Building()));
        //true
        System.out.println(capture.f(new House()));

        ClassTypeCapture<House> typeCapture = new ClassTypeCapture<>(House.class);
        //false,因为kind为子类类型,子类不能兼容父类类型
        System.out.println(typeCapture.f(new Building()));
        //true
        System.out.println(typeCapture.f(new House()));
        Class buildClass = Building.class;
        Class houseClass = House.class;
        //false
        System.out.println(buildClass.isInstance(houseClass));
        //false
        System.out.println(houseClass.isInstance(buildClass));
    }
}