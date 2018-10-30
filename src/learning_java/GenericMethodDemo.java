package learning_java;

public class GenericMethodDemo {
    public static void main(String [] args) {
        Integer[] integersList = {1, 2, 3, 4, 5};
        String[] stringsList = {"London", "Paris", "New York", "Austin"};

        GenericMethodDemo.<Integer>print(integersList);
        GenericMethodDemo.<String>print(stringsList);

        int[] intList = {1, 2, 3, 4, 5};
        // GenericMethodDemo.<Integer>print(intList);

        int a = 1;
        singlePrint(a);
        Integer b = new Integer(2);
        singlePrint(b);

        // 单个的元素可以自动装包，但是数组形式的不会把整个数组里的每个元素自动装包
    }

    public static <E> void print(E[] list) {
        for (int iterNum = 0; iterNum < list.length; iterNum++) {
            System.out.print(list[iterNum] + " ");
        }
        System.out.println();
    }

    public static <E> void singlePrint(E element) {
        System.out.println(element);
    }
}
