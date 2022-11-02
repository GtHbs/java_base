package com.thinking.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 李昭
 * @Date 2020/6/16 20/04
 */
@SuppressWarnings("all")
public class InfiniteRecursion {
    @Override
    public String toString() {
        return " InfiniteRecursion address:" + super.toString() + "\n";
//        return " InfiniteRecursion address:" + this + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> recursions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            recursions.add(new InfiniteRecursion());
        }
        /**
         * 这里会发送内存溢出,因为List有默认实现的toString方法,而打印InfiniteRecursion会调用该对象的
         * toString方法,而toString中打印this,也会调用toString因此会发送递归调用toString导致内存溢出
         */
        System.out.println(recursions);
    }
}

@SuppressWarnings("all")
class TestIntern {
    public static void main(String[] args) {
        /**
         *  关于String对象的创建方式和存储位置:
         *  1, String s = "str";                //这种方式创建的字符串会直接存放在常量池中
         *  //这种方式创建的字符串,首先会在堆中创建一个String的对象,然后去常量池中查找是否存在str字符串,
         *  //如果存在,直接将对象的引用指向常量池中字符串的引用
         *  2, String s = new String("str");
         *  String h = new String("cc");
         *  String intern = h.intern();
         *  System.out.println(h == intern);  //false
         *  因为intern指向的为常量池中字符串的地址,而h指向的为对象的地址,所以为false
         *  jdk1.7之前:
         *      intern方法会将堆中创建的字符串复制一份放入到常量池中
         *  jdk1.7之后:
         *      intern方法执行后,常量池中只保存堆中字符串的地址
         *  也就是说,在堆中字符串是可以重复的,但是常量池中永远只有一份
         */
        String str2 = new String("str") + "01";
        str2.intern();
        String str1 = "str01";
        System.out.println(str1 == str2);

        String str3 = new String("str") + "03";
        String str4 = "str03";
        str3.intern();
        System.out.println(str3 == str4);

        String a = "a";
        String b = "b";
        String ab = "ab";
        String ab2 = "a" + "b";
        final String a2 = "a";
        final String b2 = "b";
        //有变量引用的字符串使用操作符重载会创建新的对象(存放在堆中)
        System.out.println((a + b) == ab);
        //直接使用字符串进行拼接等于是在常量池中操作
        System.out.println(ab == ab2);
        //使用final修饰的带变量的字符串拼接也是在常量池中操作的
        System.out.println((a2 + b2) == ab);
    }
}
