package com.on_java.functional.lambda;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/10/31 22:54
 */
public class LambdaExpressions {

    static Body bod = h -> h + "no params";
    static Body bod2 = (h) -> h + "more details";
    static Description desc = () -> "short info";
    static Multi multi = (h, n) -> h + n;
    static Description moreLines = () -> {
        System.out.println("more lines");
        return "from moreLines";
    };

    public static void main(String[] args) {
        System.out.println(bod.detailed("oh"));
        System.out.println(bod2.detailed("hi"));
        System.out.println(desc.brief());
        System.out.println(multi.twoArg("pi", Math.PI));
        System.out.println(moreLines.brief());
    }

}

interface Description {
    String brief();
}

interface Body {
    String detailed(String head);
}

interface Multi {
    String twoArg(String head, Double d);
}
