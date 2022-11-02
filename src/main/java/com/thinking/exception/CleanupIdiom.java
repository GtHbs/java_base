package com.thinking.exception;

/**
 * @Author 李昭
 * @Date 2020/6/14 21/34
 */
public class CleanupIdiom {
    public static void main(String[] args) {
        NeedsCleanup cleanup = new NeedsCleanup();
        try {
        } finally {
            cleanup.dispose();
        }

        NeedsCleanup cleanup2 = new NeedsCleanup();
        NeedsCleanup cleanup3 = new NeedsCleanup();
        try {
        } finally {
            cleanup3.dispose();
            cleanup2.dispose();
        }

        try {
            /**
             * 对于在构造器中创建需要释放内存的对象,在创建时需要单独存放在一个try,finally块中释放内存
             */
            NeedsCleanup2 cleanup4 = new NeedsCleanup2();
            try {
                NeedsCleanup2 cleanup5 = new NeedsCleanup2();
                try {
                } finally {
                    cleanup5.dispose();
                }
            } catch (ConstructionException e) {
                System.out.println(e);
            } finally {
                cleanup4.dispose();
            }
        } catch (ConstructionException e) {
            System.out.println(e);
        }
    }
}

class NeedsCleanup {
    private static long counter = 1;
    private final long id = counter++;

    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

class ConstructionException extends Exception {
}

class NeedsCleanup2 extends NeedsCleanup {
    public NeedsCleanup2() throws ConstructionException {
    }
}
