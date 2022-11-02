package com.thinking.innerstudycollection.fillcollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author 李昭
 * @Date 2020/6/22 21/57
 */
public class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}

class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> addresses = new ArrayList<>(Collections.nCopies(4, new StringAddress("Hello")));
        System.out.println(addresses);
        Collections.fill(addresses, new StringAddress("World!"));
        System.out.println(addresses);
    }
}