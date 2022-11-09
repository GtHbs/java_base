package com.on_java.functional.optional;

import com.on_java.functional.stream.Author;
import com.on_java.functional.stream.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/11/6 21:15
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Author author = getAuthor();
        Optional<Author> authorOptional = Optional.ofNullable(author);
        authorOptional.ifPresent(e -> System.out.println(e.getName()));
//        Author author1 = authorOptional.get();
//        System.out.println(author1);
//        Author author1 = authorOptional.orElseGet(() -> new Author());
//        System.out.println(author1);
//        Author author1 = authorOptional.filter(e -> e.getAge() < 20).orElseGet(() -> new Author());
//        System.out.println(author1);
//        System.out.println(authorOptional.isPresent());
        List<Book> books = authorOptional.map(e -> e.getBooks()).orElseGet(() -> new ArrayList<>());
        System.out.println(books);
    }




    public static Optional<Author> getAuthorOptional() {
        Author author = new Author(1L, "alone1", "my introduction 1", 18, null);
        return Optional.ofNullable(author);
    }

    public static Author getAuthor() {
        Author author = new Author(1L, "alone1", "my introduction 1", 18, null);
        return null;
    }
}
