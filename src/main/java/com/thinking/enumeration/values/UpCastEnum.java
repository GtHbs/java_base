package com.thinking.enumeration.values;

/**
 * @Author 李昭
 * @Date 2020/7/13 08/04
 */
public class UpCastEnum {
    public static void main(String[] args) {
        Search[] values = Search.values();
        Enum e = Search.HITHER;
//        e.values();
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}
enum Search {
    HITHER,YON
}