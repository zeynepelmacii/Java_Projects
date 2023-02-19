package com.company;

public class Month {
    private String name;
    private int gün;

    public Month(String name, int gün) {
        this.name = name;
        this.gün = gün;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGün() {
        return gün;
    }

    public void setGün(int gün) {
        this.gün = gün;
    }
}
