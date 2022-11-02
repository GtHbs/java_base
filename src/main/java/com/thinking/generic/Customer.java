package com.thinking.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @Author 李昭
 * @Date 2020/6/19 21/01
 */
public class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {

    }

    @Override
    public String toString() {
        return "Customer " + id;
    }

    public static Generator<Customer> generator() {
        return () -> new Customer();
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {

    }

    @Override
    public String toString() {
        return "Teller " + id;
    }

    public static Generator<Teller> generator() {
        return () -> new Teller();
    }
}

class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> queue = new LinkedList<>();
        Generators.fill(queue, Customer.generator(), 15);
        ArrayList<Teller> list = new ArrayList<>();
        Generators.fill(list, Teller.generator(), 4);
        for (Customer customer : queue) {
            serve(list.get(random.nextInt(list.size())), customer);
        }
    }
}