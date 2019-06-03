package LeetCode;

import java.util.LinkedList;
import java.util.List;

import static learning_java.GrammarTest.IOTools.print;

public class No97 {
    // 超时了
    public boolean isInterleaveOld(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        List<int[]> last = new LinkedList<>();
        List<int[]> cur = new LinkedList<>();
        List<int[]> temp;
        last.add(new int[] {-1, -1});
        for (int i = 0; i < s3.length(); i ++) {
            cur.clear();
            for (int[] index: last) {
                if (index[0] < s1.length() - 1 && s1.charAt(index[0] + 1) == s3.charAt(i)) {
                    cur.add(new int[] {index[0] + 1, index[1]});
                }
                if (index[1] < s2.length() - 1 && s2.charAt(index[1] + 1) == s3.charAt(i)) {
                    cur.add(new int[] {index[0], index[1] + 1});
                }
            }
//            for (int[] index: cur) {
//                print(index);
//            }
            if (cur.size() == 0) return false;
            temp = last;
            last = cur;
            cur = temp;
        }
        return last.size() > 0;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < dp.length; i ++) {
            for (int j = 0; j < dp[0].length; j ++) {
                if (i == 0 && j ==0) continue;
                dp[i][j] = (i > 0 ? (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1))) : false) || (j > 0 ? (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1))) : false);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    /*
    "a"
    "b"
    "a"

    "abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb"
    "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc"
    "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc"
     */
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.println(new No97().isInterleave(s1, s2, s3));
    }
}
