package com.example.minh.pokemonquizemall;

/**
 * Created by 123 on 20/11/2016.
 */

public class Pokemon {
    private int id;
    private String name;
    private String tag;
    private int gen;
    private String img;
    private String color;

    public Pokemon(int id, String name, String tag, int gen, String img, String color) {
        this.name = name;
        this.id = id;
        this.tag = tag;
        this.gen = gen;
        this.color = color;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public int getGen() {
        return gen;
    }

    public String getImg() {
        return img;
    }

    public String getColor() {
        return color;
    }
}
