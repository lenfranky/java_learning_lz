package learning_java;

public class VarArgsDemo {
    public static void printMax(double...numbers){
        if (numbers.length < 1){
            System.out.println("No argument passed!");
            return;
        }

        double result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > result)
                result = numbers[i];
        }
        System.out.println(result);
    }

    /*
    public static void printA(String...strings, double...numbers){

    }
    */

    public static void main(String[] args){
        double [] list1 = new double[5];
        for(int i = 0; i < 5; i++){
            list1[i] = i;
        }


        printMax(1, 2, 55, 3);
        printMax(new double[]{1,2,3,56});
    }
}
