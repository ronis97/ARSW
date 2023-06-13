package edu.escuelaing.arsw.react.interactivewhiteboard.Entities;

public class Color {
    private int r;
    private int g;
    private int b;

    public Color(int r,int g,int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color(){
        this.r = (int) (Math.random() * 256);
        this.g = (int) (Math.random() * 256);
        this.b = (int) (Math.random() * 256);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
