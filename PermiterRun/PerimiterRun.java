import edu.duke.*;
/**
 * Write a description of PerimiterRun here.
 * 
 * @author (Thomas Staszel)
 * @version (a version number or a date)
 */
public class PerimiterRun {
    public double getPerimeter (Shape s) {
        double totalPerim = 0;
        Point prevPt = s.getLastPoint();
        
        for(Point currPt: s.getPoints()){
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
    }
    return totalPerim;
    }
    
    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("Perimeter = " + length);
    }
    public static void main (String[] args) {
        PerimiterRun pr = new PerimiterRun();
        pr.testPerimeter();
    }
}
