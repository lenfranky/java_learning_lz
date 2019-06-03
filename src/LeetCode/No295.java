package LeetCode;

import java.util.*;

import static Tools.IOTools.print;

public class No295 {
    class MedianFinder {

        /** initialize your data structure here. */
        private Queue<Integer> maxHeap;
        private Queue<Integer> minHeap;
        public MedianFinder() {
            minHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            maxHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
//            if (minHeap.size() == 0 && maxHeap.size() == 0) minHeap.offer(num);
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
        }

        public double findMedian() {
            print (minHeap);
            print (maxHeap);
            return minHeap.size() == maxHeap.size() ? ((double)(minHeap.peek() + maxHeap.peek())) / 2.0 : (double)maxHeap.peek();
        }
    }

//    class MedianFinder {
//
//        /**
//         * initialize your data structure here.
//         */
//        public MedianFinder() {
//
//        }
//
//        public void addNum(int num) {
//
//        }
//
//        public double findMedian() {
//
//        }
//    }

    public void test() {
//        MedianFinder solution = new No295().new MedianFinder();
        MedianFinder solution = new MedianFinder();
        solution.addNum(1);
        print(solution.findMedian());
        solution.addNum(2);
        print(solution.findMedian());
        solution.addNum(5);
        print(solution.findMedian());
    }

    public static void main(String[] args) {
        new No295().test();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
    }
}
