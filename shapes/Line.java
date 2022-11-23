package shapes;

public class Line extends Polyline {
    // constructors. depending on getting coordinates
    public Line(Point p){
        addPoint(p);
        addPoint(p);
    }
    public Line(Point a, Point b){
        addPoint(a);
        addPoint(b);
    }

    // level position of line
    @Override
    public void refreshShape(Point finishPoint){
        setPoint(1, finishPoint);
    }
}
