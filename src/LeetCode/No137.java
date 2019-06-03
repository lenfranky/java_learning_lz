package LeetCode;

public class No137 {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) return 0;
        int[] numPerBit = new int[32];
        for (int num: nums) {
            for (int i = 0; i < 32; i ++) {
                numPerBit[i] += num & 1;
                num = num >> 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i --) {
            res = res << 1;
            res += numPerBit[i] % 3;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No137().singleNumber(new int[] {0,1,0,1,0,1,99}));
    }
}
