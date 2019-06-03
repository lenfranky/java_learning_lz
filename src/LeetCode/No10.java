package LeetCode;

/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 */

// badcase:
// "aaa"   "a*a"
// "aaa"
//"ab*a*c*a"

//"aaca"
//"ab*a*c*a"
// true

import java.util.LinkedList;
import java.util.List;

public class No10 {
    public boolean isMatchOld(String s, String p) {
        return isMatchBackTracking(s, p, 0, 0);
    }

    public boolean isMatchBackTracking(String s, String p, int sp, int pp) {
//        print (sp);
//        print (pp);
        if (sp >= s.length()) {
            while ((pp < p.length() && p.charAt(pp) == '*') || (pp + 1 < p.length() && p.charAt(pp + 1) == '*'))
                pp ++;
            return (pp >= p.length());
        }
        if (pp >= p.length()) return false;

        if (pp + 1 < p.length() && p.charAt(pp + 1) == '*') {
            if (isMatchBackTracking(s, p, sp, pp + 2))
                return true;
            if (match(s.charAt(sp), p.charAt(pp))) {
                sp++;
                for (; sp < s.length(); sp++) {
                    if (!match(s.charAt(sp), p.charAt(pp)))
                        return isMatchBackTracking(s, p, sp, pp + 2);
                    if (isMatchBackTracking(s, p, sp, pp)) {
                        return true;
                    }
                    if (isMatchBackTracking(s, p, sp + 1, pp + 2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        else {
            if (!match(s.charAt(sp), p.charAt(pp)))
                return false;
            return isMatchBackTracking(s, p, sp + 1, pp + 1);
        }
    }

    public boolean match(char sc, char pc) {
        return sc == pc || pc == '.';
    }

    /*
    使用递归的方法，具体为：判断s与p的起始部分是否符合要求，若符合则不断缩短s、p的长度
    递归结束的条件：
        1）若p的长度有为0：
            a）若都为0，则返回true
            b）若s的长度不为0，则返回false
        2）若p的长度为1：
            a）若s的长度为1，若匹配则返回true，否则返回false
            b）返回false
        3）若p的长度大于等于2：
            a）若p的第二个字符不为"*"，则判断第一个字符是否符合，若符合则将两个字符串各向后移一位，进入递归判断
            b）若p的第二个字符为"*"，进入递归：
                I）若s的长度为0，则将p向后移动2位
                II）若s与p的第一个字母相匹配：
                    1）s不动，p向后移动2位
                    2）s向后移1位，p向后移动2位
                    3)s向后移1位，p不向后移动
                III）若s与p的第一个字母不匹配：
                    s不动，p向后移动2位
     */

    public boolean isMatchRecursive(String s, String p) {
//        System.out.println(s + "  " + p);
        if (p.length() == 0) {
            return s.length() == 0;
        }
        else if (p.length() == 1) {
            if(s.length() == 1) {
                return match(s.charAt(0), p.charAt(0));
            }
            else return false;
        }
        else {
            if (p.charAt(1) != '*') {
                return s.length() >= 1 && match(s.charAt(0), p.charAt(0)) && isMatchRecursive(s.substring(1), p.substring(1));
            }
            else {
//                System.out.println(s + "  " + p);
                if (s.length() == 0)
                    return isMatchRecursive(s, p.substring(2));
                else if (match(s.charAt(0), p.charAt(0)))
                    return isMatchRecursive(s, p.substring(2)) || isMatchRecursive(s.substring(1), p) || isMatchRecursive(s.substring(1), p.substring(2));
                else
                    return isMatchRecursive(s, p.substring(2));
            }
        }
    }


    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        if (p.length() == 0) return false;
        int s_length = s.length();
        int p_length = p.length();
        boolean[][] dp = new boolean[s_length + 1][p_length + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s_length; i ++) {
            for (int j = 1; j <= p_length; j ++) {
                if (p.charAt(j - 1) != '*')
                    dp[i][j] = i != 0 && dp[i - 1][j - 1] && match(s.charAt(i - 1), p.charAt(j - 1));
                else
                    dp[i][j] = i != 0 && dp[i - 1][j] && match(s.charAt(i - 1), p.charAt(j - 2)) || dp[i][j - 2];
            }
        }
//        for (boolean[] line: dp)
//            System.out.println(Arrays.toString(line));
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        List<TestCase> testCases = new LinkedList<>();
        testCases.add(new TestCase("aa", "a", false));
        testCases.add(new TestCase("aa", "a*", true));
        testCases.add(new TestCase("ab", ".*", true));
        testCases.add(new TestCase("aab", "c*a*b", true));
        testCases.add(new TestCase("mississippi", "mis*is*p*.", false));
        testCases.add(new TestCase("aaa", "a*a", true));
        testCases.add(new TestCase("aaa", "ab*a*c*a", true));
        testCases.add(new TestCase("aaca", "ab*a*c*a", true));
        testCases.add(new TestCase("mississippi", "mis*is*ip*.", true));
        testCases.add(new TestCase("ppi", "p*.", true));
        testCases.add(new TestCase("mississippi", "mis*is*ip*.", true));
        testCases.add(new TestCase("a", "ab*", true));
        testCases.add(new TestCase("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c", false));
        testCases.add(new TestCase("caaab", "ca*b", true));


        No10 solution = new No10();

        for (TestCase testCase: testCases) {
            boolean res = solution.isMatch(testCase.s, testCase.p);
            System.out.println("currentRes: " + res + "\texpectedRes: " + testCase.res + "\t\ts: " + testCase.s + "\t\t\tp: " + testCase.p + (res == testCase.res ? "" : "\t\t\t\t\tWrongAnser"));
        }
    }
}


class TestCase {
    public String s, p;
    public boolean res;
    public TestCase(String s, String p, boolean res) {
        this.s = s;
        this.p = p;
        this.res = res;
    }
}