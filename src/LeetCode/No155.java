package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No155 {
    private int size;
    private List<Integer> elements;
    public No155() {
        size = 0;
        elements = new ArrayList<>();
    }

    public void push(int x) {
        elements.add(x);
    }

    public void pop() {
//        int res = elements.get(size - 1);
        elements.remove(size - 1);
    }

    public int top() {
        return elements.get(size - 1);
    }

    public int getMin() {
        return 0;
    }
}
