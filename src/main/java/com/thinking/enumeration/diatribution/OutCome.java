package com.thinking.enumeration.diatribution;

import java.util.Random;

import static com.thinking.enumeration.diatribution.OutCome.*;

/**
 * @Author 李昭
 * @Date 2020/7/16 08/17
 */
public enum OutCome {
    WIN, LOSE, DRAW
}

interface Item {
    OutCome compete(Item it);

    OutCome eval(Paper p);

    OutCome eval(Scissors s);

    OutCome eval(Rock r);
}

class Paper implements Item {

    @Override
    public OutCome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public OutCome eval(Paper p) {
        return DRAW;
    }

    @Override
    public OutCome eval(Scissors s) {
        return WIN;
    }

    @Override
    public OutCome eval(Rock r) {
        return LOSE;
    }

    @Override
    public String toString() {
        return "Paper";
    }
}

class Scissors implements Item {

    @Override
    public OutCome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public OutCome eval(Paper p) {
        return WIN;
    }

    @Override
    public OutCome eval(Scissors s) {
        return DRAW;
    }

    @Override
    public OutCome eval(Rock r) {
        return LOSE;
    }

    @Override
    public String toString() {
        return "Scissor";
    }
}

class Rock implements Item {

    @Override
    public OutCome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public OutCome eval(Paper p) {
        return LOSE;
    }

    @Override
    public OutCome eval(Scissors s) {
        return WIN;
    }

    @Override
    public OutCome eval(Rock r) {
        return DRAW;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}

class RoShamBo1 {
    static final int size = 20;
    private static Random random = new Random(47);

    public static Item newItem() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }

    public static void match(Item a, Item b) {
        System.out.println(a + " vs. " + b + " : " + a.compete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            match(newItem(), newItem());
        }
    }
}
