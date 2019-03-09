package learning_java.GrammarTest;

public class StaticValueIntermediate {
    public StaticValueIntermediate(){
        System.out.println("the intermediate class is created!\tnow the value is :\t" + StaticValueClass.numberOfObjects);
        StaticValueClass.numberOfObjects += 1;
        System.out.println("after operation\nthe intermediate class is created!\tnow the value is :\t" + StaticValueClass.numberOfObjects);
    }
}
