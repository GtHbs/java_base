package com.thinking.innerclass;

/**
 * @author: 李昭
 * @Date: 2020/6/5 7:43
 */
public interface A {
}

interface B {
}

class X implements A, B {

}

class Y implements A {
    B makeB() {
        return new B() {
        };
    }
}

class MultiInterfaces {
    static void takesA(A a) {

    }

    static void takesB(B b) {

    }

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }
}

class D {
}

abstract class E {
}

class Z extends D {
    E makeE() {
        return new E() {
        };
    }
}

/**
 * 关于内部类与多继承:<br>
 * 为什么要使用内部类做多继承:<br>
 * 1, 每个外围类只能继承一个类,这样每个外围类就只能有一种实现,而做不到多实现<br>
 * 2, 可以使用多个外围类继承多个类而实现,但是如果这些类之前有需要共用的属性或方法,开销会非常大<br>
 * 使用内部类实现多继承:<br>
 * 1, 内部类可以有多个实例,每个实例都有自己的状态信息,并且与外围类对象信息相互独立<br>
 * 2, 可以让多个内部类以不同的方式实现同一个接口或继承同一个类<br>
 * 3, 创建内部类对象并不依赖于外围类对象的创建<br>
 * 4, 每个内部类是一个单独的实体,从编译好的class文件就可以看出来<br>
 */
class MultiImplementation {
    static void takesD(D d) {
    }

    static void takesE(E e) {
    }

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}