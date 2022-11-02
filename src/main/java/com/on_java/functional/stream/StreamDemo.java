package com.on_java.functional.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        testFlatMap();
    }

    public static void testFlatMap() {
//        getAuthors().stream().flatMap(e -> e.getBooks().stream()).map(Book::getName).distinct().forEach(System.out::println);
        long l = getAuthors().stream().flatMap(e -> e.getBooks().stream()).distinct().flatMap(book -> Arrays.stream(book.getCategory().split(","))).distinct()
                .count();
        System.out.println(l);
    }
}
