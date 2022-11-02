package com.thinking.operator;

import org.junit.Test;

import java.util.Random;

import static com.thinking.operator.util.Print.print;

/**
 * @author 李昭
 * @Date 7:55 2020/5/12
 * @Description:
 * @Modified By:
 */
public class MathOperators {
    @Test
    public void test() {
        Random random = new Random(47);
        int i,j,k;
        j = random.nextInt(100) + 1;
        print("j: "+j);
        k = random.nextInt(100) + 1;
        print("k: "+k);
        i = j + k;
        print("j + k: " + i);
        i = j - k;
        print("j - k: " + i);
        i = j / k;
        print("j / k: " + i);
        i = j * k;
        print("j * k: " + i);
        i = j % k;
        print("j % k: " + i);
        j %= k;
        print("j % k: " + j);
        //运算顺序,会先执行运算,然后再赋值
        --j;
    }
}
