package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class No169 {
    public int majorityElementOld(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int targetLength = nums.length / 2;
        int currFreq;
        for (int num: nums) {
            currFreq = freqMap.getOrDefault(num, 0) + 1;
            if (currFreq > targetLength) return num;
            freqMap.put(num, currFreq);
        }
        return -1;
    }

    public int majorityElement(int[] nums) {
        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;

        }
        return major;
    }

    public static void main(String[] args) {
        System.out.println(new No169().majorityElement(new int[] {2,4,2,4,2,4,5,4}));
    }
}
