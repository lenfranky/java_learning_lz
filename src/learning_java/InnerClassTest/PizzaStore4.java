package learning_java.InnerClassTest;

public class PizzaStore4 {
    void getStoreName() {System.out.println("PizzaStore4!");}
    public class CheesePizza {
        public PizzaStore4 getStore() {
            // 在这里通过.this来引用其外围类
            return PizzaStore4.this;
        }
    }
    public CheesePizza cheesePizza() {return new CheesePizza();}

    public static void main(String[] args) {
        PizzaStore4 store = new PizzaStore4();
        PizzaStore4.CheesePizza pizza = store.cheesePizza();
        pizza.getStore().getStoreName();
    }
}
