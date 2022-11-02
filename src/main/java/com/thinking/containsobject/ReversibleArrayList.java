package com.thinking.containsobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author: 李昭
 * @Date: 2020/6/10 20:41
 */
public class ReversibleArrayList<T> extends ArrayList<T> {
    private static final long serialVersionUID = -5674204143317193184L;

    public ReversibleArrayList(final Collection c) {
        super(c);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int current = size() - 1;

            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public T next() {
                return get(current--);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(Arrays.asList("To be or not to be".split(" ")));
        for (String s : ral) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (Iterator<String> it = ral.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.print(s + " ");
        }
    }
}
