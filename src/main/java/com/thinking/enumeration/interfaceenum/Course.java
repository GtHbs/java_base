package com.thinking.enumeration.interfaceenum;

import com.thinking.enumeration.randomaccess.Enums;

/**
 * 使用枚举来包装另一个枚举类型
 *
 * @Author 李昭
 * @Date 2020/7/14 07/33
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class),
    TEST;
    private Food[] values;

    Course() {
    }

    Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}


class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("-------------");
        }
        System.out.println(Course.TEST.name());
    }

}
