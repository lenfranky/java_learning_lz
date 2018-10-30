package learning_java.sortTry;

public class Circle {
    private double radius;

    public Circle() {
         this.radius = 0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getArea());
    }
}
