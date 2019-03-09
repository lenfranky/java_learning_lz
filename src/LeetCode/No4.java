package LeetCode;

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

public class No4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 == 1 && length2 == 0) {
            return nums1[0];
        }
        if (length1 == 0 && length2 == 1) {
            return nums2[0];
        }
        if (length1 == 1 && length2 == 1) {
            double result = (double) (nums1[0] + nums2[0]);
            result /= 2;
            return result;
        }

        int[] nums = new int[length1 + length2];
        int i = 0, j = 0, k = 0;

        while(i < length1 && j < length2) {
            if (nums1[i] <= nums2[j]) {
                nums[k] = nums1[i];
                i ++;
            }
            else {
                nums[k] = nums2[j];
                j ++;
            }
            k ++;
        }

        while(i < length1) {
            nums[k] = nums1[i];
            i ++;
            k ++;
        }

        while(j < length2) {
            nums[k] = nums2[j];
            j ++;
            k ++;
        }

        double res;

        if (nums.length % 2 == 0)
            res = (nums[(nums.length / 2) - 1] + nums[nums.length / 2]) / 2.0;
        else
            res = nums[nums.length / 2];
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(new No4().findMedianSortedArrays(nums1, nums2));
    }

}
