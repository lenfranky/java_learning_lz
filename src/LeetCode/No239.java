package LeetCode;

import java.util.LinkedList;

import static Tools.IOTools.print;

public class No239 {
    /*
    要求：
    1） 需要快速得到每个窗口的最大值 -> 递减双向链表的最左端即是最大值
    2） 在移向下一个窗口的时候，不能丢失上一个窗口中的（除最左端需要删掉的节点之外的）最大值
        -> 链表中最左端是最大值，且可以保证其左边没有更大的值，其右端，每个波峰都被记录了下来，
           每个点与上一个点之间没有比这两个点更高的点
     */
    /*
    规则：
    在链表中记录索引，只记录递减的元素的索引，如果一个元素比链表中上一个元素更大，则删掉链表中的上一个元素，因为现在的元素既比它大，又比它靠后，因此不再需要记录上一个元素
    不断迭代以上的步骤，直到链表为空，或链表中的上一个元素比现在的元素大为止
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[] {};
        int[] res = new int[n - k + 1];
        LinkedList<Integer> indexStack = new LinkedList<>();
        int currIndex = 0;
        while (currIndex < k - 1) {
            if (indexStack.isEmpty() || nums[indexStack.peek()] >= nums[currIndex]) {
                indexStack.addFirst(currIndex);
                currIndex ++;
            }
            else
                indexStack.removeFirst();
        }
        while (currIndex < n) {
            if (indexStack.isEmpty()) {
                indexStack.addFirst(currIndex);
                res[currIndex - k + 1] = nums[currIndex];
                currIndex ++;
            }
            else if (nums[indexStack.getFirst()] >= nums[currIndex]) {
                indexStack.addFirst(currIndex);
                if (indexStack.getLast() < currIndex - k + 1)
                    indexStack.removeLast();
                res[currIndex - k + 1] = nums[indexStack.getLast()];
                currIndex ++;
            }
            else
                indexStack.removeFirst();
        }
        return res;
    }

    public static void main(String[] arsg) {
        print(new No239().maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3));
    }
}
