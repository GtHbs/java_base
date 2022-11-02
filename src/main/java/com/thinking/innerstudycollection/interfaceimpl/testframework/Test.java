package com.thinking.innerstudycollection.interfaceimpl.testframework;

/**
 * 抽象测试框架
 *
 * @Author 李昭
 * @Date 2020/6/28 21/13
 */
public abstract class Test<C> {
    String name;

    public Test(String name) {
        this.name = name;
    }

    /**
     * 测试方法
     *
     * @param list      测试容器
     * @param tp        数据流
     * @return
     */
    public abstract int test(C list, TestParam tp);
}

