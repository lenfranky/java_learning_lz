package LeetCode;

import java.util.*;

public class No438 {
    /*
    // 不能处理重复的元素
    // badcese: "baa" "aa"
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0) return res;

        Map<Integer, Set<Character>> indexMap = new HashMap<>();

        Set<Character> pSet = new HashSet<>();
        for (char c: p.toCharArray()) pSet.add(c);

        for (int index = 0; index < s.length(); index ++) {
            if (pSet.contains(s.charAt(index))) {
                Set<Character> currSet = new HashSet<>();
                for (char c: p.toCharArray()) currSet.add(c);
                currSet.remove(s.charAt(index));
                indexMap.put(index, currSet);

                Object[] keySetArray = indexMap.keySet().toArray();


                for (int j = 0; j < keySetArray.length; j ++) {
                    int i = (Integer)keySetArray[j];
                    if (i != index && !indexMap.get(i).contains(s.charAt(index))){
                        indexMap.remove(i);
                        continue;
                    }
                    indexMap.get(i).remove(s.charAt(index));
                    if (indexMap.get(i).size() == 0) {
                        indexMap.remove(i);
                        res.add(i);
                    }
                }

            }
            else {
                indexMap.clear();
            }
        }

        return res;
    }
    */


    /*
    // badcase: "acdcaeccde" "c"
    // badcase: "a" * n (n is very large)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0) return res;

        Map<Integer, List<Character>> indexMap = new HashMap<>();

        List<Character> pList = new ArrayList<>();
        for (char c: p.toCharArray()) pList.add(c);

        for (int index = 0; index < s.length(); index ++) {
            if (pList.contains(s.charAt(index))) {
                List<Character> currList = new ArrayList<>();
                for (char c: p.toCharArray()) currList.add(c);
                currList.remove(currList.indexOf(s.charAt(index)));
                indexMap.put(index, currList);

                Object[] keySetArray = indexMap.keySet().toArray();

                for (int j = 0; j < keySetArray.length; j ++) {
                    int i = (Integer)keySetArray[j];
                    if (i != index && !indexMap.get(i).contains(s.charAt(index))){
                        indexMap.remove(i);
                        continue;
                    }
//                    System.out.println(s.charAt(index));
//                    System.out.println(indexMap.get(i));
                    if (index != i) indexMap.get(i).remove(indexMap.get(i).indexOf(s.charAt(index)));
                    if (indexMap.get(i).size() == 0) {
                        indexMap.remove(i);
                        res.add(i);
                    }
                }

            }
            else {
                indexMap.clear();
            }
        }

        return res;
    }
    */


    // 在p中的字母的哈希值的位置的值在0 - n 之间波动
    // 而其它字母的哈希值的位置的值在-1 - 0 之间波动
    // count 可以认为是已经找到的属于p的字母的数量
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || s.length() < p.length()) return res;
        int[] hash = new int[256];
        for (char c: p.toCharArray()) hash[c] ++;

        int left = 0, right = 0;
        int count = p.length();
        while(right < left + p.length()) {
            if (hash[s.charAt(right)] > 0) {
                count --;
            }
            hash[s.charAt(right)] --;
            right ++;
        }

        for (; right < s.length(); right ++, left ++) {
            System.out.println(count);
//            print(hash);
            if (hash[s.charAt(right)] > 0) {
                count --;
            }
            hash[s.charAt(right)] --;
            if (count == 0) res.add(left);

            if (hash[s.charAt(left)] >= 0) count ++;
            hash[s.charAt(left)] ++;
        }

        return res;
    }

    public static void print(int[] list) {
        for (int i = 0; i < list.length; i ++) {
            System.out.print((char)i + ":" + list[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(new No438().findAnagrams("cbaebabacd", "abc"));
    }
}
