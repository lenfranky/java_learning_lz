package learning_java.InnerClassTest;

public class PizzaStore5 {
    public class CheesePizza{}
    public static void main(String[] args) {
        PizzaStore5 store = new PizzaStore5();
        // 通过.new来创建内部类的对象
        PizzaStore5.CheesePizza pizza = store.new CheesePizza();
    }
}
