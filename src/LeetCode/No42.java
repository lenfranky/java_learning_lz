package LeetCode;

import java.util.Stack;

// 20ms-30ms
public class No42 {
    public int trap(int[] height) {
        int res = 0;
        int currentBottom = 0, diffHeight = 0, currentWater = 0;
        Stack<Integer> indexStack = new Stack<>();
        int i = 0;
        while(i < height.length) {
            if (indexStack.isEmpty() || height[i] < height[indexStack.peek()]) {
                indexStack.push(i);
                i ++;
            }
            else {
                currentBottom = indexStack.pop();
                if (indexStack.isEmpty())
                    currentWater = 0;
                else
                    currentWater = (Math.min(height[i], height[indexStack.peek()]) - height[currentBottom]) * (i - indexStack.peek() - 1);

                res += currentWater;
            }
        }
        return res;
    }

    // 12ms
    public int trap_2(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];
        for(int i=1; i<height.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        for(int i=height.length-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        int trappedWater = 0;
        for(int i=0; i<height.length; i++){
            trappedWater+=Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        No42 solution = new No42();
        int[] heights = {5,3,2,1,0,1,4};
        System.out.println(solution.trap(heights));
    }
}
