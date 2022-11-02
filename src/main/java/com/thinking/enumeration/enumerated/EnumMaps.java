package com.thinking.enumeration.enumerated;

import java.util.EnumMap;
import java.util.Map;

import static com.thinking.enumeration.enumerated.AlarmPoints.*;

/**
 * @Author 李昭
 * @Date 2020/7/15 07/29
 */
public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        /**
         * 使用命令模式
         */
        em.put(KITCHEN,()->{
            System.out.println("Kitchen fire!");
        });
        em.put(BATHROOM,()->{
            System.out.println("Bathroom alert!");
        });
        for (Map.Entry<AlarmPoints,Command> entry : em.entrySet()) {
            System.out.println(entry.getKey() + " : " );
            entry.getValue().action();
        }
        try {
            em.get(UTILITY).action();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


interface Command {
    void action();
}