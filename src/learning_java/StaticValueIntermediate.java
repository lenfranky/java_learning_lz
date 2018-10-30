package learning_java;

public class StaticValueIntermediate {
    public StaticValueIntermediate(){
        System.out.println("the intermediate class is created!\tnow the value is :\t" + learning_java.StaticValueClass.numberOfObjects);
        learning_java.StaticValueClass.numberOfObjects += 1;
        System.out.println("after operation\nthe intermediate class is created!\tnow the value is :\t" + learning_java.StaticValueClass.numberOfObjects);
    }
}
