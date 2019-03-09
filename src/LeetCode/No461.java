package LeetCode;

public class No461 {
    // 先求出两个数字的异或值，再求出异或值中的1的个数
    // 1的个数的求法：用数字与1做与运算，即可判断最右端的数是否为1，然后将数字右移1位，不断重复
    // 注意，对于正数，右移的效果与除以2相同，但是效率要更高，因此尽量选择右移
    public int hammingDistance(int x, int y) {
        int xorValue = x ^ y;

        int res = 0;

        while (xorValue > 0) {
            res += xorValue & 1;
            xorValue = xorValue >> 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No461().hammingDistance(1, 4));
    }
}
