package LeetCode;

public class No283 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        int zero_count = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (zero_count > 0)
                nums[i - zero_count] = nums[i];
            if (nums[i] == 0)
                zero_count += 1;
        }
        for (int i = 1; i <= zero_count; i ++) {
            nums[nums.length - i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] ns = {0,1,0,3,12};
        new No283().moveZeroes(ns);
        for (int num: ns)
            System.out.print(num + ", ");
    }
}
