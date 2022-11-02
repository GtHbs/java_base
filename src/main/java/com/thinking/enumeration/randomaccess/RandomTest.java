package com.thinking.enumeration.randomaccess;

/**
 * @Author 李昭
 * @Date 2020/7/14 07/22
 */
public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(Enums.random(Activity.class) + " ");
        }
    }
}
enum Activity {
    SITTING,LYING,STANDING,HOPPING,RUNNING,DODGING,JUMPING,FALLING,FLYING
}
