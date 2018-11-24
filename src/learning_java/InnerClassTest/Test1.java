package learning_java.InnerClassTest;

public class Test1 {
    public static void main(String[] args) {
        PizzaStore6 store = new PizzaStore6();
        Pizza pizza = store.getCheesePizza(5);
        pizza.getName();
        // getSize()方法并没有在接口Pizza中声明，因此在这里并不能调用该方法
//        pizza.getSize();
    }
}
