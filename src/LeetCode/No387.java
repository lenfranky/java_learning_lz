package LeetCode;

import static Tools.IOTools.print;

public class No387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] charCount = new int[26];
        char[] chars = s.toCharArray();
        for (char c: chars) {
            charCount[c - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i ++) {
            if (charCount[chars[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "loveleetcode";
        print(new No387().firstUniqChar(str));
    }
}
