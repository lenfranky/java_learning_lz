package learning_java.GrammarTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static Tools.IOTools.*;

public class ArraysAsListTest {
    // asList的参数必须是一个对象的数组，不能是一个基本类型的数组
    public static void main(String[] args) {
        Integer[] numArray = {1, 2};
        List<Integer> arrayAsList = Arrays.asList(numArray);
        print(arrayAsList.size());
        print(arrayAsList.get(0).getClass().getName());
        List<Integer> numList = new ArrayList(Arrays.asList(numArray));
        System.out.println(numList);
        print(numList.get(0).getClass().getName());
    }
}
