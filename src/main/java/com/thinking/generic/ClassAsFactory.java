package com.thinking.generic;

/**
 * @Author 李昭
 * @Date 2020/6/20 17/08
 */
public class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
}

class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> factory = new ClassAsFactory<>(Employee.class);
        System.out.println("succeed");
        try {
            //失败的原因为Integer没有默认的构造器
            ClassAsFactory<Integer> classAsFactory = new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            System.out.println("failed");
        }
    }
}

/**
 * 工厂接口
 */
interface Factory<T> {
    T create();
}

/**
 * 生成类
 */
class Foo2<T> {
    private T x;

    public <F extends Factory<T>> Foo2(F factory) {
        x = factory.create();
    }
}

/**
 * 工厂方法模式创建对象
 */
class IntegerFactory implements Factory<Integer> {

    @Override
    public Integer create() {
        return new Integer(0);
    }
}

class Widget {
    /**
     * 工厂
     */
    public static class FactoryI implements Factory<Widget> {

        @Override
        public Widget create() {
            return new Widget();
        }
    }
}

class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.FactoryI());
    }
}