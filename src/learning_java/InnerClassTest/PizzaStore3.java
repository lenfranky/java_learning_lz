package learning_java.InnerClassTest;

public class PizzaStore3 {
    private int materialsNum;
    private static int storeNum = 0;
    private static int allPizzaNum = 0;
    public void showMaterialsNum() {System.out.println("the num of materials:\t" + materialsNum);}
    public static void showStoreNum() {System.out.println("the num of store:\t" + storeNum);}
    public static void showAllPizzaNum() {System.out.println("the num of all the pizza:\t" + allPizzaNum);}
    public PizzaStore3(int materialsNum) {
        this.materialsNum = materialsNum;
        storeNum ++;
    }
    class cheesePizza implements Pizza{
        private String name = "cheesePizza";
        int size;
        cheesePizza(int inputSize){
            size = inputSize;
            materialsNum -= size;
            allPizzaNum ++;
        }
        public void getName() {System.out.println("Got a " + name + "\tof size:\t" + size);}
    }
    class sausagePizza implements Pizza{
        private String name = "sausagePizza";
        int size;
        sausagePizza(int inputSize){
            size = inputSize;
            materialsNum -= size;
            allPizzaNum ++;
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
        Pizza pizza;
        switch(pizzaName) {
            case "cheesePizza": pizza = new cheesePizza(5);break;
            case "sausagePizza": pizza = new sausagePizza(5);   break;
            default:    System.out.println("Don't have this kind of pizza"); return;
        }
        pizza.getName();
    }
    public static void main(String[] args) {
        PizzaStore3 store = new PizzaStore3(100);

        store.showMaterialsNum();
        PizzaStore3.showAllPizzaNum();

        PizzaStore3.cheesePizza pizza = store.getCheesePizza(6);
        pizza.getName();

        store.showMaterialsNum();
        PizzaStore3.showAllPizzaNum();
    }
}
