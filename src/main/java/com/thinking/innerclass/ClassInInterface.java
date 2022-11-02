package com.thinking.innerclass;

/**
 * @author: 李昭
 * @Date: 2020/6/5 7:28
 */
public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface {

        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
