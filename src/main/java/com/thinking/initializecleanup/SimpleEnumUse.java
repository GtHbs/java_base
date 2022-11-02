package com.thinking.initializecleanup;

/**
 * @author 李昭
 * @Date 22:03 2020/5/18
 * @Description:
 * @Modified By:
 */
public class SimpleEnumUse {
    public static void main(String[] args) {
        Spiciness howHot = Spiciness.MEDIUM;
        System.out.println(howHot);

        for (Spiciness h : Spiciness.values()) {
            //显示声明顺序
            System.out.println(h.ordinal() +":" + h);
        }
    }
}
