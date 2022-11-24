package shapes;

import java.awt.*;

public class Polygon extends Polyline {
    // constructors. super because extends options of parent
    public Polygon(){}
    public Polygon(Point point){
        super(point);
    }
    // method of Graphics class (default)
    public void draw(Graphics g){
        g.setColor(Color.cyan);
        g.drawPolygon(getXs(), getYs(), getPointsCount());
    }
}
