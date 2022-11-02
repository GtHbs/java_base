package com.thinking.interfaces;

/**
 * 接口中的属性默认为public static final
 *
 *
 * @author 李昭
 * @date
 */
public interface RandValues {
    int rint = (int) (Math.random() * 10);
    long rlong = (long) (Math.random() * 10);
    float rfloat = (float) (Math.random() * 10);
    double rdouble = Math.random() * 10;
}
class TestRandValues {
    public static void main(String[] args) {
        System.out.println(RandValues.rdouble);
        System.out.println(RandValues.rfloat);
        System.out.println(RandValues.rint);
        System.out.println(RandValues.rlong);
    }
}