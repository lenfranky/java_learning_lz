package LeetCode;

import java.util.Stack;

public class No84 {
    // badcase; [2, 1, 2]
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        int res = 0;
        // 用来储存索引，而不是高度
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(0);
        for (int i = 1; i <= heights.length; i ++) {
            int currentHeight = i == heights.length? 0 : heights[i];
            if (indexStack.isEmpty() || currentHeight >= heights[indexStack.peek()]) {
                indexStack.push(i);
            }
            else {
                int lastIndex = indexStack.pop();
//                int currentArea = heights[lastIndex] * (i - lastIndex);
                res = Math.max(res, heights[lastIndex] * (indexStack.isEmpty() ? i : i - 1 - indexStack.peek()));
                i --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // 1,2,1,5,6,7,2,3,0
        // 1, 1, 1, 1, 1, 1
        // 2,1,5,6,2,3
        // 5, 4, 3, 2, 1
        System.out.println(new No84().largestRectangleArea(new int[] {5, 4, 3, 2, 1}));
    }
}
