package bearmaps;


import java.util.ArrayList;
import java.util.List;

class NaivePointSet implements PointSet{

    List<Point> pointList = new ArrayList<>();
    public NaivePointSet(List<Point> points){
        pointList.addAll(points);
    }

    @Override
    public Point nearest(double x, double y){
        double minDist = Double.POSITIVE_INFINITY;
        Point closestPoint = new Point(0, 0);
        for (Point pt:pointList){
            if (Math.sqrt(Math.pow((pt.getX()-x),2)+Math.pow((pt.getY()-y),2)) < minDist){
                minDist = Math.sqrt(Math.pow((pt.getX()-x),2)+Math.pow((pt.getY()-y),2));
                closestPoint = pt;
            }
        }
        return closestPoint;
    }

    public static void main(String[] args){
        Point p1 = new Point(1.1, 2.2); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(3.3, 4.4);
        Point p3 = new Point(-2.9, 4.2);

        NaivePointSet nn = new NaivePointSet(List.of(p1, p2, p3));
        Point ret = nn.nearest(3.0, 4.0); // returns p2
        ret.getX(); // evaluates to 3.3
        ret.getY(); // evaluates to 4.4
        int a = 1;
    }
}