package learning_java.Other;

import java.util.*;
class Rectangle {
    public int top;
    public Rectangle(int top) {
        this.top = top;
        System.out.println((int)1.1);
    }
}

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minQueue.size() < k || num > minQueue.peek())
                minQueue.offer(num);
            if (minQueue.size() > k)
                minQueue.poll();
        }
        return minQueue.peek();
    }

    public String[] findKthMost(String[] urls, int k) {
        Map<String, Integer> urlMap = new HashMap<>();
        for (String url: urls) {
            urlMap.put(url, 1 + urlMap.getOrDefault(url, 0));
        }
        PriorityQueue<Map.Entry<String, Integer>> urlQueue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) return 1;
                else if (o1.getValue() == o2.getValue()) return 0;
                else return 0;
            }
        });
        Iterator<Map.Entry<String, Integer>> iter = urlMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> currEntry = iter.next();
            if (urlQueue.size() < k || currEntry.getValue() > urlQueue.peek().getValue())
                urlQueue.offer(currEntry);
            if (urlQueue.size() > k)
                urlQueue.poll();
        }

        for (Map.Entry<String, Integer> entry: urlMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        String[] res = new String[k];
        int index = 0;
        System.out.println("\nqueue size:\t" + urlQueue.size());
        for (Map.Entry<String, Integer> entry: urlQueue) {
            res[index ++] = entry.getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4, 1, 3, 5, 10, 22, 2, 45, 67 ,1324, 12 , 123  , 12124 , 14,654,77, 65346};
        System.out.println(new KthLargest().findKthLargest(nums, 5));
        Arrays.sort(nums);
        for (int num: nums)
            System.out.print(num + " ");

        String[] urls = {
                "a",
                "a",
                "a",
                "b",
                "b",
                "b",
                "b",
                "c",
                "c",
                "c",
                "c",
                "c",
                "d",
                "d",
                "d",
                "d",
                "d",
                "e",
                "f",
                "f",
                "f",
                "f",
                "f",
                "f",
                "f",
                "f",
                "f",
                "f",
                "f",
                "f"
        };
        String[] res = new KthLargest().findKthMost(urls, 3);
        for (String url: res) {
            System.out.println(url);
        }
    }
}
