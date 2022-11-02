package com.thinking.innerclass;


/**
 * @author 李昭
 * @date
 */
public abstract class Contents {
    abstract public int values();
}

interface Destination {
    String readLabel();
}

class Parcel {
    /**
     * 私有的内部内只能在类的内部进行访问
     */
    private class PContents extends Contents {
        private int i = 11;

        public int value() {
            return i;
        }

        public int values() {
            return 0;
        }
    }

    /**
     * 该类可以被继承的类,包内的类,以及Parcel类内部进行访问
     */
    protected class PDestination implements Destination {

        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        public String readLabel() {
            return label;
        }
    }

    public Destination dest(String label) {
        return new PDestination(label);
    }

    public Contents contents() {
        return new PContents();
    }
}

class Test {
    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        Contents contents = parcel.contents();
        Destination destination = parcel.dest("Destination");
        //不能访问私有类
//        Parcel.PContents c = parcel.new PContents();
    }
}