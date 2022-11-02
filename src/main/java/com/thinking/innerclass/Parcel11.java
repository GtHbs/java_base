package com.thinking.innerclass;

/**
 * @author: 李昭
 * @Date: 2020/6/4 8:11
 */
public class Parcel11 {
    /**
     * 私有的静态内部类
     */
    private static class ParcelContents extends Contents {
        private int i = 11;

        @Override
        public int values() {
            return i;
        }
    }

    /**
     * 受保护的静态内部类
     */
    protected static class ParcelDestination implements Destination {
        private String label;

        protected ParcelDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }

        public static void f() {
        }

        static int x1 = 10;
        int i = 10;

        static class AnotherLevel {
            public static void f() {
                //静态内部类不能访问外部非静态属性
//                System.out.println(i);
                System.out.println(x1);
            }

            static int x = 10;
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents contents = contents();
        System.out.println(contents.values());
        Destination tasmania = destination("Tasmania");
        System.out.println(tasmania.readLabel());
        /*
         * 创建静态内部类
         */
        ParcelDestination.AnotherLevel anotherLevel = new ParcelDestination.AnotherLevel();
        ParcelDestination.AnotherLevel.f();
    }
}
