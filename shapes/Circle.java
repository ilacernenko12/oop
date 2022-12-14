package shapes;

import java.awt.*;

public class Circle extends Ellipse {
    // constructor
    public Circle(Point center, int radius){
        super(new Point(center.x - radius, center.y - radius), radius*2, radius*2);
    }

    // method of Graphics class (default)
    @Override
    public void draw(Graphics g){
        g.setColor(Color.YELLOW);

        int width = getBottomRight().x - getTopLeft().x;
        int height = getBottomRight().y - getTopLeft().y;
        int d = Math.min(width, height);

        Point fixedPoint = getFixedPoint();
        int topX = fixedPoint.x + d * (int)Math.signum(getTopLeft().x - fixedPoint.x);
        int topY = fixedPoint.y + d * (int)Math.signum(getTopLeft().y - fixedPoint.y);

        g.drawOval(topX, topY, d, d);
    }
}
