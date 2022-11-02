package com.thinking.innerclass;

/**
 * @author: 李昭
 * @Date: 2020/6/5 8:20
 */
public class WithInner {
    class Inner {}
}

class InheritInner extends WithInner.Inner {
    InheritInner(WithInner inner) {
        inner.super();
    }

    public static void main(String[] args) {
        WithInner inner = new WithInner();
        InheritInner inheritInner = new InheritInner(inner);
    }
}
