package com.thinking.innerclass;

/**
 * @author 李昭
 * @date
 */
public class Parcell {
    class Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }
    class Destination {
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() {
            return label;
        }
    }

    public void ship(String destination) {
        Contents contents = new Contents();
        System.out.println(contents.value());
        Destination dest = new Destination(destination);
        System.out.println(dest.readLabel());
    }

    public static void main(String[] args) {
        Parcell parcell = new Parcell();
        parcell.ship("Tanzania");
    }
}
