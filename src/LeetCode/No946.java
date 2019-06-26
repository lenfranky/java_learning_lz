package LeetCode;

import java.util.LinkedList;

import static Tools.IOTools.print;

public class No946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length)
            return false;
        if (pushed.length == 0) return true;
        int pushedIndex = 0;
        int poppedIndex = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        while (pushedIndex < pushed.length) {
            stack.push(pushed[pushedIndex ++]);
            while (!stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex ++;
            }
        }
        return poppedIndex == popped.length;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};
        print(new No946().validateStackSequences(pushed, popped));
    }
}
