package ru.stqa.krug.sandbox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest2 {

    @Test

    public void testArea () {
        Point p1 = new Point(0,1);
        Point p2 = new Point (0,120);
        Assert.assertEquals( p1.distance(p2),119.0);
    }


}