package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> a = ListNodeToList(l1);
        List<Integer> b = ListNodeToList(l2);
        List<Integer> res = new ArrayList<>(Math.max(a.size(), b.size()));
        int add = 0, temp;
        for (int i = 0; i < Math.max(a.size(), b.size()); i ++) {
            temp = 0;
            temp += (i < a.size() ? a.get(i) : 0);
            temp += (i < b.size() ? b.get(i) : 0);
            add = temp % 10;
//            res.add
        }
        return null;
    }

    private List<Integer> ListNodeToList(ListNode head) {
        LinkedList<Integer> nums = new LinkedList<>();
        while (head != null) {
            nums.addLast(head.val);
            head = head.next;
        }
        return nums;
    }

    private long listToNum(ListNode head) {
        long res = 0;
        while (head != null) {
            res = res * 10 + head.val;
            head = head.next;
        }
        return res;
    }

    private ListNode numToList(long num) {
        if (num == 0) return new ListNode(0);
        int i = 0;
        long temp = num;
        while (temp > 0) {
            temp /= 10;
            i ++;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur, pre = dummy;
        while (i > 0) {
            temp = (num / (int)Math.pow(10, i - 1)) % 10;
            cur = new ListNode((int)temp);
            pre.next = cur;
            pre = cur;
            i --;
        }
        return dummy.next;
    }

    /*
    [3,9,9,9,9,9,9,9,9,9]
    [7]

    [9,9,9,9,9,9,9,9,9,9]
    [9,9,9,9,9,9,9,9,9,9]
     */
    public static void main(String[] args) {
        ListNode a = ListOperation.constructList("7 -> 2 -> 4 -> 3");
        ListNode b = ListOperation.constructList("5 -> 6 -> 4");
        ListNode res = new No445().addTwoNumbers(a, b);
        ListOperation.show(res);
    }
}
