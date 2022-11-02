package com.thinking.reusedclass;

/**
 * @author 李昭
 * @Date 7:48 2020/5/27
 * @Description:
 * @Modified By:
 */
public class BasicClass {
    public void say() {
        eat();
    }
    public void eat() {
        System.out.println("eat fruit");
    }

    private void scream() {
        System.out.println("basic class scream");
    }

    protected void jump() {
        System.out.println("basic class jump");
    }
    void kiss() {
        System.out.println("basic class kiss");
    }
}
class ExtendClass extends BasicClass {
    @Override
    public void eat() {
        System.out.println("extend class eat method");
    }

    public void scream() {
        System.out.println("extend class scream");
    }

    @Override
    public void jump() {
        System.out.println("extend class jump");
    }

    @Override
    void kiss() {
        System.out.println("extend class kiss");
    }

    public static void main(String[] args) {
        BasicClass basicClass = new ExtendClass();
        //多态调用导出类的覆盖方法(只有非private方法才可以覆盖)
        basicClass.say();
        basicClass.jump();
        basicClass.kiss();
    }
}
