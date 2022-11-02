package com.thinking.containsobject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 李昭
 * @Date: 2020/6/7 9:33
 */
public class Gerbil {
    private int gerbilNumber;

    public Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    public void hop() {
        System.out.println("Gerbil is jumping!");
        System.out.println(gerbilNumber);
    }

    public static void main(String[] args) {
        List<Gerbil> gerbils = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            gerbils.add(new Gerbil((int) (i * Math.random() * 100)));
        }
        for (Gerbil gerbil : gerbils) {
            gerbil.hop();
        }
    }
}
