package com.thinking.enumeration.addmethod;

/**
 * @Author 李昭
 * @Date 2020/7/13 07/43
 */
@SuppressWarnings("all")
public enum  SpaceShip {
    SCOUT,CARGO,TRANSPORT,CRUISER,BATTLESHIP,MOTHERSHIP;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (SpaceShip s : SpaceShip.values()) {
            System.out.println(s);
        }
    }
}
