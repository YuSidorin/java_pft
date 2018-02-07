package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	public static void main (String[] args) {
		Point p1 = new Point(1, 1);
    	Point p2 = new Point(4, 1);
    	System.out.println("Расстоние между точками  p1(" + p1.x + "," + p1.y + ") и p2(" + p2.x + "," + p2.y + ") = " + p1.distance(p2));

	  	Square s = new Square(5);
    	System.out.println("Площадь квадрата со стороной "  + s.l + " = " + s.area());

	  	Rectangle r = new Rectangle(4, 5);
	  	System.out.println("Площадь квадрата со сторонами "  + r.a + " и " + r.b + " = " + r.area());

	}

}