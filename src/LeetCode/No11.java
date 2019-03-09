package LeetCode;

import static Tools.IOTools.print;

public class No11 {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int res = 0;
        int leftIndex = 0, rightIndex = height.length - 1;
        while(leftIndex < rightIndex) {
            if (height[leftIndex] < height[rightIndex]) {
                res = Math.max(res, height[leftIndex] * (rightIndex - leftIndex));
                leftIndex ++;
            }
            else {
                res = Math.max(res, height[rightIndex] * (rightIndex - leftIndex));
                rightIndex --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        print(new No11().maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
