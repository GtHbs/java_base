package com.thinking.reusedclass;

/**
 * @author 李昭
 * @Date 7:56 2020/5/27
 * @Description:
 * @Modified By:
 */
public class Sup {
    public int field = 0;
    public static int age = 10;

    public int getField() {
        return field;
    }
    public static void staticGet() {
        System.out.println("Basic static get");
    }
}

class Sub extends Sup {
    public int field = 1;
    public static int age = 20;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }

    public static void staticGet() {
        System.out.println("Extend static get");
    }
}

class FieldAccess {
    public static void main(String[] args) {
        Sup sup = new Sub();
        /**
         * 对于公共属性,子类引用指向父类会分配两个空间,但是会调用父类属性
         * 如果父类属性或方法是静态的,则不会被子类给覆盖,调用只会调用父类的方法
         * 因为静态方法与属性是与类相关联的并非对象
         */
        System.out.println("sup.field:" + sup.field + ",sup.getField()" + sup.getField());
        Sub sub = new Sub();
        System.out.println("sub.field:" + sub.field + ",sub.getField():" + sub.getField() + ",sub.getSuperField():" + sub.getSuperField());
        sup.staticGet();
        System.out.println("sup.staticField:"+sup.age);
    }
}
