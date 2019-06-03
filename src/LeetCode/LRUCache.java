package LeetCode;

import java.util.HashMap;
import java.util.Map;

import static LeetCode.Tools.print;

public class LRUCache {
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
    Map<Integer, ListNode> map;
    private int capacity;
    private int length;
    public LRUCache(int capacity) {
        list = new LinkedList();
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.length = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        else {
            ListNode currNode = map.get(key);

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
    }

    public void put(int key, int value) {
        if (this.get(key) != -1) {
            list.head.val = value;
            return;
        }
        ListNode currNode = new ListNode(key, value);
        if (capacity > 1) {
            if (length == capacity) {
                map.remove(list.tail.key);
                list.tail = list.tail.prev;
                list.tail.next = null;
            }
            else {
                length ++;
            }
            map.put(key, currNode);
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
            if (length == 1) {
                map.remove(list.head.key);
            }
            map.put(key, currNode);
            list.head = currNode;
            list.tail = currNode;
            length = 1;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        print(cache.get(1));
//        cache.put(3, 3);
//        print(cache.get(2));
//        cache.put(4, 4);
//        print(cache.get(1));
//        print(cache.get(3));
//        print(cache.get(4));

//        print(cache.get(2));
//        cache.put(2, 6);
//        print(cache.get(1));
//        cache.put(1, 5);
//        cache.put(1, 2);
//        print(cache.get(1));
//        print(cache.get(2));

        cache.put(2, 1);
        print(cache.get(2));
    }
}
