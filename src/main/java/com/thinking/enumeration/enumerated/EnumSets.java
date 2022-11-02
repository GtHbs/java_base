package com.thinking.enumeration.enumerated;

import java.util.EnumSet;
import static com.thinking.enumeration.enumerated.AlarmPoints.*;

/**
 * @Author 李昭
 * @Date 2020/7/14 08/03
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        System.out.println(points);
        points.add(BATHROOM);
        points.addAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        System.out.println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        System.out.println(points);
        points.removeAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        System.out.println(points);
        points.removeAll(EnumSet.range(OFFICE1,OFFICE4));
        System.out.println(points);
        //补集
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}
