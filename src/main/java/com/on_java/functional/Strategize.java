package com.on_java.functional;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/10/31 22:47
 */
public class Strategize {

    Strategy strategy;

    String msg;

    public Strategize(String msg) {
        this.msg = msg;
        strategy = new Soft();
    }

    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                msg -> msg.toUpperCase() + "?",
                msg1 -> msg1.substring(0, 5),
                Unrelated::twice
        };
        Strategize s = new Strategize("Hello World");
        s.communicate();
        for (Strategy strategy : strategies) {
            s.changeStrategy(strategy);
            s.communicate();
        }
    }
}


interface Strategy {
    String approach(String msg);
}


class Soft implements Strategy {

    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}


class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}