package shapes;

import java.awt.*;
import java.util.ArrayList;

public class Polyline extends Shape{
    private ArrayList<Point> points = new ArrayList<>();
    // constructor
    public  Polyline(){}

    // when Point-object will be created, him added in ArrayList
    public Polyline(Point point){
        points.add(point);
    }

    public void addPoint(Point p){
        points.add(p);
    }
    // setter with condition
    protected void setPoint(int i, Point newPoint){
        if (i < points.size()){
            points.set(i, newPoint);
        } else {
            if (i == points.size()){
                addPoint(newPoint);
            }
        }
    }
    //Stream Java 8. Find x/y
    protected int[] getXs(){
        return points.stream().mapToInt((s) -> s.x).toArray();
    }

    protected int[] getYs(){
        return points.stream().mapToInt((s) -> s.y).toArray();
    }
    // geter
    public Point getPoint(int i){
        return points.get(i);
    }
    // getter of count
    public int getPointsCount(){
        return points.size();
    }

    // method templates since the class is the parent
    @Override
    public void refreshShape(Point p){
        addPoint(p);
    }

    // setter
    public void setFinishPoint(Point point){
        if (getPointsCount() < 2){
            addPoint(point);
        } else {
            setPoint(getPointsCount() - 1, point);
        }
    }

    public void removeLastPoint(){
        if (points.size() > 0){
            points.remove(points.size() - 1);
        }
    }
    // method of Graphics class (default)
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.drawPolyline(getXs(), getYs(), getPointsCount());
    }
}
