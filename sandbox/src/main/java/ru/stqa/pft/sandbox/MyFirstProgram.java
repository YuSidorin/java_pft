package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	public static void main (String[] args) {

	  Point p1 = new Point();
    p1.x1 = 2;
    p1.y1 = 1;
    Point p2 = new Point();
    p2.x2 = 3;
    p2.y2 = 5;
    System.out.println("Расстоние между точками  p1(" + p1.x1 + "," + p1.y1 + ") и p2(" + p2.x2 + "," + p2.y2 + ") = " + distance(p1, p2));

	  Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной "  + s.l + " = " + s.area());

	  Rectangle r = new Rectangle(4, 5);
	 System.out.println("Площадь квадрата со сторонами "  + r.a + " и " + r.b + " = " + r.area());

	}
  public static double distance(Point p1, Point p2){
    return Math.sqrt((p2.x2 - p1.x1)*(p2.x2 - p1.x1)+(p2.y2 - p1.y1)*(p2.y2 - p1.y1));
}}