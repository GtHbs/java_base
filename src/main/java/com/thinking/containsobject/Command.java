package com.thinking.containsobject;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: 李昭
 * @Date: 2020/6/9 20:14
 */
public class Command {
    private String msg = "刘国倩我好想你,我的高中同桌,好后悔当时没有追你,只顾着打游戏!";

    public void operation() {
        System.out.println(msg);
    }
}

class CommandProducer {

    Queue<Command> queue = new LinkedList<>();

    public void produce(Command command) {
        queue.offer(command);
        command.operation();
    }
}

class CommandConsumer {

    public static void consume(CommandProducer producer) {
        producer.produce(new Command());
    }

    public static void main(String[] args) {
        CommandProducer producer = new CommandProducer();
        consume(producer);
    }

}