package learning_java.InnerClassTest;

public class PizzaStore2 {
    class cheesePizza {
        private String name = "cheesePizza";
        int size;
        cheesePizza(int inputSize){
            size = inputSize;
        }
        public void getName() {System.out.println("Got a " + name + "\tof size:\t" + size);}
    }
    class sausagePizza {
        private String name = "sausagePizza";
        int size;
        sausagePizza(int inputSize){
            size = inputSize;
        }
        public void getName() {System.out.println("Got a " + name + "\tof size:\t" + size);}
    }

    public sausagePizza getSausagePizza(int size){
        return new sausagePizza(size);
    }
    public cheesePizza getCheesePizza(int size){
        return new cheesePizza(size);
    }
    public void orderPizza(String pizzaName) {
        if (pizzaName == "cheesePizza") {
            cheesePizza pizza = new cheesePizza(5);
            pizza.getName();
        }
        else if (pizzaName == "sausagePizza"){
            sausagePizza pizza = new sausagePizza(5);
            pizza.getName();
        }
        else
            System.out.println("Don't have this kind of pizza");
    }
    // 如果想从外部类的非静态方法之外的任意位置创建某个内部类的对象，那么必须像在main()方法中这样，具体地知名这个对象的类型：OuterClassName.InnerClassName
    public static void main(String[] args) {
        PizzaStore2 store = new PizzaStore2();
        store.orderPizza("cheesePizza");

        PizzaStore2 store2 = new PizzaStore2();
        PizzaStore2.cheesePizza pizza = store2.getCheesePizza(6);
        pizza.getName();
    }
}
