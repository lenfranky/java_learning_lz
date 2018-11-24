package learning_java.InnerClassTest;

public class PizzaStore1 {
    class cheesePizza {
        private String name = "cheesePizza";
        public void getName() {System.out.println("Got a " + name);}
    }
    class sausagePizza {
        private String name = "sausagePizza";
        public void getName() {System.out.println("Got a " +name);}
    }
    // 只有在该外部类的非静态方法中，才可以这样直接创建内部类的对象
    public void orderPizza(String pizzaName) {
        if (pizzaName == "cheesePizza") {
            cheesePizza pizza = new cheesePizza();
            pizza.getName();
        }
        else if (pizzaName == "sausagePizza"){
            sausagePizza pizza = new sausagePizza();
            pizza.getName();
        }
        else
            System.out.println("Don't have this kind of pizza");
    }
    public static void main(String[] args) {
        PizzaStore1 store = new PizzaStore1();
        store.orderPizza("cheesePizza");

    }
}
