package learning_java;

public class StaticValueTry {
    public static void main(String[] args){
        System.out.println("the init value is :\t" + StaticValueClass.numberOfObjects);
        learning_java.StaticValueIntermediate intermediate = new learning_java.StaticValueIntermediate();
        System.out.println("the intermediate class is created!\tnow the value is :\t" + learning_java.StaticValueClass.numberOfObjects);

    }
}

