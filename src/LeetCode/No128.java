package LeetCode;


import java.util.HashMap;
import java.util.Map;

public class No128 {
    /*
    badcase: [1, 2, 0, 1]
    [2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645]
     */
//    public int longestConsecutive(int[] nums) {
//        if (nums.length == 0) return 0;
//        int res = 0;
//        int max_value = Integer.MIN_VALUE;
//        int min_value = Integer.MAX_VALUE;
//        for (int num: nums) {
//            max_value = Math.max(max_value, num);
//            min_value = Math.min(min_value, num);
//        }
//
//        int[] consecutiveNumArray = new int[max_value - min_value + 3];
//        int currValue = 0;
//
//        for (int num: nums) {
//            if (consecutiveNumArray[num - min_value + 1] > 0) continue;
//            currValue = 1 + consecutiveNumArray[num - min_value] + consecutiveNumArray[num - min_value + 2];
//            consecutiveNumArray[num - min_value + 1] = currValue;
////            print(num - min_value);
////            print(consecutiveNumArray[num - min_value]);
//            consecutiveNumArray[num - min_value + 1 - consecutiveNumArray[num - min_value]] = currValue;
//            consecutiveNumArray[num - min_value + 1 + consecutiveNumArray[num - min_value + 2]] = currValue;
//            res = Math.max(res, currValue);
////            print(consecutiveNumArray);
//        }
////        print(consecutiveNumArray);
//        return res;
//    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> numConsecutiveMap = new HashMap<>();
        int res = 0;
        int currRes = 0;
        int leftLength = 0;
        int rightLength = 0;
        for (int num: nums) {
            if (numConsecutiveMap.containsKey(num)) continue;
            leftLength = numConsecutiveMap.getOrDefault(num - 1, 0);
            rightLength = numConsecutiveMap.getOrDefault(num + 1,0);
            currRes = leftLength + rightLength + 1;
            // 更新map
            numConsecutiveMap.put(num, currRes);
            numConsecutiveMap.put(num - leftLength, currRes);
            numConsecutiveMap.put(num + rightLength, currRes);
            // 更新最大值
            if (currRes > res) res = currRes;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 0, 1};
        int[] nums = {2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645};
        System.out.println(new No128().longestConsecutive(nums));
    }
}
