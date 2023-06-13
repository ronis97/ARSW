package edu.escuelaing.arsw.taller2.app.Generics;

import java.util.List;

public class Canvas {
    public void draw(Shape s){
        s.draw(this);
    }

    public void drawAll(List<? extends Shape> shapes){
        for (Shape s: shapes){
            s.draw(this);
        }
    }
}
