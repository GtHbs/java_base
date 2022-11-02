package com.thinking.innerclass;

/**
 * @author: 李昭
 * @Date: 2020/6/3 8:08
 */
public interface Service {
    void method1();
    void method2();
}

/**
 * 工厂接口
 */
interface ServiceFactory {
    /**
     * 工厂接口
     * @return Service
     */
    Service getService();
}

/**
 * 工厂实现类
 */
class Implementation1Impl implements Service {

    @Override
    public void method1() {
        System.out.println("Implementation1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }

    public static ServiceFactory factory = Implementation1Impl::new;
}

class Implementation2Impl implements Service {

    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }

    public static ServiceFactory factory = Implementation2Impl::new;
}


class Factories {
    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation1Impl.factory);
        serviceConsumer(Implementation2Impl.factory);
    }
}