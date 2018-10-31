package LeetCode;

import java.util.*;

public class No49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        char[] currentStr;
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            currentStr = str.toCharArray();
            Arrays.sort(currentStr);
            String currentKey = String.valueOf(currentStr);
            if (map.containsKey(currentKey)) {
                map.get(currentKey).add(str);
            }
            else {
                List<String> currentRes = new ArrayList<>();
                currentRes.add(str);
                res.add(currentRes);
                map.put(currentKey, currentRes);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new No49().groupAnagrams(strs));
    }
}
