package LeetCode;

import java.util.Stack;

//[-2147483647]

public class No53 {
    public int maxSubArray_0(int[] nums) {
        int startIndex = 0, endIndex = nums.length -1;
        while(nums[startIndex] < 0 && startIndex < endIndex) {
            startIndex ++;
        }
        while(nums[endIndex] < 0 && startIndex < endIndex) {
            endIndex --;
        }
        int max = Integer.MIN_VALUE;
        if (startIndex == endIndex){
            for (int num: nums) {
                if (num > max) max = num;
            }
        }
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num: nums) {
            if (num + sum > 0){
                stack.push(num);
            }
        }
        return 0;
    }

    public int maxSubArray_old(int[] nums) {
        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i=1;i<nums.length;++i){
            maxEndingHere= Math.max(maxEndingHere+nums[i],nums[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public int maxSubArray(int[] nums) {
        int globalMaxSum = Integer.MIN_VALUE, currentMaxSum = Integer.MIN_VALUE;
        for (int num: nums) {
            currentMaxSum = (currentMaxSum > 0) ? (currentMaxSum + num) : num;
            globalMaxSum = currentMaxSum > globalMaxSum ? currentMaxSum : globalMaxSum;
        }
        return globalMaxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483647};
        No53 solution = new No53();
        System.out.println(solution.maxSubArray(nums));
    }
}
