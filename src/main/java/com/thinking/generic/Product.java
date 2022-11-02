package com.thinking.generic;

import java.util.ArrayList;
import java.util.Random;

/**
 * 商品<br>
 *
 * @Author 李昭
 * @Date 2020/6/19 21/17
 */
public class Product {
    private final int id;
    private String description;
    private double price;

    private static final Random random = new Random(47);

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }

    private void priceChange(double price) {
        this.price += price;
    }

    /**
     * 使用生成器生成商品
     */
    public static Generator<Product> generator = () -> new Product(random.nextInt(1000), "Test",
            Math.round(random.nextDouble() * 1000.0) + 0.99);
}

/**
 * 货架<br>
 */
class Shelf extends ArrayList<Product> {
    /**
     * 使用生成器填充商品
     */
    public Shelf(int count) {
        Generators.fill(this, Product.generator, count);
    }
}

/**
 * 走道<br>
 * 一个走道有多少个货架,每个货架上有多少货物<br>
 */
class Aisle extends ArrayList<Shelf> {
    public Aisle(int count, int products) {
        for (int i = 0; i < count; i++) {
            add(new Shelf(products));
        }
    }
}

class Store extends ArrayList<Aisle> {
    public Store(int nAisle, int nShelves, int nProducts) {
        for (int i = 0; i < nAisle; i++) {
            add(new Aisle(nShelves, nProducts));
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Aisle a : this) {
            for (Shelf s : a) {
                for (Product p : s) {
                    builder.append(p);
                    builder.append("\n");
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(14, 5, 10));
    }
}