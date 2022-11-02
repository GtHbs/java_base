package com.on_java.functional;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/10/31 23:30
 */
public class CtorReferences {

    public static void main(String[] args) {
        MakeNoArgs makeNoArgs = Dog::new;
        Make1Arg make1Arg = Dog::new;
        Make2Arg make2Arg = Dog::new;
        makeNoArgs.make();
        make1Arg.make("spic");
        make2Arg.make("spic", 2);
    }
}

class Dog {
    String name;
    int age = -1;

    Dog() {
        name = "spic";
        System.out.println(name);
    }

    public Dog(String name) {
        this.name = name;
        System.out.println(name);
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(age);
        System.out.println(name);
    }
}


interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String name);
}

interface Make2Arg {
    Dog make(String name, int age);
}