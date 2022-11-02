package com.thinking.innerclass;

/**
 * @author 李昭
 * @date
 */
public class Parcel5 {

    private void intervalTracking(boolean b) {
        if (b) {
            /**
             * 虽然该类在条件语句内,但是其会随同其他东西一起得到编译
             */
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip slip = new TrackingSlip("slip");
            String s = slip.getSlip();
            System.out.println(s);
        }
    }

    public void track() {
        intervalTracking(true);
    }

    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        parcel5.track();
    }
}

class Parcel6 {
    public Contents cont() {
        /**
         * 匿名内部类,该匿名内部类使用的是默认构造器创建的
         */
        return new Contents() {
            private int i = 11;

            @Override
            public int values() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        Contents cont = parcel6.cont();
    }
}


class Parcel7 {
    public Wrapping wrap(int x) {
        return new Wrapping(x) {
            public int value() {
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 parcel7 = new Parcel7();
        Wrapping wrap = parcel7.wrap(10);
        System.out.println(wrap.value());
    }
}

class Parcel8 {

    /**
     * 匿名内部类的对象要使用外部的对象,外部对象必须为final的
     *
     * @param dest
     * @return
     */
    public Destination dest(final String dest) {
        return new Destination() {
            private String label = dest;

            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Destination tanzania = parcel8.dest("Tanzania");
        System.out.println(tanzania.readLabel());
    }
}

class Parcel9 {
    public Destination dest(final String dest, final float price) {
        return new Destination() {
            private int cost;
            private String label = dest;

            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Over budget!");
                }
            }

            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination tanzania = parcel9.dest("Tanzania", 101.395F);
        System.out.println(tanzania.readLabel());
    }
}