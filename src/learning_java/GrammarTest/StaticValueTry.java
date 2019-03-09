package learning_java.GrammarTest;

public class StaticValueTry {
    public static void main(String[] args){
        System.out.println("the init value is :\t" + StaticValueClass.numberOfObjects);
        StaticValueIntermediate intermediate = new StaticValueIntermediate();
        System.out.println("the intermediate class is created!\tnow the value is :\t" + StaticValueClass.numberOfObjects);

    }
}

