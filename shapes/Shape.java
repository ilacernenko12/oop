package shapes;

import java.awt.*;

public abstract class Shape {
    // color setting
    private Color borderColor;
    // constructor
    public Shape(){
        borderColor = Color.BLACK;
    }
    // getter
    public Color getBorderColor(){
        return borderColor;
    }
    // setter
    public void setBorderColor(Color borderColor){
        this.borderColor = borderColor;
    }

    // method templates since the class is the parent
    public abstract void refreshShape(shapes.Point point);

    public abstract void draw(Graphics g);
}