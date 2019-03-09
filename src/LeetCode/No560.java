package LeetCode;

public class No560 {
    // {1} 1
    // Memory Limit Exceeded
    // {1, 2, 3}, 3
    public int subarraySumOld(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int[][] resArray = new int[nums.length][nums.length];
        int currentNum, currentRes, currentIndex = 0, currentLine = 0;
        int res = 0;
        resArray[0][0] = nums[0];
        if (nums[0] == k) res ++;
        currentLine ++;
        for (;currentLine < nums.length; currentLine ++) {
            currentNum = nums[currentLine];
            for (int i = 0; i < currentLine; i ++) {
                currentRes =  resArray[currentLine-1][i] + currentNum;
                resArray[currentLine][i] = currentRes;
                if (currentRes == k)
                    res ++;
            }
            currentRes =  nums[currentLine];
            resArray[currentLine][currentLine] = currentRes;
            if (currentRes == k)
                res ++;
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int[] lastArray = new int[nums.length], currentArray = new int[nums.length];
        int[] temp;
        int res = 0;
        int currentNum, currentRes;
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex ++) {
            currentNum = nums[currentIndex];
            if (currentNum == k) res ++;
            for (int lastIndex = 0; lastIndex < currentIndex; lastIndex ++) {
                currentRes = lastArray[lastIndex] + currentNum;
                currentArray[lastIndex] = currentRes;
                if (currentRes == k) res ++;
            }
            currentArray[currentIndex] = currentNum;
//            printArray(lastArray);
//            printArray(currentArray);
            temp = lastArray;
            lastArray = currentArray;
            currentArray = temp;
        }
        return res;
    }

    public void printArray(int[] nums) {
        for (int num: nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(new No560().subarraySum(new int[] {1, 2, 3}, 3));
    }
}
