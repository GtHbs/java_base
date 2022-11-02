package com.thinking.operator;

import org.junit.Test;

/**
 * @author 李昭
 * @Date 22:19 2020/5/12
 * @Description:
 * @Modified By:
 */
public class RelationOperator {
    @Test
    public void test() {
        Integer n1 = new Integer(10);
        Integer n2 = new Integer(10);
        //比较对象
        System.out.println(n1 == n2);
        //会发生自动拆箱
        System.out.println(n1 == 10);
    }

    @Test
    public void test01() {
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        //equals默认比较的为引用,而包装类重写了equals所以是比较值
        System.out.println(v1.equals(v2));
    }

    @Test
    public void test02() {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        dog1.name = "spot";
        dog1.says = "Ruff!";
        dog2.name = "scruffy";
        dog2.says = "Wurf!";
        Dog dog = new Dog();
        dog = dog1;
        System.out.println(dog1 == dog);
    }
}

class Value {
    int i;
}

class Dog {
    String name;
    String says;
}
