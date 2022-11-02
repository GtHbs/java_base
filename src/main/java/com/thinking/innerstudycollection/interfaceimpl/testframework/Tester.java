package com.thinking.innerstudycollection.interfaceimpl.testframework;

import java.util.List;

/**
 * @Author 李昭
 * @Date 2020/6/28 21/19
 */
public class Tester<C> {
    /**
     * 输出字符串的宽度
     */
    public static int fieldWidth = 8;
    public static TestParam[] defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 500);

    protected C initialize(int size) {
        return container;
    }

    protected C container;

    private String headLine = "";
    private List<Test<C>> tests;

    /**
     * 禅城输出结果的格式化字符串
     *
     * @return
     */
    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";
    private TestParam[] paramList = defaultParams;

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if (container != null) {
            headLine = container.getClass().getSimpleName();
        }
    }

    public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
        this(container, tests);
        this.paramList = paramList;
    }

    public void setHeadLine(String newHeadLine) {
        this.headLine = newHeadLine;
    }

    public static <C> void run(C c, List<Test<C>> tests) {
        new Tester<>(c, tests).timedTest();
    }

    public static <C> void run(C c, List<Test<C>> tests, TestParam[] paramList) {
        new Tester<>(c, tests, paramList).timedTest();
    }

    private void displayHeader() {
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headLine.length() - 1;
        StringBuilder head = new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        head.append(' ');
        head.append(headLine);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        System.out.println(head);
        System.out.format(sizeField, "size");
        for (Test test : tests) {
            System.out.format(stringField(), test.name);
        }
        System.out.println();
    }


    public void timedTest() {
        displayHeader();
        for (TestParam param : paramList) {
            System.out.format(sizeField, param.size);
            for (Test<C> test : tests) {
                C kontainer = initialize(param.size);
                long start = System.nanoTime();
                int reps = test.test(kontainer, param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps;
                System.out.format(numberField(), timePerRep);
            }
            System.out.println();
        }
    }

}
