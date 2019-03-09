package LeetCode;

import java.util.LinkedList;

public class No394 {
    public String decodeString(String s) {
        if (s.length() == 0) return "";
        LinkedList<Integer> indexStack = new LinkedList<>();
        char[] chars = s.toCharArray();
        int startIndex;
        String[] strings = new String[chars.length];
        String currString;
        int lastCharIndex = 0;
        int currNum = 0;
        for (int i = 0; i < chars.length; i ++) {
            currNum = 0;
            while (chars[i] < 59 && chars[i] >= 48) {
                currNum = currNum * 10 + (chars[i] - 48);
                strings[i] = String.valueOf(currNum);
                if (i < chars.length - 1)
                    i ++;
            }
            if (currNum == 0)
                strings[i] = String.valueOf(chars[i]);
        }
        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] == '[')
                indexStack.push(i);
            else if (chars[i] == ']') {
                if (!indexStack.isEmpty()) {
                    startIndex = indexStack.poll();
                    currString = "";
                    for (int j = startIndex + 1; j < i; j ++) {
                        if (chars[j] != '[' && chars[j] != ']' && chars[j] > 58)
                            currString += strings[j];
                    }
                    lastCharIndex = i - 1;
                    while(chars[lastCharIndex] == ']')
                        lastCharIndex --;
//                    System.out.println(strings[startIndex - 1]);
                    for (int j = 0; j < Integer.valueOf(strings[startIndex - 1]) - 1; j ++) {
                        strings[lastCharIndex] += currString;
                    }
                }
                else
                    return "";
            }
        }

        String res = "";
        for (int i = 0; i < strings.length; i ++) {
            if (chars[i] != '[' && chars[i] != ']' && chars[i] > 58)
                res += strings[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("100"));
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";
        String s4 = "100[leetcode]";
        System.out.println(new No394().decodeString(s4));
    }
}
