package LeetCode;

import static Tools.IOTools.print;

public class No287 {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) return -1;
        int fast = nums[0];
        int slow = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        print(fast);
        fast = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

    public static void main(String[] args) {
        print(new No287().findDuplicate(new int[] {3,1,3,4,2}));
    }
}
