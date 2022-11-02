package com.thinking.enumeration.basic;

/**
 * @Author 李昭
 * @Date 2020/7/13 07/22
 */
public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            //ordinal为当前类型在枚举中声明的次序从0开始
            System.out.println(s +" ordinal: " + s.ordinal());
            System.out.println(s.compareTo(Shrubbery.CRAWLING));
            System.out.println(s.equals(Shrubbery.CRAWLING));
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("-----------------------------");
        }
    }
}

enum Shrubbery {
    GROUND,CRAWLING,HANGING
}
