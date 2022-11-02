package com.on_java.functional.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/11/2 22:12
 */
public class LambdaDemo {

    public static void main(String[] args) {
//        int i = calculate((left, right) -> left / right, 20, 30);
//        System.out.println(i);
//        int j = calculate((int left, int right) -> {
//            return left / right;
//        }, 30, 40);
//        System.out.println(j);
        // lambda核心写法在于传入类的方法参数,不在于调用的方法参数
//        print(new IntPredicate() {
//            @Override
//            public boolean test(int value) {
//                return value < 40;
//            }
//        }, Arrays.asList(10, 30, 40, 50, 60));

//        String names = typeCover((String name) -> {
//            return "name: " + name;
//        }, "alone");
//        System.out.println(names);
        foreach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        }, Arrays.asList("a", "b", "c"));
    }


    public static <R> void foreach(Consumer<R> consumer, List<R> list) {
        for (R s : list) {
            consumer.accept(s);
        }
    }

    public static <T, R> R typeCover(Function<T, R> function, T t) {
        return function.apply(t);
    }

    public static int calculate(IntBinaryOperator operator, int a, int b) {
        return operator.applyAsInt(a, b);
    }


    public static void print(IntPredicate predicate, List<Integer> list) {
        for (Integer num : list) {
            if (predicate.test(num)) {
                System.out.println(num);
            }
        }
    }


}
