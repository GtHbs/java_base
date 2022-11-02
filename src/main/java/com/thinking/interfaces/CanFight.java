package com.thinking.interfaces;

/**
 * @author 李昭
 * @date
 */
public interface CanFight {
    void fight();
}
interface CanSwim {
    void swim();
}
interface CanFly {
    void fly();
}
class ActionCharacter implements CanFight,CanFly,CanSwim {

    public void fight() {
        System.out.println("fight");
    }

    public void swim() {
        System.out.println("swim");
    }

    public void fly() {
        System.out.println("fly");
    }
}
class Hero extends ActionCharacter {
    static void t(CanFight x) {
        x.fight();
    }
    static void u(CanSwim x) {
        x.swim();
    }
    static void v(CanFly x) {
        x.fly();
    }
    static void w(ActionCharacter x) {
        x.fight();
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        t(hero);
        u(hero);
        v(hero);
        w(hero);
    }
}