package com.thinking.innerclass;

/**
 * @author: 李昭
 * @Date: 2020/6/3 8:15
 */
public interface Games {
    boolean move();
}

interface GameFactory {
    Games getGame();
}

class Checker implements Games {
    private Checker() {
    }

    private int moves = 0;
    private static final int MOVES = 3;

    @Override
    public boolean move() {
        System.out.println("Checkers move " + moves);
        return ++moves != MOVES;
    }

    public static GameFactory factory = Checker::new;
}

class Chess implements Games {

    private Chess() {

    }

    private int moves = 0;
    private static final int MOVES = 4;

    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }

    public static GameFactory factory = Chess::new;
}

class GameUnit {
    public static void playGame(GameFactory factory) {
        Games game = factory.getGame();
        while (game.move()) ;
    }

    public static void main(String[] args) {
        playGame(Checker.factory);
        playGame(Checker.factory);
    }
}
