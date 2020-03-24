package up.edu.dimcalc;

import android.graphics.Point;

import org.junit.Test;

import static java.lang.Math.abs;
import static org.junit.Assert.*;

public class TwoPointsTest {

    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }


    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);
    }


    @Test
    public void randomValue() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0,p1.x,10);
        assertEquals(0,p1.y,10);
        assertEquals(0,p2.x,10);
        assertEquals( 0,p2.y,10);
    }

    @Test
    public void setOrigin() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setOrigin(0);
        testPoints.setOrigin(1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);

    }

    @Test
    public void copy() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.copy(0,1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, p2.x);
        assertEquals(p1.y, p2.y);
        testPoints.setPoint(1,4,5);
        assertEquals(4,p2.x);
        assertEquals(5,p2.y);
        assertEquals(0,p1.x);
        assertEquals(0,p1.y);
    }

    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        int xDiff = p1.x - p2.x;
        int yDiff = p1.y - p2.y;
        int result = (int)Math.sqrt(xDiff*xDiff + yDiff*yDiff);
        assertTrue("distance is correct",abs(result-testPoints.distance()) == 0);
    }

    @Test
    public void slope() {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        testPoints.setPoint(0,3,5);
        int xDiff = p1.x - p2.x;
        int yDiff = p1.y - p2.y;
        if(p1 == p2){
            assertEquals("slope is correct",testPoints.slope() == 0);
        }
        else if(xDiff != 0 && yDiff !=0){
            double result = yDiff / xDiff;
            assertEquals(result,testPoints.slope(),.01);
        }
    }
}