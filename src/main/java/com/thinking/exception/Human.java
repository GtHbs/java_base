package com.thinking.exception;

/**
 * @Author 李昭
 * @Date 2020/6/15 20/28
 */
public class Human {
    public static void main(String[] args) {
        try {
            throw new Sneeze();
        } catch (Sneeze sneeze) {
            System.out.println("Caught Sneeze");
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance0");
        }

        try {
            throw new Sneeze();
        } catch (Annoyance e) {
            System.out.println("Caught Annoyance1");
        }
    }
}

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}