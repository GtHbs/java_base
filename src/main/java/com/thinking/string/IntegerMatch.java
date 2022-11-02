package com.thinking.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author 李昭
 * @Date 2020/6/17 09/54
 */
public class IntegerMatch {

    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+987".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
}

class Splitting {
    public static String knights = "Then, when you have found the shrubbery, you must cut down the mightiest tree in the forest... with... a herring";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        //按照空格切分字符串
        split(" ");
        //按照非单词字符,\w表示一个单词字符
        split("\\W+");
        //n后面跟着一个或者多个非单词字符,所以n后面的字符都不见了
        split("n\\W+");
    }
}

class Replacing {
    static String s = Splitting.knights;

    public static void main(String[] args) {
        //w小写,表示只替换掉第一个匹配的地方
        System.out.println(s.replaceFirst("f\\w+", "located"));
        //|和Java中一样,或,所有匹配的都进行替换
        System.out.println(s.replaceAll("shrubbery|tree|herring", "banana"));
    }
}

class Rudolph {
    public static void main(String[] args) {
        for (String pattern : new String[]{"Rudolph", "[rR]udolph", "[rR][aeious][a-z]ol.*", "R.*"}) {
            System.out.println("Rudolph".matches(pattern));
        }
    }
}

@SuppressWarnings("all")
class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        //[This, unusual use, of exclamation, points]
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input)));
        //[This, unusual use, of exclamation!!points],3表示限制切割成字符串的数量
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input, 3)));
    }
}

class SimpleRead {
    public static BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803"));

    public static void main(String[] args) {
        try {
            System.out.println("What is your name?");
            String name = input.readLine();
            System.out.println(name);
            System.out.println("How old are you? What's your favorite double?");
            System.out.println("(input: <age> <double>)");
            String numbers = input.readLine();
            System.out.println(numbers);
            String[] numArray = numbers.split(" ");
            int age = Integer.parseInt(numArray[0]);
            double favorite = Double.parseDouble(numArray[1]);
            System.out.format("Hi %s. \n", name);
            System.out.format("In 5 years you will be %d.\n", age + 5);
            System.out.format("My favorite double is %f", favorite / 2);
        } catch (IOException e) {
            System.err.println("IOException");
        }
    }
}




