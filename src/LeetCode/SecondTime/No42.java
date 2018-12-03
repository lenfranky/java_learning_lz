package LeetCode.SecondTime;

import java.util.Stack;

public class No42 {
    public int trapWithStack(int[] height) {
        if (height.length == 0) return 0;
        int res = 0;
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < height.length; i ++) {
            if (indexStack.isEmpty() || height[i] <= height[indexStack.peek()])
                indexStack.push(i);
            else {
                int lastIndex = indexStack.pop();
                if (!indexStack.isEmpty())
                    res += (Math.min(height[indexStack.peek()], height[i]) - height[lastIndex]) * (i - indexStack.peek() - 1);
                i --;
            }
        }
        return res;
    }

//    public int trap(int[] height) {
//        if (height.length == 0) return 0;
//        int res = 0;
//        int[] indexStack = new int[height.length];
//        for (int i = 0; i < height.length; i ++) {
//            if (indexStack.isEmpty() || height[i] <= height[indexStack.peek()])
//                indexStack.push(i);
//            else {
//                int lastIndex = indexStack.pop();
//                if (!indexStack.isEmpty())
//                    res += (Math.min(height[indexStack.peek()], height[i]) - height[lastIndex]) * (i - indexStack.peek() - 1);
//                i --;
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(new No42().trapWithStack(new int[] {5, 5}));
    }
}
