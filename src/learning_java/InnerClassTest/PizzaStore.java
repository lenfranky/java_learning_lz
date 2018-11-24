package learning_java.InnerClassTest;

//public class PizzaStore {
//    public Pizza getCheesePizza() {
//        return new Pizza() {
//            private int size = 5;
//            public void getName() {System.out.println("Got a CheesePizza of size:\t" + size);}
//        };
//    }
//
//    public static void main(String[] args) {
//        PizzaStore store = new PizzaStore();
//        Pizza pizza = store.getCheesePizza();
//        pizza.getName();
//    }
//}

//public class PizzaStore {
//    private class CheesePizza implements Pizza {
//        private int size = 5;
//        public void getName() {System.out.println("Got a CheesePizza of size:\t" + size);}
//    }
//
//    public Pizza getCheesePizza() {
//        return new CheesePizza();
//    }
//
//    public static void main(String[] args) {
//        PizzaStore store = new PizzaStore();
//        Pizza pizza = store.getCheesePizza();
//        pizza.getName();
//    }
//}

//public class PizzaStore {
//    public VegetablePizza getVegetablePizza(int size) {
//        return new VegetablePizza(size) {
//            public void getName() {System.out.println("Inner: Got a VegetablePizza of size:\t" + size());}
//        };
//    }
//
//    public static void main(String[] args) {
//        PizzaStore store = new PizzaStore();
//        VegetablePizza pizza = store.getVegetablePizza(5);
//        pizza.getName();
//    }
//}

public class PizzaStore {
    public Pizza getPizza(final int sizeInput, final String nameInput) {
        return new Pizza() {
            private int size;
            private String name;
            {
                this.size = sizeInput;
                this.name = nameInput;
                System.out.println("Initialized a " + name + "!");
            }
            public void getName() {System.out.println("Inner: Got a " + name + " of size:\t"+ size);}
        };
    }

    public static void main(String[] args) {
        PizzaStore store = new PizzaStore();
        Pizza pizza = store.getPizza(5, "CheesePizza");
        pizza.getName();
    }
}