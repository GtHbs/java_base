package com.thinking.enumeration.constmethod;

/**
 * @Author 李昭
 * @Date 2020/7/15 07/50
 */
public enum  OverrideConstantSpecific {
    NUT,BLOT,
    WASHER {
        /**
         * 常量可以覆盖方法
         */
        void f() {
            System.out.println("Overridden method");
        }
    };
    void f() {
        System.out.println("default behavior");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific s : values()) {
            System.out.print(s + ":");
            s.f();
        }
    }
}
