package LeetCode;

public class No55 {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int currentMaxJump = 1;
        for (int i = 0; i < nums.length - 1; i ++) {
            currentMaxJump --;
            if (nums[i] > currentMaxJump)
                currentMaxJump = nums[i];
            if (currentMaxJump == 0)
                return false;
        }
        return true;
    }

//    public int maxJump(int current)

    public static void main(String[] args) {
        No55 solution = new No55();
        int[] nums = {2, 0, 0};
        System.out.println(solution.canJump(nums));
    }
}
