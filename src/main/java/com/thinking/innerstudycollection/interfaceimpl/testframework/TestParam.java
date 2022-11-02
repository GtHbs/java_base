package com.thinking.innerstudycollection.interfaceimpl.testframework;

/**
 * @Author 李昭
 * @Date 2020/6/28 21/14
 */
public class TestParam {
    /**
     * 数量大小
     */
    public final int size;
    /**
     * 循环次数
     */
    public final int loops;

    public TestParam(int size, int loops) {
        this.size = size;
        this.loops = loops;
    }

    public static TestParam[] array(int... values) {
        int size = values.length / 2;
        TestParam[] result = new TestParam[size];
        int n = 0;
        for (int i = 0; i < size; i++) {
            result[i] = new TestParam(values[n++], values[n++]);
        }
        return result;
    }

    public static TestParam[] array(String[] values) {
        int[] vals = new int[values.length];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }
}
