package com.example.tjsillumiwax.Models;

public class Cateogry {
   private String name,brief,icon,color;
    private int id;

    public Cateogry() {
        // Empty constructor required for Firebase serialization
    }
    public Cateogry(String name, String icon, String color, String brief, int id)
    {
        this.name=name;
        this.icon= icon;
        this.color=color;
        this.brief=brief;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getBrief() {
        return brief;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

