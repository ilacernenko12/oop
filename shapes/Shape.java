package shapes;

import java.awt.*;

public abstract class Shape {
    // color setting
    private Color borderColor1;
    // constructor
    public Shape(){
        borderColor1 = Color.MAGENTA;
    }
    // getter
    public Color getBorderColor1(){
        return borderColor1;
    }
    // setter
    public void setBorderColor1(Color borderColor){
        this.borderColor1 = borderColor;
    }

    // method templates since the class is the parent
    public abstract void refreshShape(shapes.Point point);

    public abstract void draw(Graphics g);
}