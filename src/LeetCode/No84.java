package LeetCode;

import java.util.LinkedList;

public class No84 {
    // badcase; [2, 1, 2]
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        int res = 0;
        // 用来储存索引，而不是高度
        LinkedList<Integer> indexStack = new LinkedList<>();
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

    public static int largestRectangleAreaFast(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // 1,2,1,5,6,7,2,3,0
        // 1, 1, 1, 1, 1, 1
        // 2,1,5,6,2,3
        // 5, 4, 3, 2, 1
        System.out.println(new No84().largestRectangleArea(new int[] {5, 4, 3, 2, 1}));
    }
}
