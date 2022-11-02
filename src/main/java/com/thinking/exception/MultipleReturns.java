package com.thinking.exception;

/**
 * @Author 李昭
 * @Date 2020/6/14 19/33
 */
public class MultipleReturns {


    public static void f(int i) {
        System.out.println("Initialization that requires cleanup");
        try {
            System.out.println("Point 1");
            switch (i) {
                case 1:
                    return;
                case 2:
                    return;
                case 3:
                    return;
                default:
                    System.out.println("End");
            }
        } finally {
            System.out.println("Performing cleanup");
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            f(i);
        }
    }
}
