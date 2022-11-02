package com.thinking.reusedclass;

/**
 * @author 李昭
 * @Date 8:13 2020/5/28
 * @Description:
 * @Modified By:
 */
public class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }
    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph.RoundGlyph(),radius = " + radius);
    }
    void draw() {
        System.out.println("RoundGlyph.draw(),radius = " + radius);
    }
}
class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
