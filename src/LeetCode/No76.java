package LeetCode;

public class No76 {
    public String minWindowTwo(String s, String t) {
        if (s == null || t == null) return "";
        // total number of character in p to be contained in s
        int countToBeContained = t.length(), minLen = Integer.MAX_VALUE, startIndex = -1;
        // calculate the number of each character to be contained in S
        int[] dict = new int[128];
        for (char c : t.toCharArray()) dict[c]++;

        int fast = 0, slow = 0;
        while (fast < s.length()) {
            // if need to be contained, include it and minus the counter
            if (dict[s.charAt(fast++)]-- > 0)
                countToBeContained--;

            // all included, move the slow pointer to minimize the window
            while (countToBeContained == 0) {
                // current window contains same number of the current character as in t, cannot move forward anymore
                if (dict[s.charAt(slow++)]++ == 0) countToBeContained++;

                // update minLen
                if (fast - slow + 1 < minLen) {
                    startIndex = slow - 1;
                    minLen = fast - slow + 1;
                }
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }

    public String minWindow(String s, String t) {
        if (s == "" || t == "" ) return "";
        int left = 0, right = 0, startIndex = -1, length = Integer.MAX_VALUE;
        int count = t.length();
        int[] map = new int[128];

        for (char c: t.toCharArray())
            map[c] += 1;

        while (right < s.length()) {
            if (map[s.charAt(right)] > 0) {
                count --;
            }
            map[s.charAt(right)] --;

            while (count == 0) {
                if (map[s.charAt(left)] == 0) {
                    count ++;
                }
                map[s.charAt(left)] ++;
                if (right - left + 1 < length) {
                    length = right - left + 1;
                    startIndex = left;
                }
                left ++;
            }
            right ++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + length);
    }

    public static void main(String[] args) {
        System.out.println(new No76().minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
