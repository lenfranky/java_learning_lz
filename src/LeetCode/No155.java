package LeetCode;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static Tools.IOTools.print;

public class No155 {
    /*
    pop函数中，需要注意，如果一个数不是最小数，则这个数甚至并不在minStack中，因为，这个数在最后面，若它是最小值，则入栈，若不是最小值，并不会入栈
    因此，在总的栈pop时，只需检查其是否是最小栈的栈顶即可
    若是，则最小栈出栈，若不是，则不用处理
     */
    class MinStack {
        private LinkedList<Integer> stack;
        private LinkedList<Integer> minStack;
        private int size;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            size = 0;
        }

        public void push(int x) {
            stack.push(x);
            size ++;
            if (minStack.isEmpty() || minStack.peek() >= x)
                minStack.push(x);
        }

        public void pop() {
            int value = stack.pop();
            if (!minStack.isEmpty() && minStack.peek() == value)
                minStack.pop();
        }

        public int top() {
            if (stack.isEmpty()) return -1;
            return stack.peek();
        }

        public int getMin() {
            if (minStack.isEmpty()) return -1;
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        No155 solution = new No155();
        No155.MinStack obj = solution.new MinStack();
        obj.push(0);
        obj.push(1);
        obj.push(1);
        print(obj.getMin());
        obj.pop();
        print(obj.getMin());


    }
}
