package com.thinking.classinfo;

import java.util.Arrays;
import java.util.List;

/**
 * @Author 李昭
 * @Date 2020/6/17 10/44
 */
public abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    /**
     * @return
     */
    abstract public String toString();
}

class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {

    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {

    @Override
    public String toString() {
        return "Triangle";
    }
}

class Shapes {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Triangle());
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}