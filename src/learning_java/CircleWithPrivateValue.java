package learning_java;

public class CircleWithPrivateValue {
    private double radius = 10;

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public static void main(String[] args){
        CircleWithPrivateValue myCircle = new CircleWithPrivateValue();
        System.out.println("Radius is " + myCircle.radius);
    }
}
