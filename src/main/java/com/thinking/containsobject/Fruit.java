package com.thinking.containsobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 李昭
 * @Date: 2020/6/9 20:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fruit {
    private String name;
    private String color;
    private double weight;
}
