package com.thinking.interfaces;

/**
 * @author 李昭
 * @date
 */
public interface Monster {
    void menace();
}
interface DangerousMonster extends Monster {
    void destroy();
}
interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {

    public void menace() {
        System.out.println("menace");
    }

    public void destroy() {
        System.out.println("destroy");
    }
}
interface Vampire extends DangerousMonster,Lethal {
    void drinkBlood();
}

class HorrorShow {
    static void u(Monster b) {
        b.menace();
    }
    static void v(DangerousMonster b) {
        b.menace();
        b.destroy();
    }

    public static void main(String[] args) {
        DragonZilla zilla = new DragonZilla();
        u(zilla);
        v(zilla);
    }
}










