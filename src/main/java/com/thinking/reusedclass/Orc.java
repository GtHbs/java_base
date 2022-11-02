package com.thinking.reusedclass;

/**
 * @author 李昭
 * @Date 7:55 2020/5/22
 * @Description:
 * @Modified By:
 */
public class Orc extends Villain {


    private int orcNumber;

    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber) {
        //调用父类的方法
        set(name);
        this.orcNumber = orcNumber;
    }

    public String toString() {
        return "Orc " + orcNumber + ":" + super.toString();
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Limbuger", 12);
        System.out.println(orc);
        orc.change("Bob", 19);
        System.out.println(orc);
        Orange sweet = new Orange("sweet");
        //包内非继承类可以访问protected方法
        sweet.set("acid");
    }


}

class Villain {
    private String name;

    protected void set(String name) {
        this.name = name;
    }

    public Villain(String name) {
        this.name = name;
    }

    public String toString() {
        return "I`m a Villain and my name is " + name;
    }
}