package learning_java.sortTry;

//import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        circleSortTest2();
    }

    public static void primitiveDataTypeSort() {
        // 基本数据类型可以直接排序
        int[] ints = {3, 1, 5, 2, 4};
        java.util.Arrays.sort(ints);
        for(int number: ints)
            System.out.print(number + " ");
        System.out.println();

        // 包装器类型（即对象形式）也可以直接进行排序
        Character[] characters = {  new Character('a'), new Character('c'),
                                    new Character('d'), new Character('b'),};
        java.util.Arrays.sort(characters);
        for (Character character: characters) {
            System.out.print(character + "  ");
        }
    }

    public static void circleSortTest() {
        // 未实现Comparable接口的类的对象不可直接进行排序
        Circle[] circles = {new Circle(3), new Circle(1), new Circle(2)};
        java.util.Arrays.sort(circles);
    }

    public static void circleSortTest2() {
        Circle circleOne = new Circle(3);
        Circle circleTwo = new Circle(5);
        CircleComparator comparator = new CircleComparator();
        System.out.println(comparator.compare(circleOne, circleTwo)); //的一个圆比第二个圆的面积小，则会返回-1

        Circle[] circles = {new Circle(3), new Circle(1), new Circle(2)};
        // java.util.Arrays.sort(circles, comparator);
        java.util.Arrays.sort(circles, new CircleComparator());
        for (Circle circle: circles) {
            System.out.print(circle.getArea() + "  ");
        }
    }

    public static void circleComparableSortTest() {
        // 实现了Comparable接口的类的对象之间可以比较大小
        CircleComparable circleOne = new CircleComparable(3);
        CircleComparable circleTwo = new CircleComparable(5);
        System.out.println(circleOne.compareTo(circleTwo)); //的一个圆比第二个圆的面积小，则会返回-1

        // 实现了Comparable接口的类的对象可以用sort直接进行排序
        CircleComparable[] circles = {new CircleComparable(3), new CircleComparable(1), new CircleComparable(2)};
        java.util.Arrays.sort(circles);
        for (CircleComparable cirlce: circles) {
            System.out.print(cirlce.getArea() + "  ");
        }
    }
}
