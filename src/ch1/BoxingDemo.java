package ch1;

import java.util.Collection;

/** 测试泛型以及协变性 */
public class BoxingDemo {
  public static void main(String[] args) {
    totalArea(new Circle[] {new Circle()});
  }

  public static double totalArea(Shape[] arr) {
    double total = 0;
    for (Shape s : arr) {
      total += s.area();
    }
    return total;
  }

  public static double totalArea(Collection<Shape> arr) {
    double total = 0;
    for (Shape s : arr) {
      total += s.area();
    }
    return total;
  }
}
