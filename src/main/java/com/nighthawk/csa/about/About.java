package com.nighthawk.csa.about;

public class About {
    private String name;

    public About(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "About [name=" + name + "]";
    }
}

