package com.thinking.enumeration.constmethod.status;

import java.util.Random;

/**
 * @Author 李昭
 * @Date 2020/7/16 08/02
 */
public enum  Input {
    NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
    ABORT_TRANSACTION {
        public int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        public int amount() {
            throw new RuntimeException("STOP.amount()");
        }
    };
    int value;

    Input(int value) {
        this.value = value;
    }

    Input() {
    }
    int amount() {return value;}

    static Random random = new Random(47);
    public static Input randomSelection() {
        return values()[random.nextInt(values().length - 1)];
    }

    public static void main(String[] args) {
        for (Input input : Input.values()) {
            System.out.println(input.value);
            System.out.println(input.ordinal());
        }
    }
}
