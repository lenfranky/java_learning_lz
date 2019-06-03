package learning_java.GrammarTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveTest {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        Collections.addAll(numList, 1, 2, 4, 8, 16, 32, 64, 4);
        System.out.println(numList);
//        numList.remove(4);
        // 先将数字转换成对象再进行处理，但是，只能删除第一个对应的对象，不能删除之后的对象
        System.out.println(numList.remove(new Integer(4)));
        System.out.println(numList);
    }
}
