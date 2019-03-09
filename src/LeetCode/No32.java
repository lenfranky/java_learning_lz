package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No32 {
    public int longestValidParentheses_3(String s) {
        int currentLength = 0;
        int maxLength = 0;
        int stackLength = 0;
        boolean isMax = false;

        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                stackLength ++;
            }
            else {
                if (stackLength != 0) {
                    currentLength ++;
                    stackLength --;
                        if (currentLength > maxLength) {
                            maxLength = currentLength;
                            isMax = true;
                        }
                        else {
                            isMax = false;
                        }
                }
                else {
                    currentLength = 0;
                }
            }
        }
        if (isMax)
            return (maxLength - stackLength) * 2;
        else
            return maxLength;
    }

    // stack中最后剩下的数字相当于未成功配对的括号的index
    int longestValidParentheses_2(String s) {
        int n = s.length(), longest = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') st.push(i);
            else {
                if (!st.empty()) {
                    if (s.charAt(st.peek()) == '(') st.pop();
                    else st.push(i);
                }
                else st.push(i);
            }
        }
        if (st.empty()) longest = n;
        else {
            int a = n, b = 0;
            while (!st.empty()) {
                b = st.peek(); st.pop();
                longest = Math.max(longest, a-b-1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }

    /*
     思路：
     1）用一个栈来存放'('的数量，并没有显式的栈，而是用一个stackLength变量来模拟栈的长度。若出现一个')'则出栈一个，若出之前栈为0
     则说明往前数不是一个有效括号序列。
     用一个字典来存放索引，存放的规则为：每次栈的长度上升时，则更新目前序列长度的键值，在下降时，则找到字典中与下降后当前序列长度
     作为键的值的索引，两者相减，则是到当前')'的最长的有效序列的长度。

      */

    public int longestValidParentheses(String s) {
        if (s.equals("")) return 0;
        int stackLength = 0, currentIndex = 0, maxLength = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1);
        for (; currentIndex < s.length(); currentIndex ++) {
            if (s.charAt(currentIndex) == '(') {
                stackLength++;
                indexMap.put(stackLength, currentIndex);
            }
            else {
                if (stackLength > 0) {
                    stackLength --;
                    if (currentIndex - indexMap.get(stackLength) > maxLength)
                        maxLength = currentIndex - indexMap.get(stackLength);
//                    indexMap.put(stackLength, currentIndex);
                }
                else {
                    indexMap.put(0, currentIndex);
                    stackLength = 0;
                }
            }
        }
        return maxLength;
    }

    public static void main(String args[]) {
        No32 solution = new No32();
        String s = "())()(()(";
//        s = "(()";
//        s = ")()())";
        System.out.println(solution.longestValidParentheses(s));
    }
}
