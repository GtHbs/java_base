package com.thinking.enumeration.addmethod;

/**
 * @Author 李昭
 * @Date 2020/7/13 07/34
 */
@SuppressWarnings("all")
public enum  OzWitch {
    WEST("Miss Gluch,aka the wicked witch of west"),
    NORTH("Glinda, the Good witch of North"),
    EAST("学习Spring Action"),
    SOUTH("学习HTTP协议");
    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void sayHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + " : " + witch.getDescription());
            witch.sayHello();
        }
    }
}
