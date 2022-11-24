package shapes;

import java.awt.*;

public class Ellipse extends Shape{
    private Point fixedPoint, movingPoint;

    // constructor
    public Ellipse(Point topLeft, int width, int height) {
        fixedPoint = topLeft;
        movingPoint = new Point(topLeft.x + width, topLeft.y + height);
    }

    // getter
    protected Point getFixedPoint(){
        return this.fixedPoint;
    }

    // getter of coordinate
    protected Point getTopLeft(){
        int xMin = Math.min(fixedPoint.x, movingPoint.x);
        int yMin = Math.min(fixedPoint.y, movingPoint.y);

        return new Point(xMin, yMin);
    }

    // level position of line
    public void refreshShape(Point point){
        movingPoint = new Point(point);
    }
    // getter
    protected Point getBottomRight(){
        int xMax = Math.max(fixedPoint.x, movingPoint.x);
        int yMax = Math.max(fixedPoint.y, movingPoint.y);

        return new Point(xMax, yMax);
    }

    // method of Graphics class (default)
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        Point topLeft = getTopLeft();
        Point bottomRight = getBottomRight();

        g.drawOval(topLeft.x, topLeft.y, bottomRight.x - topLeft.x, bottomRight.y - topLeft.y);
    }
}
