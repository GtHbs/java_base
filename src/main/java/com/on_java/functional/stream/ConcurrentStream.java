package com.on_java.functional.stream;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static com.on_java.functional.stream.StreamDemo.getAuthors;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/11/6 21:47
 */
public class ConcurrentStream {


    public static void main(String[] args) {
//        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        Integer get = stream.parallel().peek(integer -> System.out.println(Thread.currentThread().getName())).filter(e -> e > 5).reduce(new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                return integer + integer2;
//            }
//        }).orElseGet(() -> 2);
//        System.out.println(get);
        List<Author> authors = getAuthors();
        Integer get = authors.parallelStream().map(e -> e.getAge()).peek(integer -> System.out.println(Thread.currentThread().getName())).filter(e -> e > 5).reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }).orElseGet(() -> 2);
        System.out.println(get);
    }
}
