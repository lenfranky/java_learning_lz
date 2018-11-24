package learning_java.InnerClassTest;

public class PizzaStore6 {
    private class CheesePizza implements Pizza {
        private int size;
        private CheesePizza(int size) {this.size = size;}
        public void getName() {System.out.println("Got a CheesePizza of size:\t" + size);}
        public int getSize() {return size;}
    }

    private class SausagePizza{
        private int size;
        private SausagePizza(int size) {this.size = size;}
        public void getName() {System.out.println("Got a SausagePizza of size:\t" + size);}
        public int getSize() {return size;}
    }

    public Pizza getCheesePizza(int size) {
        return new CheesePizza(size);
    }

    public SausagePizza getSausagePizza(int size) {
        return new SausagePizza(size);
    }
}
