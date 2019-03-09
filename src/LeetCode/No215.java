package LeetCode;

import java.util.PriorityQueue;

public class No215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return 0;
        PriorityQueue<Integer> list = new PriorityQueue<>();
//        list.addAll(Arrays.asList(nums));
        for (int num: nums) {
            list.offer(num);
            if (list.size() > k)
                list.poll();
        }
        return list.peek();
    }

    public static void main(String[] args) {
        System.out.println(new No215().findKthLargest(new int[] {
                        3,2,1,5,6,4
        },
                2));
    }
}
