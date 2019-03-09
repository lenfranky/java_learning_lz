package LeetCode;

import java.util.*;

public class No139 {
    /*
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
        ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
        超时
     */
    public boolean wordBreakWithBackTracking(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        if (wordDict.size() == 0) return false;
        Collections.sort(wordDict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) return -1;
                else if(o1.length() < o2.length()) return 1;
                else return 0;
            }
        });
        System.out.println(wordDict);
        return backTracking(s, wordDict, 0);
    }

    public boolean backTracking(String s, List<String> wordDict, int startIndex) {
        if(startIndex == s.length()) return true;
        for (String subString: wordDict) {
//            System.out.println(s.substring(startIndex, startIndex + subString.length()));
//            System.out.println(subString);
            if (s.length() - startIndex >= subString.length() && s.substring(startIndex, startIndex + subString.length()).equals(subString)){
                if (backTracking(s, wordDict, startIndex + subString.length())) return true;
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        if (wordDict.size() == 0) return false;
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        for (int i = 0; i < s.length(); i ++) {
            for (String candidate: wordDict) {
                if (i + 1 < candidate.length()) continue;
                if (canBreak[i - candidate.length() + 1] && s.substring(i - candidate.length() + 1, i + 1).equals(candidate)) {
                    canBreak[i + 1] = true;
                    break;
                }
            }
        }
        return canBreak[canBreak.length - 1];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList(new String[] {
                "leet", "code"
        }));
//        System.out.println(wordDict);
        System.out.println(new No139().wordBreak(s, wordDict));
    }
}
