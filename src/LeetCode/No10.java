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
    public boolean isMatch(String s, String p) {
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

        No10 solution = new No10();

        for (TestCase testCase: testCases) {
            boolean res = solution.isMatch(testCase.s, testCase.p);
            System.out.println("currentRes: " + res + "\texpectedRes: " + testCase.res + "\t\ts: " + testCase.s + "\tp: " + testCase.p + (res == testCase.res ? "" : "\t\t\t\t\t\t\tWrongAnser"));
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