package ru.stqa.krug.sandbox;

public class MyFirstProgram {
	
  public static void main (String[] args) {

      hello("World");
      hello("user");
      hello("Konstantin");
      hello("Aleksey");

      Square s = new Square(5);
      System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area() );

      Rectangle r = new Rectangle(4,6);
      System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

      Point p1 = new Point(-14,0);
      Point p2 = new Point(6,0);

      System.out.println("Расстояние между двямя точками P1 и P2 = " + p1.distance(p2));
 }

 public static void hello (String somebody) {
     System.out.println("Hello " + somebody + "!");
 }


}