package ru.stqa.pft.sandbox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void resultAssert(){
    Point p1 = new Point(1, 1);
    Point p2 = new Point(4, 1);
    Assert.assertEquals(p1.distance(p2), 3.0);
  }

  @Test
  public void isResultPositive(){
    Point p1 = new Point(1, 1);
    Point p2 = new Point(-4, -10);
    Assert.assertTrue(p1.distance(p2) < 0);
  }

  @Test
  public void isNotNull(){
    Point p1 = new Point(0,0);
    Point p2 = new Point(0,0);
    Assert.assertNotNull(p1.distance(p2));
  }
}
