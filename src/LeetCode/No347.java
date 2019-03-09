package LeetCode;

import java.util.*;

public class No347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Map<Integer, Integer> numMap = new HashMap<>(k);
        for (int num: nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        List<int[]> entryList = new ArrayList<>();
        Iterator iter = numMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            entryList.add(new int[] {(int)entry.getKey(), (int)entry.getValue()});
        }
        // 注意需要倒序排序，因为需要最大的数字在最前面
        Collections.sort(entryList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) return -1;
                else if (o1[1] == o2[1]) return 0;
                else return 1;
            }
        });
        for (int i = 0; i < k; i ++) {
            res.add(entryList.get(i)[0]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No347().topKFrequent(new int[] {1, 2,2, 3,3,3, 4,4,4,4, 5,5,5,5,5}, 2));
    }
}
