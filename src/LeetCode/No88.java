package LeetCode;

import static Tools.IOTools.print;

public class No88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 倒着往里面加元素（可以保证不改变每个数组的前面的元素）
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m --;
            }
            else {
                nums1[m + n - 1] = nums2[n - 1];
                n --;
            }
        }
        while (n > 0) {
            nums1[n - 1] = nums2[n - 1];
            n --;
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2, 5, 6};
        new No88().merge(num1, 3, num2, 3);
        print(num1);
    }
}
