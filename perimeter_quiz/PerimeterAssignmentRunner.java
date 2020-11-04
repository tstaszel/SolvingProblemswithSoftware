import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count = 0;
        for(Point currPt: s.getPoints()){
            count++;
            
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        double count = 0.0;
        
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
            count++;
        }
        double averageSum = (totalPerim / count);
        return averageSum;
    }

    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        double newSide = 0.0;
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
            if (largestSide < currDist) {
                largestSide = currDist;
            }
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double lrgX = 0.0;
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        double newSide = 0.0;
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            double a = currPt.getX();
            double b = prevPt.getX();
            prevPt = currPt;
            if (a < b) {
                lrgX = b;
            }
        }
        return lrgX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double maxFile = 0.0;
        
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double lrgSide = getPerimeter(s);
                if (maxFile < lrgSide) {
                    maxFile = lrgSide;
                }
        }
        return maxFile;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        
        DirectoryResource dr = new DirectoryResource();
        double maxFile = 0.0;
        
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double lrgSide = getLargestSide(s);
                if (maxFile < lrgSide) {
                    maxFile = lrgSide;
                    temp = f;
                }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPt = getNumPoints(s);
        double avgSum = getAverageLength(s);
        double lrgSide = getLargestSide(s);
        double lrgrX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of points is : " + numPt);
        System.out.println("Average is : " + avgSum);
        System.out.println("Largest Side : " + lrgSide);
        System.out.println("Largest X: " + lrgrX);
        System.out.println("");
    }
    
    public void testPerimeterMultipleFiles() {
        double maxLength = getLargestPerimeterMultipleFiles();
        System.out.println("Here is the biggest side: " + maxLength);
        System.out.println("");
    }

    public void testFileWithLargestPerimeter() {
        String name = getFileWithLargestPerimeter();
        System.out.println("Here is the file name: " + name);
        System.out.println("");
        
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        PerimeterAssignmentRunner a = new PerimeterAssignmentRunner();
        PerimeterAssignmentRunner b = new PerimeterAssignmentRunner();
        System.out.println("DO NOT ROUND UP!!!!!");
        a.testPerimeter ();
        //b.testPerimeterMultipleFiles();
        //pr.testFileWithLargestPerimeter();
    }
}
