package LeetCode;

import static Tools.IOTools.print;

public class No238 {
    // 假设有两个数组，一个存储每个点左边所有点的乘积，一个存储每个点右边所有点的乘积
    // 之后将这两个数组的每个对应元素相乘即可得到结果
    // 再考虑这两个数组的构建方式是向右或者向左不断迭代，因此可以先将一个数组保存在res中
    // 另一个数组的话，用一个不断增长的数字来表示即可
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length == 0) return res;
        int currProduct = 1;
        res[0] = 1;
        // 一个数往左所有数字的乘积
        for (int i = 1; i < nums.length; i ++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i --) {
            currProduct *= nums[i + 1];
            res[i] = res[i] * currProduct;
        }
        return res;
    }

    public static void main(String[] args) {
        print(new No238().productExceptSelf(new int[] {1, 2, 3, 4}));
    }
}
