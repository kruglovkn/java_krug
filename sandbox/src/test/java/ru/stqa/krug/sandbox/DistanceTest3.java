package ru.stqa.krug.sandbox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest3 {

    @Test

public void testArea () {
    Point p1 = new Point(0,0);
    Point p2 = new Point (0,0);
    Assert.assertEquals( p1.distance(p2),0.0);
}
}
