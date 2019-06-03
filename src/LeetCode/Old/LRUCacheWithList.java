package LeetCode.Old;
import static LeetCode.Tools.*;

public class LRUCacheWithList {
    private class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private class LinkedList {
        ListNode head;
        ListNode tail;
        LinkedList(ListNode head) {
            this.head = head;
            this.tail = head;
        }
        LinkedList() {
        }
    }

    private LinkedList list;
    private int capacity;
    private int length;
    public LRUCacheWithList(int capacity) {
         list = new LinkedList();
         this.capacity = capacity;
         this.length = 0;
    }

    public int get(int key) {
        ListNode currNode = list.head;
        if (length == 0) return -1;
        while (currNode.key != key) {
            currNode = currNode.next;
            if (currNode == null) return -1;
        }
        if (currNode != list.head) {
            if (currNode.prev != null) currNode.prev.next = currNode.next;
            if (currNode.next != null) currNode.next.prev = currNode.prev;
            else if (capacity > 1) list.tail = currNode.prev;
            currNode.prev = null;
            currNode.next = list.head;
            list.head.prev = currNode;
            list.head = currNode;
        }
        return currNode.val;
    }

    public void put(int key, int value) {
        ListNode currNode = new ListNode(key, value);
        if (this.get(key) != -1) {
            list.head.val = value;
            return;
        }
        if (capacity > 1) {
            if (length == capacity) {
                list.tail = list.tail.prev;
                list.tail.next = null;
            }
            else {
                length ++;
            }
            if (list.head != null) {
                list.head.prev = currNode;
                currNode.next = list.head;
            }
            else {
                list.tail = currNode;
            }
            list.head = currNode;
        }
        else {
            list.head = currNode;
            list.tail = currNode;
            length = 1;
        }
    }

    public static void main(String[] args) {
        LRUCacheWithList cache = new LRUCacheWithList(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        print(cache.get(1));
//        cache.put(3, 3);
//        print(cache.get(2));
//        cache.put(4, 4);
//        print(cache.get(1));
//        print(cache.get(3));
//        print(cache.get(4));
        print(cache.get(2));
        cache.put(2, 6);
        print(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        print(cache.get(1));
        print(cache.get(2));
    }
}
