package com.thinking.reusedclass;

/**
 * @author 李昭
 * @Date 7:47 2020/5/28
 * @Description:
 * @Modified By:
 */
public class Food {
    public Food() {
        System.out.println("Food Constructor");
    }
}
class Lunch extends Food {
    public Lunch() {
        System.out.println("Lunch Constructor");
    }
}
class Meal extends Lunch {
    public Meal() {
        System.out.println("Meal Constructor");
    }
}
class Fruit extends Lunch {
    private Food food = new Food();
    private Lunch lunch = new Lunch();
    public static void main(String[] args) {
        Food food = new Fruit();
    }
}
