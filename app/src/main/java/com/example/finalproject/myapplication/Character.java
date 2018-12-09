package com.example.finalproject.myapplication;

import java.util.ArrayList;

// this class creates and maintains characters in Mario Kart.
public class Character {
    public static ArrayList<Character> characters = new ArrayList<>();

    private String name;
    private int[] stats;
    // private ** picture;

    private Character(String setName, int[] setStats, ArrayList<Character> characters) {
        name = setName;
        stats = setStats;
        characters.add(this);
    }

    private static int[] mario = {3, 3, 3, 4, 4};
    private static int[] peach = {1,1,1,5,5};
    private static int[] wario = {5,5,1,1,3};
    public static final Character MARIO = new Character("mario", mario, characters);
    public static final Character PEACH = new Character("peach", peach, characters);
    public static final Character WARIO = new Character("wario", wario, characters);

    public String getName() {
        return name;
    }
    public int[] getStats() {
        return stats;
    }
}
