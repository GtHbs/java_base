package com.thinking.initializecleanup;

/**
 * @author 李昭
 * @Date 7:38 2020/5/20
 * @Description:
 * @Modified By:
 */
public class Animal {
    private String name = "dog";

    public void say() {
        System.out.println("dog say");
    }
    private void scream() {
        System.out.println("dog scream");
    }
}

class Dog extends Animal {
    public Dog() {
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.say();
    }
}
