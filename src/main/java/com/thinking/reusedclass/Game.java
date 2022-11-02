package com.thinking.reusedclass;

/**
 * @author 李昭
 * @Date 7:57 2020/5/20
 * @Description:    如果父类对象没有无参构造器,子类对象在构造器中必须显式的调用父类的构造器
 * @Modified By:
 */
public class Game {
    public Game(int i) {
        System.out.println("Game Constructor...");
    }
}
class BoardGame extends Game {

    public BoardGame(int i) {
        //Game Constructor
        super(i);
        System.out.println("BoardGame Constructor..");
    }
}
class Chess extends BoardGame {

    public Chess() {
        //BoardGame Constructor
        super(11);
        System.out.println("Chess Constructor..");
    }

    public static void main(String[] args) {
        Chess chess = new Chess();
    }
}
