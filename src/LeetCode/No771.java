package LeetCode;

import static Tools.IOTools.print;

public class No771 {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        for (char charInJ: J.toCharArray()) {
            for (char charInS: S.toCharArray()) {
                if (charInJ == charInS) res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        print(new No771().numJewelsInStones("aA", "aAAbbbb"));
    }
}
