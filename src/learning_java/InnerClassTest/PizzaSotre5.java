package learning_java.InnerClassTest;

public class PizzaSotre5 {
    public class CheesePizza{}
    public static void main(String[] args) {
        PizzaSotre5 store = new PizzaSotre5();
        // 通过.new来创建内部类的对象
        PizzaSotre5.CheesePizza pizza = store.new CheesePizza();
    }
}
