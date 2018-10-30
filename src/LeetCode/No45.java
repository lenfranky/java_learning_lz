package LeetCode;

// 在循环里改变循环条件是会导致循环的变化的，会带来不稳定性
//[1, 2]
//[0]

public class No45 {
    public int jump(int[] nums) {
        if (nums.length == 1 || nums.length == 0) return 0;
        if (nums[0] >= nums.length - 1) return 1;
        int currentMaxLength = 1, currentIndex = -1, step = 0, globalMaxLength = 0;

        while(globalMaxLength < nums.length - 1) {
            currentMaxLength = globalMaxLength;
            for (int i = currentIndex + 1; i <= globalMaxLength; i ++) {
                if (nums[i] + i > currentMaxLength){
                    currentMaxLength = nums[i] + i;
                    currentIndex = i;
                }
            }
            globalMaxLength  = currentMaxLength;
            step ++;
        }
        return step;
    }

    public static void main(String[] args) {
        No45 solution = new No45();
        int[] nums = {2,3,1,1,4};
        System.out.println(solution.jump(new int[] {1 ,2, 3}));
    }
}
