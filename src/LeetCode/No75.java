package LeetCode;

public class No75 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num: nums)
            count[num] ++;
        int i, j, k;
        for (i = 0; i < count[0]; i ++)
            nums[i] = 0;
        for (; i < count[0] + count[1]; i ++)
            nums[i] = 1;
        for (; i < count[0] + count[1] + count[2]; i ++)
            nums[i] = 2;
    }

    public static void main(String[] args) {
        int[] res = {2,0,2,1,1,0};
        new No75().sortColors(res);
        for (int num: res)
            System.out.println(num);
    }
}
