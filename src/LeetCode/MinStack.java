package LeetCode;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Stack;

import static LeetCode.Tools.print;

public class MinStack {

    LinkedList<Integer> dataStack;
    LinkedList<Integer> minValStack;
    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new LinkedList<>();
        minValStack = new LinkedList<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minValStack.isEmpty() || x <= minValStack.peek())
            minValStack.push(x);
    }

    public void pop() {
        int currVal = dataStack.pop();
        if (minValStack.peek() == currVal)
            minValStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minValStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
//        minStack.push(2);
        print(minStack.getMin());
        minStack.pop();
        print(minStack.getMin());
//        minStack.pop();
//        print(minStack.getMin());
//        minStack.pop();
//        print(minStack.getMin());

    }
}
