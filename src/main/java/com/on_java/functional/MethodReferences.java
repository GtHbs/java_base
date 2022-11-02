package com.on_java.functional;

/**
 * Created by Kerwinnli.
 *
 * @author: Kerwinnli
 * @date: 2022/10/31 23:09
 */
public class MethodReferences {


    static void hello(String name) {
        System.out.println("hello " + name);
    }

    static class Description {
        String about;

        public Description(String about) {
            this.about = about;
        }

        void help(String msg) {
            System.out.println(about + " " + msg);
        }

    }

    static class Helper {
        static void assist(String msg) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d::show;
        c.call("call()");
        c = MethodReferences::hello;
        c.call("bob");
        c = new Description("valuable")::help;
        c.call("information");
        c = Helper::assist;
        c.call("help");
    }
}


interface Callable {
    void call(String s);
}

class Describe {
    void show(String msg) {
        System.out.println(msg);
    }
}