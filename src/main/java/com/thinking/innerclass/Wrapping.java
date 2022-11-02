package com.thinking.innerclass;

/**
 * @author 李昭
 * @date
 */
public class Wrapping {
    private int i;

    public Wrapping(int i) {
        this.i = i;
    }

    public int value() {
        return i;
    }
}

class Parcel4 {
    public Destination dest(String s) {
        /**
         * 局部内部类,该类是属于dest方法,而不是最外层的类,
         * 并且该类不能从外部访问
         */
        class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();
        Destination dest = parcel4.dest("Tanzania");
    }
}
