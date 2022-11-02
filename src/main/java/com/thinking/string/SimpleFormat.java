package com.thinking.string;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @Author 李昭
 * @Date 2020/6/16 21/04
 */
public class SimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y = 5.332542;
        System.out.println("Row 1: [" + x + " " + y + "]");
        System.out.format("Row 1: [%d %f]\n", x, y);
        System.out.printf("Row 1: [%d %f]\n", x, y);
    }
}

class Turtle {
    private String name;
    private Formatter f;

    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y) {
        f.format("%s The Turtle is at(%d,%d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream s = System.out;
        Turtle tommy = new Turtle("Tommy", new Formatter(System.err));
        Turtle terry = new Turtle("Terry", new Formatter(s));
        tommy.move(0, 0);
        terry.move(4, 8);
        tommy.move(3, 4);
        terry.move(2, 5);
        tommy.move(3, 3);
        terry.move(3, 3);
    }
}

class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);

    public void printTitle() {
        f.format("%-15s %5s %10s\n", "Item", "Qty", "Prince");
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format("%-15.15s %5d %10.2f\n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2f\n", "Total", "", total * 0.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}

class Hex {
    public static String format(byte[] data) {
        StringBuilder builder = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0) {
                builder.append(String.format("%05X",n));
            }
            builder.append(String.format("%02X",b));
            n++;
            if (n % 16 == 0) {
                builder.append("\n");
            }
        }
        builder.append("\n");
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "20";
        String format = format(s.getBytes());
        System.out.println(format);
    }
}