package learning_java.blog;

public class ListOperation {
    // 直观地打印出链表
    public static void show(ListNode head) {
        if (head == null) {
            System.out.println("EMPTY LIST!");
            return;
        }
        ListNode currNode = head;
        while (currNode.next != null) {
            System.out.print(currNode.val);
            System.out.print("->");
            currNode = currNode.next;
        }
        System.out.print(currNode.val);
        System.out.println();
    }

    // 通过数组来构建链表
    public static ListNode constructList(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode preNode = dummy;
        for (int i = 0; i < nums.length; i ++) {
            ListNode currNode = new ListNode(nums[i]);
            preNode.next = currNode;
            preNode = preNode.next;
        }
        return dummy.next;
    }

    // 根据各种字符串输入，构建链表
    /*
    允许的字符串形式：
    "1->2->3->4->5->NULL"
    "1->2->3->4->5"
    "[1, 2, 3, 4 ,5]"
    "[1, 2, 3, 4 ,5, NULL]"
    注意：
    1）字符串前后可以有空格
    2）NULL为大写或小写均可
     */
    public static ListNode constructList(String listStr) {
        int[] nums;
        String[] numsStrArray;
        // 适配形如[1,2,3]的输入
        if (listStr.charAt(0) == '[' && listStr.charAt(listStr.length() - 1) == ']') {
            listStr = listStr.substring(1, listStr.length() - 1);
            numsStrArray = listStr.split(",");
        }
        // 适配形如1->2->3的输入
        else if (listStr.contains("->")) {
            numsStrArray = listStr.split("->");
        }
        // 如果有其他形式的输入，可以在这里进行扩展
        else {
            numsStrArray = new String[1];
        }

        // 判断最后一位是否为NULL，若是的话，则空过
        int numsLength = numsStrArray[numsStrArray.length - 1].toLowerCase().contains("null") ? numsStrArray.length - 1 : numsStrArray.length;
        // 构建一个包含所有数字的数组，然后调用被重载的（输入为一个int[]的）构建链表的函数。
        nums = new int[numsLength];
        for (int i = 0; i < numsLength; i++) {
            // 处理输入的字符串中每个数字前后的空格
            numsStrArray[i] = numsStrArray[i].replace(" ", "");
            nums[i] = Integer.valueOf(numsStrArray[i]);
        }
        return constructList(nums);
    }
}
