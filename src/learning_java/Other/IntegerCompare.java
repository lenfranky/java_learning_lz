package learning_java.Other;

public class IntegerCompare {
    public static void main(String[] args) {
        Integer numOne = new Integer(12);
        Integer numTwo = new Integer(12);

        System.out.println(numOne == numTwo);

        int num = 12;
        Integer numThree = (Integer) num;
        Integer numFour = (Integer) num;

        System.out.println(numThree == numFour);
//        System.out.println(numThree == numOne);

        num = 1200;
        Integer numFive = (Integer) num;
        Integer numSix = (Integer) num;

        System.out.println(numFive == numSix);
    }
}
