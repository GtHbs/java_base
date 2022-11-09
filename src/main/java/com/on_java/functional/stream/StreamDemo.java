package com.on_java.functional.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/11/2 22:44
 */
public class StreamDemo {


    public static List<Author> getAuthors() {
        Author author1 = new Author(1L, "alone1", "my introduction 1", 18, null);
        Author author2 = new Author(2L, "alone2", "my introduction 2", 19, null);
        Author author3 = new Author(3L, "alone5", "my introduction 3", 14, null);
        Author author4 = new Author(4L, "alone4", "my introduction 4", 29, null);
        Author author5 = new Author(5L, "alone5", "my introduction 5", 12, null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        // 上面是作者和书
        books1.add(new Book(1L, "类别,分类啊", "书名1", 45D, "这是简介哦"));
        books1.add(new Book(2L, "高效", "书名2", 84D, "这是简介哦"));
        books1.add(new Book(3L, "喜剧", "书名3", 83D, "这是简介哦"));

        books2.add(new Book(5L, "天啊", "书名4", 65D, "这是简介哦"));
        books2.add(new Book(6L, "高效", "书名5", 89D, "这是简介哦"));

        books3.add(new Book(7L, "久啊", "书名6", 45D, "这是简介哦"));
        books3.add(new Book(8L, "高效", "书名7", 44D, "这是简介哦"));
        books3.add(new Book(9L, "喜剧", "书名8", 81D, "这是简介哦"));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);
        author5.setBooks(books2);
        return Arrays.asList(author1, author2, author3, author4, author5);
    }

    public static void main(String[] args) {
//        getAuthors().stream().filter(e -> e.getAge() < 18).map(e -> e.getName()).distinct().forEach(e -> {
//            System.out.println(e);
//        });
//        getAuthors().stream().sorted().forEach(System.out::println);
//        getAuthors().stream().sorted(new Comparator<Author>() {
//            @Override
//            public int compare(Author o1, Author o2) {
//                return o2.getAge() - o1.getAge();
//            }
//            // skip从列表开始往后跳过n个元素
//        }).skip(2).limit(2).forEach(System.out::println);
//        testFlatMap();
//        testMinAndMax();
//        testCollect();
//        testAnyMatch();
//        testAllMatch();
//        testFindAny();
//        findFirst();
        testReduce();
    }


    public static void testReduce() {
//        Integer sum = getAuthors().stream().distinct().map(e -> e.getAge()).reduce(0, new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                return integer + integer2;
//            }
//        });
//        System.out.println(sum);
//        Integer max = getAuthors().stream().map(e -> e.getAge()).reduce(0, new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                return integer > integer2 ? integer : integer2;
//            }
//        });
//        System.out.println(max);
        getAuthors().stream().map(e -> e.getAge()).reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return Math.min(integer, integer2);
            }
        }).ifPresent(System.out::println);
    }

    public static void findFirst() {
        boolean present = getAuthors().stream().findFirst().isPresent();
        System.out.println(present);
    }

    public static void testFindAny() {
        boolean present = getAuthors().stream().filter(e -> e.getAge() > 18).findAny().isPresent();
        System.out.println(present);
    }

    public static void testNoneMatch() {
        boolean match = getAuthors().stream().noneMatch(new Predicate<Author>() {
            @Override
            public boolean test(Author author) {
                return author.getAge() < 100;
            }
        });
        System.out.println(match);
    }

    public static void testAllMatch() {
        boolean match = getAuthors().stream().allMatch(new Predicate<Author>() {
            @Override
            public boolean test(Author author) {
                return author.getAge() > 1;
            }
        });
        System.out.println(match);
    }

    public static void testAnyMatch() {
        boolean match = getAuthors().stream().anyMatch(new Predicate<Author>() {
            @Override
            public boolean test(Author author) {
                return author.getAge() >= 29;
            }
        });
        System.out.println(match);
    }

    public static void testFlatMap() {
//        getAuthors().stream().flatMap(e -> e.getBooks().stream()).map(Book::getName).distinct().forEach(System.out::println);
        long l = getAuthors().stream().flatMap(e -> e.getBooks().stream()).distinct().flatMap(book -> Arrays.stream(book.getCategory().split(","))).distinct()
                .count();
        System.out.println(l);
    }

    public static void testMinAndMax() {
        getAuthors().stream().flatMap(e -> e.getBooks().stream()).map(e -> e.getScore()).max(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o1 - o2);
            }
        }).stream().limit(1).forEach(System.out::println);
    }


    public static void testCollect() {
        List<String> names = getAuthors().stream().map(e -> e.getName()).distinct().collect(Collectors.toList());
        System.out.println(names);
        Map<String, List<Book>> map = getAuthors().stream().distinct().collect(Collectors.toMap(new Function<Author, String>() {
            @Override
            public String apply(Author author) {
                return author.getName();
            }
        }, new Function<Author, List<Book>>() {
            @Override
            public List<Book> apply(Author author) {
                return author.getBooks();
            }
        }));
        System.out.println(map);
    }
}
