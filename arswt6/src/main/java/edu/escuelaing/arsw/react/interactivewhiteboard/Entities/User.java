package edu.escuelaing.arsw.react.interactivewhiteboard.Entities;

public class User {
    private String name;
    private Color color;

    public User(String name){
        this.name = name;
        color = new Color();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
