package LeetCode;

import java.util.Arrays;

import static Tools.IOTools.print;

public class No31 {
    /*
    1）先找到最后一个正序排列的数对（a, b）
    2）再找到最后一个比a大的数c
    3）交换a、c
    4）将交换后的c的位置之后的数，反序排列，即可得到结果
     */
    public void nextPermutation(int[] nums) {
        if(nums.length < 2) return;
        int a_index = nums.length - 2;
        while(a_index >= 0) {
            if(nums[a_index + 1] > nums[a_index])
                break;
            a_index --;
        }
        // 如果a_index为-1，说明输入的是初始状态
        if(a_index == -1)
            reverseArray(nums, 0, nums.length);
        else {
            int c_index = nums.length - 1;
            while (c_index > a_index) {
                if (nums[c_index] > nums[a_index])
                    break;
                c_index --;
            }
            int temp = nums[a_index];
            nums[a_index] = nums[c_index];
            nums[c_index] = temp;
            reverseArray(nums, a_index + 1, nums.length);
        }
    }

    public void reverseArray(int[] nums, int start_index, int end_index) {
        // 下标从0开始，起始点与终止点的索引为左闭右开
        int temp;
        for(int i = start_index; i < (end_index + start_index) / 2; i ++) {
            temp = nums[i];
            nums[i] = nums[end_index - i + start_index - 1];
            nums[end_index - i + start_index - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        No31 solution = new No31();
        System.out.println(Arrays.toString(nums));
        solution.nextPermutation(nums);
//        solution.reverseArray(nums, 2, 5);
        print(nums);
    }
}
