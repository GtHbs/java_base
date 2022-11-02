package com.on_java.functional.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/11/2 22:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Author implements Comparable<Author> {

    private Long id;

    private String name;

    private String intro;
    private Integer age;

    private List<Book> books;

    @Override
    public int compareTo(Author o) {
        return o.getAge() - this.getAge();
    }
}
