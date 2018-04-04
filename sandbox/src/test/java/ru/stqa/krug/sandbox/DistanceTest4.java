package ru.stqa.krug.sandbox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest4 {

    @Test

    public void testArea () {
        Point p1 = new Point(-1,-1);
        Point p2 = new Point (2,3);
        Assert.assertEquals( p1.distance(p2),5.0);
    }
}
