package com.thinking.enumeration.switchinenum;

import static com.thinking.enumeration.switchinenum.Signal.*;
/**
 * @Author 李昭
 * @Date 2020/7/13 07/49
 */
@SuppressWarnings("all")
public class TrafficLight {
    Signal color = RED;
    public void change() {
        switch (color) {
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
                "color=" + color +
                '}';
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(light);
            light.change();
        }
    }
}

enum Signal {
    GREEN,YELLOW,RED
}
