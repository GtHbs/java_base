package com.thinking.operator;

import org.junit.Test;
import com.thinking.reusedclass.Orange;

import java.util.Random;

import static com.thinking.operator.util.Print.print;

/**
 * @author 李昭
 * @Date 22:27 2020/5/12
 * @Description:
 * @Modified By:
 */
public class LogicOperator {

    @Test
    public void test() {
        Random random = new Random(47);
        int i = random.nextInt(100);
        int j = random.nextInt(100);
        /**
         * 短路与逻辑
         * 短路:
         *  &&,||: 表示只要第一个表达式符合了条件,其他表达式执行
         *  &,|:即使第一个表达式已经满足条件,剩余的表达式仍然会执行
         */
        print("(i < j) && (i > 10) is " + ((i < j) && (i > 10)));
    }

    @Test
    public void test02() {
        print(1 & 1);
        print(1 & 0);
        print(1 | 1);
        print(1 | 0);
        //1 在计算中使用补码表示为 1 ~表示取反 补码表示为 FFFFFFFE  转换为原码为 100000....00010 十进制为-2
        print(~1);
        //异或操作,相同为0不同为1
        print(1 ^ 0);
    }

    @Test
    public void test03() {
        //移位操作
        /**
         * 左移<<全部填0
         * 右移>>:
         *      为正高位填0,为负高位填1
         * 无符号右移>>>:都填0
         * 移位操作只能对整数执行,对char,short,byte类型进行移位时会将其先转换为int再执行
         */
        int i = -1;
        print(Integer.toBinaryString(i));
        i >>>= 10;
        print(Integer.toBinaryString(i));
        long l = -1;
        print(Long.toBinaryString(l));
        l >>>= 10;
        print(Long.toBinaryString(l));
        short s = -1;
        print(Integer.toBinaryString(s));
        s >>>= 10;
        print(Integer.toBinaryString(s));
        byte b = -1;
        print(Integer.toBinaryString(b));
        b >>>= 10;
        print(Integer.toBinaryString(b));
        b = -1;
        print(Integer.toBinaryString(b));
        print(Integer.toBinaryString(b >>> 10));
    }

    public static void main(String[] args) {
        Orange acid = new Orange("acid");
        /**
         * 包外非继承类不能访问protected方法
         */
//        acid.set();
    }
}
